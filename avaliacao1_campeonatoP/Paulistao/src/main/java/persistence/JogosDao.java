package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupos;
import model.Jogos;
import model.Times;

public class JogosDao implements IJogosDao {

	private GenericDao gDao;
	
		public JogosDao (GenericDao gDao) {
			this.gDao = gDao;
		}
	
	int rodada = 1;
	Times CodigoTimaA;
	Times CodigoTimaB;	
		
	@Override
	public String criarJogos() throws SQLException, ClassNotFoundException {
		List<Grupos> times = new ArrayList<>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT Grupo, CodigoTime FROM grupos";
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			g.setGrupo(rs.getString("Grupo"));
			
			Times t = new Times();
			t.setCodigoTime(rs.getInt("CodigoTime"));
	
			g.setCodigoTime(t);
			
			times.add(g);
		}
		
		Jogos j = new Jogos();
		
		List<Times> timeA = new ArrayList<>();
		List<Times> timeB = new ArrayList<>();
		List<Times> timeC = new ArrayList<>();
		List<Times> timeD = new ArrayList<>();
		
		Connection cA = gDao.getConnection();
		String sqlA = "SELECT CodigoTime FROM grupos WHERE Grupo = 'A' ";
		PreparedStatement psA = cA.prepareStatement(sqlA.toString());
		ResultSet rsA = psA.executeQuery();
		while(rsA.next()) {
			Times t = new Times();
			t.setCodigoTime(rsA.getInt("CodigoTime"));
	
			timeA.add(t);
		}
		
		Connection cB = gDao.getConnection();
		String sqlB = "SELECT CodigoTime FROM grupos WHERE Grupo = 'B' ";
		PreparedStatement psB = cB.prepareStatement(sqlB.toString());
		ResultSet rsB = psB.executeQuery();
		while(rsB.next()) {
			Times t = new Times();
			t.setCodigoTime(rsB.getInt("CodigoTime"));
	
			timeB.add(t);
		}
		
		Connection cC = gDao.getConnection();
		String sqlC = "SELECT CodigoTime FROM grupos WHERE Grupo = 'C' ";
		PreparedStatement psC = cC.prepareStatement(sqlC.toString());
		ResultSet rsC = psC.executeQuery();
		while(rsC.next()) {
			Times t = new Times();
			t.setCodigoTime(rsC.getInt("CodigoTime"));
	
			timeA.add(t);
		}
		
		Connection cD = gDao.getConnection();
		String sqlD = "SELECT CodigoTime FROM grupos WHERE Grupo = 'D' ";
		PreparedStatement psD = cD.prepareStatement(sqlD.toString());
		ResultSet rsD = psD.executeQuery();
		while(rsD.next()) {
			Times t = new Times();
			t.setCodigoTime(rsD.getInt("CodigoTime"));
	
			timeB.add(t);
		}
		
		inserirRodadas(j);
		
		if(rodada == 1) {
		
			//jogo1
		    CodigoTimaA = timeA.get(0); //timeA 1
		    CodigoTimaB = timeB.get(0); //timeB 1
			auxSQL(j);
			//jogo2
		    CodigoTimaA = timeC.get(0); //timeC 1
		    CodigoTimaB = timeD.get(0); //timeD 1
		    auxSQL(j);
		    //jogo3
		    CodigoTimaA = timeA.get(1); //timeA 2
		    CodigoTimaB = timeC.get(1); //timeC 2
		    auxSQL(j);
		    //jogo4
		    CodigoTimaA = timeB.get(1); //timeB 2
		    CodigoTimaB = timeD.get(1); //timeD 2
		    auxSQL(j);
		    //jogo5
		    CodigoTimaA = timeA.get(2); //timeA3
		    CodigoTimaB = timeD.get(2); //timeD3
		    auxSQL(j);
		    //jogo6
		    CodigoTimaA = timeD.get(2); //timeD4
		    CodigoTimaB = timeC.get(2); //timeC4
		    auxSQL(j);
		    //jogo7
		    CodigoTimaA = timeA.get(3); //timeA4
		    CodigoTimaB = timeB.get(3); //timeB4
		    auxSQL(j);
		    //jogo8
		    CodigoTimaA = timeC.get(3); //timeC4
		    CodigoTimaB = timeD.get(3); //timeD4
		    auxSQL(j);
		 
		    rodada = rodada + 1;
			
		}
		
		if(rodada == 2) {
		    //jogo1
		    CodigoTimaA = timeA.get(1);
		    CodigoTimaB = timeB.get(1);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeD.get(1);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeC.get(2);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeB.get(2);
		    CodigoTimaB = timeD.get(2);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeD.get(3);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeC.get(3);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeD.get(0);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeB.get(0);
		    auxSQL(j);		 

		    rodada = rodada + 1;	
		}
		 
		if(rodada == 3) {
		    //jogo1
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeB.get(2);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC.get(2);
		    CodigoTimaB = timeD.get(0);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeC.get(3);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeD.get(3);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeD.get(2);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeC.get(1);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA.get(1);
		    CodigoTimaB = timeD.get(1);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeC.get(0);
		    auxSQL(j);		 

		    rodada = rodada + 1;	
		}
		 
		if(rodada == 4) {
		    //jogo1
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeD.get(2);
		    auxSQL(j);
		    //jogo2
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeA.get(0);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeD.get(3);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeD.get(0);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeA.get(2);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB.get(2);
		    CodigoTimaB = timeC.get(0);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA.get(1);
		    CodigoTimaB = timeB.get(3);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeC.get(2);
		    auxSQL(j);		 

		    rodada = rodada + 1;	
		}
		 
		if(rodada == 5) {
		    //jogo1
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeA.get(2);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeA.get(1);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeA.get(0);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(2);
		    CodigoTimaB = timeA.get(3);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeD.get(1);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeB.get(1);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeB.get(3);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeB.get(2);
		    auxSQL(j);		 

		    rodada = rodada + 1;
		}
		 
		if(rodada == 6) {
		    //jogo1
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeC.get(3);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeC.get(2);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeB.get(2);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeA.get(1);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeB.get(3);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeC.get(1);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeC.get(0);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeB.get(0);
		    auxSQL(j);
		    
		    rodada = rodada + 1	;
		}
		 
		if(rodada == 7) {
		    //jogo1
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeD.get(0);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeC.get(2);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeD.get(3);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeA.get(2);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeD.get(2);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeA.get(0);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeA.get(3);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeA.get(1);
		    CodigoTimaB = timeB.get(0);
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 8) {
		    //jogo1
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeA.get(0);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeC.get(3);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeC.get(1);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeC.get(2);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeB.get(1);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeB.get(3);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeA.get(1);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeB.get(0);
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 9) {
		    //jogo1
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeB.get(3);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeA.get(2);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeB.get(1);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeD.get(2);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeB.get(0);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeC.get(0);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeC.get(2);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB.get(2);
		    CodigoTimaB = timeA.get(1);
		    auxSQL(j);
		    
		    rodada = rodada + 1;	
		}
		 
		if(rodada == 10) {
		    //jogo1
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeB.get(3); 
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeC.get(0);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeC.get(3);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeB.get(2);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeA.get(1);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeB.get(1);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeA.get(3);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeD.get(3);
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 11) {
		    //jogo1
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeB.get(3);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeD.get(3);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeC.get(3);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeA.get(2);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeA.get(0);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeC.get(2);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeA.get(1);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeC.get(1);
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		if(rodada == 12) { 
		    //jogo1
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeA.get(0);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeA.get(3);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeB.get(2);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeA.get(1);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeD.get(0);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeB.get(0);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC.get(2);
		    CodigoTimaB = timeB.get(1);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeC.get(0);
		    auxSQL(j);		 

		    rodada = rodada + 1;	
		}

		return "Jogos criados com sucesso.";
	}

	@Override
	public String excluirJogos() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.execute();
		ps.close();
		c.close(); 
		
		return "Jogos excluídos com sucesso.";
	}
	
	@Override
	public List<Jogos> consultaRodada1() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT TOP 8 CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada2() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada3() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada4() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada5() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada6() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada7() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada8() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada9() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada10() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada11() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	@Override
	public List<Jogos> consultaRodada12() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Times tA = new Times();
			tA.setCodigoTime(rs.getInt("CodigoTimeA"));
			Times tB = new Times();
			tB.setCodigoTime(rs.getInt("CodigoTimeB"));
			
			Jogos j = new Jogos();
			j.setCodigoTimeA(tA);
			j.setCodigoTimeB(tB);
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	
	public void inserirRodadas(Jogos j) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("ALTER TABLE jogos ");
		sql.append("ADD rodada int NOT NULL");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, j.getCodigoTimeA().getCodigoTime());
		ps.setInt(2, j.getCodigoTimeB().getCodigoTime());
				
		ps.execute();
		ps.close();
		c.close();
	}
	
	public void auxSQL(Jogos j) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO jogos VALUES(?,?,NULL,NULL,?,?)";
		StringBuffer sqlData = new StringBuffer();
		sqlData.append("EXEC sp_datajogo ");
		PreparedStatement ps = c.prepareStatement(sql);
		PreparedStatement psData = c.prepareStatement(sql.toString());
		ps.setInt(1, j.getCodigoTimeA().getCodigoTime());
		ps.setInt(2, j.getCodigoTimeB().getCodigoTime());
		psData.setString(5, j.getData());
		ps.setInt(6, rodada);
				
		ps.execute();
		ps.close();
		c.close();
	}
	
	public List<Jogos> consultaData(Jogos j) throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			j.setData(rs.getString("Data"));
			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
		
	}
	
}