package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogos;
import model.Times;

public class RodadasDao implements IRodadasDao {

	private GenericDao gDao;
	
	public RodadasDao (GenericDao gDao) {
		this.gDao = gDao;
	}

	int rodada = 1;
	Times CodigoTimaA;
	Times CodigoTimaB;	
		
	@Override
	public String criarRodadas() throws SQLException, ClassNotFoundException {
		Jogos j = new Jogos();
		
		
		List<Times> timeA = new ArrayList<>();
		List<Times> timeB = new ArrayList<>();
		List<Times> timeC = new ArrayList<>();
		List<Times> timeD = new ArrayList<>();
		
		Connection cA = gDao.getConnection();
		StringBuffer sqlA = new StringBuffer();
		sqlA.append("SELECT gp.CodigoTime ");
		sqlA.append("FROM grupos gp INNER JOIN times tm ");
		sqlA.append("ON tm.CodigoTime = gp.CodigoTime");
		sqlA.append("WHERE gp.Grupo = 'A' ");
		PreparedStatement psA = cA.prepareStatement(sqlA.toString());
		ResultSet rsA = psA.executeQuery();
		while(rsA.next()) {
			Times t = new Times();
			t.setCodigoTime(rsA.getInt("CodigoTime"));
	
			timeA.add(t);
		}
		
		Connection cB = gDao.getConnection();
		StringBuffer sqlB = new StringBuffer();
		sqlB.append("SELECT tm.CodigoTime ");
		sqlB.append("FROM grupos gp INNER JOIN times tm ");
		sqlB.append("ON tm.CodigoTime = gp.CodigoTime");
		sqlB.append("WHERE gp.Grupo = 'B' ");
		PreparedStatement psB = cB.prepareStatement(sqlB.toString());
		ResultSet rsB = psB.executeQuery();
		while(rsB.next()) {
			Times t = new Times();
			t.setCodigoTime(rsA.getInt("CodigoTime"));
	
			timeB.add(t);
		}
		
		Connection cC = gDao.getConnection();
		StringBuffer sqlC = new StringBuffer();
		sqlC.append("SELECT tm.CodigoTime ");
		sqlC.append("FROM grupos gp INNER JOIN times tm ");
		sqlC.append("ON tm.CodigoTime = gp.CodigoTime");
		sqlC.append("WHERE gp.Grupo = 'C' ");
		PreparedStatement psC = cC.prepareStatement(sqlC.toString());
		ResultSet rsC = psC.executeQuery();
		while(rsC.next()) {
			Times t = new Times();
			t.setCodigoTime(rsA.getInt("CodigoTime"));
	
			timeC.add(t);
		}
		
		Connection cD = gDao.getConnection();
		StringBuffer sqlD = new StringBuffer();
		sqlD.append("SELECT tm.CodigoTime ");
		sqlD.append("FROM grupos gp INNER JOIN times tm ");
		sqlD.append("ON tm.CodigoTime = gp.CodigoTime");
		sqlD.append("WHERE gp.Grupo = 'D' ");
		PreparedStatement psD = cD.prepareStatement(sqlD.toString());
		ResultSet rsD = psD.executeQuery();
		while(rsD.next()) {
			Times t = new Times();
			t.setCodigoTime(rsA.getInt("CodigoTime"));

			timeD.add(t);
		}
		
		// Adiciona à tabela jogos a coluna "rodadas"
		inserirRodadas();
		
		if(rodada == 1) {
		
			//jogo1
		    CodigoTimaA = timeA.get(0); //timeA 1
		    CodigoTimaB = timeB.get(0); //timeB 1
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
			auxSQL(j);
			//jogo2
		    CodigoTimaA = timeC.get(0); //timeC 1
		    CodigoTimaB = timeD.get(0); //timeD 1
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    //jogo3
		    CodigoTimaA = timeA.get(1); //timeA 2
		    CodigoTimaB = timeC.get(1); //timeC 2
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    //jogo4
		    CodigoTimaA = timeB.get(1); //timeB 2
		    CodigoTimaB = timeD.get(1); //timeD 2
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    //jogo5
		    CodigoTimaA = timeA.get(2); //timeA3
		    CodigoTimaB = timeD.get(2); //timeD3
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    //jogo6
		    CodigoTimaA = timeD.get(2); //timeD4
		    CodigoTimaB = timeC.get(2); //timeC4
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    //jogo7
		    CodigoTimaA = timeA.get(3); //timeA4
		    CodigoTimaB = timeB.get(3); //timeB4
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    //jogo8
		    CodigoTimaA = timeC.get(3); //timeC4
		    CodigoTimaB = timeD.get(3); //timeD4
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		 
		    rodada = rodada + 1;
			
		}
		
		if(rodada == 2) {
		    //jogo1
		    CodigoTimaA = timeA.get(1);
		    CodigoTimaB = timeB.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeD.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeC.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeB.get(2);
		    CodigoTimaB = timeD.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeD.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeC.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeD.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeB.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
	
		    rodada = rodada + 1;	
		}
		 
		if(rodada == 3) {
		    //jogo1
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeB.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC.get(2);
		    CodigoTimaB = timeD.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeC.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeD.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeD.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeC.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA.get(1);
		    CodigoTimaB = timeD.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeC.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
	
		    rodada = rodada + 1;	
		}
		 
		if(rodada == 4) {
		    //jogo1
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeD.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    //jogo2
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeA.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeD.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeD.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeA.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB.get(2);
		    CodigoTimaB = timeC.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA.get(1);
		    CodigoTimaB = timeB.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeC.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
	
		    rodada = rodada + 1;	
		}
		 
		if(rodada == 5) {
		    //jogo1
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeA.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeA.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeA.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(2);
		    CodigoTimaB = timeA.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeD.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeB.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeB.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeB.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
	
		    rodada = rodada + 1;
		}
		 
		if(rodada == 6) {
		    //jogo1
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeC.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeC.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeB.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeA.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeB.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeC.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeC.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeB.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    
		    rodada = rodada + 1	;
		}
		 
		if(rodada == 7) {
		    //jogo1
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeD.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeC.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeD.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeA.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeD.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeA.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeA.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeA.get(1);
		    CodigoTimaB = timeB.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 8) {
		    //jogo1
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeA.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeC.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeC.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeC.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeB.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeB.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeA.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeB.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 9) {
		    //jogo1
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeB.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeA.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeB.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeD.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeB.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeC.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeC.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB.get(2);
		    CodigoTimaB = timeA.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    
		    rodada = rodada + 1;	
		}
		 
		if(rodada == 10) {
		    //jogo1
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeB.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeC.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeC.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeA.get(0);
		    CodigoTimaB = timeB.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeA.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(0);
		    CodigoTimaB = timeB.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeA.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeD.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 11) {
		    //jogo1
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeB.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeA.get(3);
		    CodigoTimaB = timeD.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeC.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(0);
		    CodigoTimaB = timeA.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeA.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB.get(0);
		    CodigoTimaB = timeC.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeA.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB.get(1);
		    CodigoTimaB = timeC.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		if(rodada == 12) { 
		    //jogo1
		    CodigoTimaA = timeD.get(3);
		    CodigoTimaB = timeA.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD.get(1);
		    CodigoTimaB = timeA.get(3);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC.get(1);
		    CodigoTimaB = timeB.get(2);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC.get(3);
		    CodigoTimaB = timeA.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA.get(2);
		    CodigoTimaB = timeD.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD.get(2);
		    CodigoTimaB = timeB.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC.get(2);
		    CodigoTimaB = timeB.get(1);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB.get(3);
		    CodigoTimaB = timeC.get(0);
		    j.setCodigoTimeA(CodigoTimaA);
		    j.setCodigoTimeA(CodigoTimaB);
		    auxSQL(j);		 
	
		    rodada = rodada + 1;	
		}
	
		String saida = "Jogos gerados";
		
		return saida;
	}
	
	@Override
	public String excluirRodadas() throws SQLException, ClassNotFoundException {
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 1 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 2 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 3 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 4 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 5 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 6 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 7 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 8 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 9 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 10 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 11 ";
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
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos WHERE rodadas = 12 ";
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
	
	
	public void inserirRodadas() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("ALTER TABLE jogos ");
		sql.append("ADD rodada int NOT NULL ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
				
		ps.execute();
		ps.close();
		c.close();
	}
	
	public void auxSQL(Jogos j) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO jogos VALUES(?,?,NULL,NULL,?,?) ";
		StringBuffer sqlData = new StringBuffer();
		sqlData.append("EXEC sp_datajogo ");
		PreparedStatement ps = c.prepareStatement(sql);
		PreparedStatement psData = c.prepareStatement(sqlData.toString());
		ps.setInt(1, j.getCodigoTimeA().getCodigoTime());
		ps.setInt(2, j.getCodigoTimeB().getCodigoTime());
		ps.setInt(3, j.getGolsTimeA());
		ps.setInt(4, j.getGolsTimeB());
		psData.setString(5, j.getData());
		ps.setInt(6, j.getRodadas(rodada));
				
		ps.execute();
		ps.close();
		c.close();
	}
	
}
