package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Grupos;
import model.Jogos;

public class JogosDao implements IJogosDao {

	private GenericDao gDao;
	
		public JogosDao (GenericDao gDao) {
			this.gDao = gDao;
		}
	
	int rodada = 1;
	int CodigoTimaA;
	int CodigoTimaB;	
		
	@Override
	public String criarJogos(Jogos j) throws SQLException, ClassNotFoundException {
		
		Connection c = gDao.getConnection();
		List<Grupos> times = new ArrayList<>();
		
		int timeA[] = new int[4];
		int timeB[] = new int[4];
		int timeC[] = new int[4];
		int timeD[] = new int[4];
		 
		if((((Grupos) times).getGrupo()).equals("A")) {
		     for(int i = 0; i < 5; i++){
		     	timeA[i] = ((Grupos) times).getCodigoTime();
		     }
		}
		 
		if((((Grupos) times).getGrupo()).equals("B")) {
		     for(int i = 0; i < 5; i++){
		     	timeB[i] = ((Grupos) times).getCodigoTime();
		     }
		}
		 
		if((((Grupos) times).getGrupo()).equals("C")) {
		     for(int i = 0; i < 5; i++){
		     	timeC[i] = ((Grupos) times).getCodigoTime();
		     }
		}
		 
		if((((Grupos) times).getGrupo()).equals("D")) {
		     for(int i = 0; i < 5; i++){
		     	timeD[i] = ((Grupos) times).getCodigoTime();
		     }
		}
		 
		if(rodada == 1) {
		
			//jogo1
		    CodigoTimaA = timeA[1];
		    CodigoTimaB = timeB[1];
			auxSQL(j);
			//jogo2
		    CodigoTimaA = timeC[1];
		    CodigoTimaB = timeD[1];
		    auxSQL(j);
		    //jogo3
		    CodigoTimaA = timeA[2];
		    CodigoTimaB = timeC[2];
		    auxSQL(j);
		    //jogo4
		    CodigoTimaA = timeB[2];
		    CodigoTimaB = timeD[2];
		    auxSQL(j);
		    //jogo5
		    CodigoTimaA = timeA[3];
		    CodigoTimaB = timeD[3];
		    auxSQL(j);
		    //jogo6
		    CodigoTimaA = timeD[3];
		    CodigoTimaB = timeC[3];
		    auxSQL(j);
		    //jogo7
		    CodigoTimaA = timeA[4];
		    CodigoTimaB = timeB[4];
		    auxSQL(j);
		    //jogo8
		    CodigoTimaA = timeC[4];
		    CodigoTimaB = timeD[4];
		    auxSQL(j);
		 
		    rodada = rodada + 1;
			
		}
		
		if(rodada == 2) {
		    //jogo1
		    CodigoTimaA = timeA[2];
		    CodigoTimaB = timeB[2];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC[2];
		    CodigoTimaB = timeD[2];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA[3];
		    CodigoTimaB = timeC[3];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeB[3];
		    CodigoTimaB = timeD[3];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA[4];
		    CodigoTimaB = timeD[4];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB[4];
		    CodigoTimaB = timeC[4];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA[1];
		    CodigoTimaB = timeD[1];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeC[1];
		    CodigoTimaB = timeB[1];
		    auxSQL(j);		 

		    rodada = rodada + 1;	
		}
		 
		if(rodada == 3) {
		    //jogo1
		    CodigoTimaA = timeA[3];
		    CodigoTimaB = timeB[3];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC[3];
		    CodigoTimaB = timeD[3];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA[4];
		    CodigoTimaB = timeC[4];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeB[4];
		    CodigoTimaB = timeD[4];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA[1];
		    CodigoTimaB = timeD[3];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB[1];
		    CodigoTimaB = timeC[2];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA[2];
		    CodigoTimaB = timeD[2];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB[2];
		    CodigoTimaB = timeC[1];
		    auxSQL(j);		 

		    rodada = rodada + 1;	
		}
		 
		if(rodada == 4) {
		    //jogo1
		    CodigoTimaA = timeA[4];
		    CodigoTimaB = timeD[3];
		    auxSQL(j);
		    //jogo2
		    CodigoTimaA = timeC[4];
		    CodigoTimaB = timeA[1];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB[1];
		    CodigoTimaB = timeD[4];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC[2];
		    CodigoTimaB = timeD[1];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeB[2];
		    CodigoTimaB = timeA[3];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB[3];
		    CodigoTimaB = timeC[1];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA[2];
		    CodigoTimaB = timeB[4];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD[2];
		    CodigoTimaB = timeC[3];
		    auxSQL(j);		 

		    rodada = rodada + 1;	
		}
		 
		if(rodada == 5) {
		    //jogo1
		    CodigoTimaA = timeB[1];
		    CodigoTimaB = timeA[3];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD[1];
		    CodigoTimaB = timeA[2];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC[1];
		    CodigoTimaB = timeA[1];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC[3];
		    CodigoTimaB = timeA[4];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC[4];
		    CodigoTimaB = timeD[2];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD[3];
		    CodigoTimaB = timeB[2];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC[2];
		    CodigoTimaB = timeB[4];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD[4];
		    CodigoTimaB = timeB[3];
		    auxSQL(j);		 

		    rodada = rodada + 1;
		}
		 
		if(rodada == 6) {
		    //jogo1
		    CodigoTimaA = timeB[2];
		    CodigoTimaB = timeC[4];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeA[1];
		    CodigoTimaB = timeC[3];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeD[2];
		    CodigoTimaB = timeB[3];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD[3];
		    CodigoTimaB = timeA[2];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA[3];
		    CodigoTimaB = timeB[4];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD[4];
		    CodigoTimaB = timeC[2];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeA[4];
		    CodigoTimaB = timeC[1];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD[1];
		    CodigoTimaB = timeB[1];
		    auxSQL(j);
		    
		    rodada = rodada + 1	;
		}
		 
		if(rodada == 7) {
		    //jogo1
		    CodigoTimaA = timeB[3];
		    CodigoTimaB = timeD[1];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeB[4];
		    CodigoTimaB = timeC[3];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC[1];
		    CodigoTimaB = timeD[4];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD[2];
		    CodigoTimaB = timeA[3];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC[4];
		    CodigoTimaB = timeD[3];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeC[2];
		    CodigoTimaB = timeA[1];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeB[2];
		    CodigoTimaB = timeA[4];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeA[2];
		    CodigoTimaB = timeB[1];
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 8) {
		    //jogo1
		    CodigoTimaA = timeB[4];
		    CodigoTimaB = timeA[1];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD[4];
		    CodigoTimaB = timeC[4];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA[3];
		    CodigoTimaB = timeC[2];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeD[3];
		    CodigoTimaB = timeC[3];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeD[4];
		    CodigoTimaB = timeB[2];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeA[4];
		    CodigoTimaB = timeB[4];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC[1];
		    CodigoTimaB = timeA[2];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeD[2];
		    CodigoTimaB = timeB[1];
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 9) {
		    //jogo1
		    CodigoTimaA = timeD[1];
		    CodigoTimaB = timeB[4];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeC[4];
		    CodigoTimaB = timeA[3];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeA[1];
		    CodigoTimaB = timeB[2];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC[2];
		    CodigoTimaB = timeD[3];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA[4];
		    CodigoTimaB = timeB[1];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD[2];
		    CodigoTimaB = timeC[1];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeD[4];
		    CodigoTimaB = timeC[3];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB[3];
		    CodigoTimaB = timeA[2];
		    auxSQL(j);
		    
		    rodada = rodada + 1;	
		}
		 
		if(rodada == 10) {
		    //jogo1
		    CodigoTimaA = timeD[2];
		    CodigoTimaB = timeB[4];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD[3];
		    CodigoTimaB = timeC[1];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB[1];
		    CodigoTimaB = timeC[4];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeA[1];
		    CodigoTimaB = timeB[3];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeC[4];
		    CodigoTimaB = timeA[2];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD[1];
		    CodigoTimaB = timeB[2];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC[2];
		    CodigoTimaB = timeA[4];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeA[3];
		    CodigoTimaB = timeD[4];
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		 
		if(rodada == 11) {
		    //jogo1
		    CodigoTimaA = timeD[3];
		    CodigoTimaB = timeB[4];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeA[4];
		    CodigoTimaB = timeD[4];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeB[4];
		    CodigoTimaB = timeC[4];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC[1];
		    CodigoTimaB = timeA[3];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeD[2];
		    CodigoTimaB = timeA[1];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeB[1];
		    CodigoTimaB = timeC[3];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeD[4];
		    CodigoTimaB = timeA[2];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB[2];
		    CodigoTimaB = timeC[2];
		    auxSQL(j);
		    
		    rodada = rodada + 1;
		}
		if(rodada == 12) { 
		    //jogo1
		    CodigoTimaA = timeD[4];
		    CodigoTimaB = timeA[1];
		    auxSQL(j);		 
		    //jogo2
		    CodigoTimaA = timeD[2];
		    CodigoTimaB = timeA[4];
		    auxSQL(j);		 
		    //jogo3
		    CodigoTimaA = timeC[2];
		    CodigoTimaB = timeB[3];
		    auxSQL(j);		 
		    //jogo4
		    CodigoTimaA = timeC[4];
		    CodigoTimaB = timeA[2];
		    auxSQL(j);		 
		    //jogo5
		    CodigoTimaA = timeA[3];
		    CodigoTimaB = timeD[1];
		    auxSQL(j);		 
		    //jogo6
		    CodigoTimaA = timeD[3];
		    CodigoTimaB = timeB[1];
		    auxSQL(j);		 
		    //jogo7
		    CodigoTimaA = timeC[3];
		    CodigoTimaB = timeB[2];
		    auxSQL(j);		 
		    //jogo8
		    CodigoTimaA = timeB[4];
		    CodigoTimaB = timeC[1];
		    auxSQL(j);		 

		    rodada = rodada + 1;	
		}

		return "Jogos criados com sucesso.";
	}

	@Override
	public String excluirJogos(Jogos j) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,j.getCodigoTimeA());
		ps.execute();
		ps.close();
		c.close(); 
		
		return "Jogos excluídos com sucesso.";
	}
	
	@Override
	public List<Jogos> consultaJogos() throws SQLException, ClassNotFoundException {
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT CodigoTimeA, CodigoTimeB, Data FROM jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Jogos j = new Jogos();
			j.setCodigoTimeA(rs.getInt("CodigoTimeA"));
			j.setCodigoTimeB(rs.getInt("CodigoTimeB"));
			j.setGolsTimeA(rs.getInt("GolsTimeA"));
			j.setGolsTimeB(rs.getInt("GolsTimeB"));
			j.setData(rs.getString("Data"));

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
	
	public void auxSQL(Jogos j) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO jogos VALUES(?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		String sqlA = "EXEC sp_data";
		ps.setInt(1, j.setCodigoTimeA(CodigoTimaA));
		ps.setInt(2, j.setCodigoTimeB(CodigoTimaB));
		ps.setString(5, sqlA);
		
		ps.execute();
		ps.close();
		c.close();
	}
	
}