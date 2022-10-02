package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Jogos;
import persistence.GenericDao;
import persistence.IJogosDao;
import persistence.JogosDao;

@WebServlet("/jogos")
public class JogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JogoServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String botao = request.getParameter("botao");
		
		Jogos j = new Jogos();
		
		GenericDao gDao = new GenericDao();
		IJogosDao gruDao = new JogosDao(gDao);
		String erro = "";
		String saida = "";
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		try {
			
			if(botao.equals("Enviar")) {
				jogos = gruDao.consultaData(j);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("jogos.jsp");
			request.setAttribute("Jogos", j);
			request.setAttribute("jogos", jogos);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida); 
			rd.forward(request, response);
		}
		
	}

}
