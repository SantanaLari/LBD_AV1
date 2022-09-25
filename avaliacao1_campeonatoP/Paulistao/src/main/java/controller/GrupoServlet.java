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
import persistence.GenericDao;
import persistence.GrupoDao;
import persistence.IGrupoDao;

@WebServlet("/grupo")
public class GrupoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public GrupoServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		GenericDao gDao = new GenericDao();
		IGrupoDao gruDao = new GrupoDao(gDao);
		String erro = "";
 		List<Grupos> grupos = new ArrayList<Grupos>();
 		
 		try {
 			grupos = gruDao.consultaGrupos();
		} catch(ClassNotFoundException | SQLException e){
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("grupo.jsp");
			request.setAttribute("grupos", grupos);
			request.setAttribute("erro", erro);
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String botao = request.getParameter("botao");
		
		Grupos g = new Grupos();
		
		GenericDao gDao = new GenericDao();
		IGrupoDao gruDao = new GrupoDao(gDao);
		String erro = "";
		String saida = "";
		List<Grupos> grupos = new ArrayList<Grupos>();
		
		try {
			
			if(botao.equals("Mostrar")) {
				grupos = gruDao.consultaGrupos();
			}
			
			if(botao.equals("Criar")) {
				saida = gruDao.criarGrupos(g);
			}
			
			if(botao.equals("Excliur")) {
				saida = gruDao.excluirGrupos(g);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("grupo.jsp");
			request.setAttribute("grupo", g);
			request.setAttribute("grupos", grupos);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida); 
			rd.forward(request, response);
		}
		
	}

}
