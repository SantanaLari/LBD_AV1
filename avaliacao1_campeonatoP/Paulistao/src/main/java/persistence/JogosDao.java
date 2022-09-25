package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Jogos;

public class JogosDao implements IJogosDao {

	private GenericDao gDao;
	
		public JogosDao (GenericDao gDao) {
			this.gDao = gDao;
		}
	
	DateFormat f = DateFormat.getDateInstance();	
		
	@Override
	public String criarJogos(Jogos j) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,j.getCodigoTimeA());
		ps.setInt(2,j.getCodigoTimeB());
		ps.setInt(3,j.getGolsTimeA());
		ps.setInt(4,j.getGolsTimeB());
		ps.execute();
		ps.close();
		c.close(); 
		
		return "Jogos criados com sucesso.";
	}

	@Override
	public String excluirJogos(Jogos j) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE jogos";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,j.getCodigoTimeA());
		ps.setInt(2,j.getCodigoTimeB());
		ps.setInt(3,j.getGolsTimeA());
		ps.setInt(4,j.getGolsTimeB());
		ps.setDate(5,(Date) j.getData());
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

			jogos.add(j);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return jogos;
	}
}