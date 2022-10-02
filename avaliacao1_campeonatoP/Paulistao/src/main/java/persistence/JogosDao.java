package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogos;

public class JogosDao implements IJogosDao {


private GenericDao gDao;
	
	public JogosDao (GenericDao gDao) {
		this.gDao = gDao;
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