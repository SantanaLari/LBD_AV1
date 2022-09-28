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

import model.Grupos;
import model.Times;
import persistence.GenericDao;
import persistence.GrupoDao;
import persistence.IGrupoDao;

@WebServlet("/grupos")
public class GruposServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public GruposServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Grupos gp = new Grupos();
		Times tm = new Times();
		
		GenericDao gDao = new GenericDao();
		IGrupoDao gpDao = new GrupoDao(gDao);
	//	ITimesDao tDao = new TimesDao(gDao);
		List<Grupos> listGP = new ArrayList<Grupos>();
		
		try {
			if(botao.contains("Mostrar Grupo")) {
				listGP = gpDao.consultaGrupos();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("Grupos", gp);
			request.setAttribute("listGP", listGP);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
		
	}

}
