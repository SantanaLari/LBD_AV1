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
import persistence.IRodadasDao;
import persistence.RodadasDao;

@WebServlet("/rodadas")
public class RodadasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RodadasServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		
		Jogos j = new Jogos();
		
		GenericDao gDao = new GenericDao();
		IRodadasDao rDao = new RodadasDao(gDao);
		
		List<Jogos> rodada1 = new ArrayList<Jogos>();
 		List<Jogos> rodada2 = new ArrayList<Jogos>();
 		List<Jogos> rodada3 = new ArrayList<Jogos>();
 		List<Jogos> rodada4 = new ArrayList<Jogos>();
 		List<Jogos> rodada5 = new ArrayList<Jogos>();
 		List<Jogos> rodada6 = new ArrayList<Jogos>();
 		List<Jogos> rodada7 = new ArrayList<Jogos>();
 		List<Jogos> rodada8 = new ArrayList<Jogos>();
 		List<Jogos> rodada9 = new ArrayList<Jogos>();
 		List<Jogos> rodada10 = new ArrayList<Jogos>();
 		List<Jogos> rodada11 = new ArrayList<Jogos>();
 		List<Jogos> rodada12 = new ArrayList<Jogos>();
		
		
		try {
			if(botao.contains("Criar Rodadas")) {
				saida = rDao.criarRodadas();
				j = new Jogos();
			}
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("rodada.jsp");
			request.setAttribute("Jogos", j);
			request.setAttribute("rodada1", rodada1);
			request.setAttribute("rodada2", rodada2);
			request.setAttribute("rodada3", rodada3);
			request.setAttribute("rodada4", rodada4);
			request.setAttribute("rodada5", rodada5);
			request.setAttribute("rodada6", rodada6);
			request.setAttribute("rodada7", rodada7);
			request.setAttribute("rodada8", rodada8);
			request.setAttribute("rodada9", rodada9);
			request.setAttribute("rodada10", rodada10);
			request.setAttribute("rodada11", rodada11);
			request.setAttribute("rodada12", rodada12);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String erro = "";
		String saida = "";
		
		Jogos j = new Jogos();
		
		GenericDao gDao = new GenericDao();
		IRodadasDao rDao = new RodadasDao(gDao);

		List<Jogos> rodada1 = new ArrayList<Jogos>();
 		List<Jogos> rodada2 = new ArrayList<Jogos>();
 		List<Jogos> rodada3 = new ArrayList<Jogos>();
 		List<Jogos> rodada4 = new ArrayList<Jogos>();
 		List<Jogos> rodada5 = new ArrayList<Jogos>();
 		List<Jogos> rodada6 = new ArrayList<Jogos>();
 		List<Jogos> rodada7 = new ArrayList<Jogos>();
 		List<Jogos> rodada8 = new ArrayList<Jogos>();
 		List<Jogos> rodada9 = new ArrayList<Jogos>();
 		List<Jogos> rodada10 = new ArrayList<Jogos>();
 		List<Jogos> rodada11 = new ArrayList<Jogos>();
 		List<Jogos> rodada12 = new ArrayList<Jogos>();

		
		try {
			
			rodada1 = rDao.consultaRodada1();
			rodada2 = rDao.consultaRodada2();
			rodada3 = rDao.consultaRodada3();
			rodada4 = rDao.consultaRodada4();
			rodada5 = rDao.consultaRodada5();
			rodada6 = rDao.consultaRodada6();
			rodada7 = rDao.consultaRodada7();
			rodada8 = rDao.consultaRodada8();
			rodada9 = rDao.consultaRodada9();
			rodada10 = rDao.consultaRodada10();
			rodada11 = rDao.consultaRodada11();
			rodada12 = rDao.consultaRodada12();
			
		}catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		}finally {
			RequestDispatcher rd = request.getRequestDispatcher("rodada.jsp");
			request.setAttribute("Jogos", j);
			request.setAttribute("rodada1", rodada1);
			request.setAttribute("rodada2", rodada2);
			request.setAttribute("rodada3", rodada3);
			request.setAttribute("rodada4", rodada4);
			request.setAttribute("rodada5", rodada5);
			request.setAttribute("rodada6", rodada6);
			request.setAttribute("rodada7", rodada7);
			request.setAttribute("rodada8", rodada8);
			request.setAttribute("rodada9", rodada9);
			request.setAttribute("rodada10", rodada10);
			request.setAttribute("rodada11", rodada11);
			request.setAttribute("rodada12", rodada12);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			rd.forward(request, response);
		}
	}

}
