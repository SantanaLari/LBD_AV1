package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupos;
import model.Times;

public class GrupoDao implements IGrupoDao {

	private GenericDao gDao;
	
	public GrupoDao (GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String criarGrupos() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		
		Grupos gp = new Grupos();
		String sql = "{ p_geraGrupo}";
		CallableStatement cs = c.prepareCall(sql);
		
		return null;
	}

	@Override
	public String excluirGrupos() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupos> consultaGrupos() throws SQLException, ClassNotFoundException {
		List<Grupos> grupos = new ArrayList<Grupos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT Grupo, CodigoTime FROM grupos WHERE Grupo = 'A'";
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Grupos g = new Grupos();
			g.setGrupo(rs.getString("Grupo"));
			
			Times t = new Times();
			t.setCodigoTime(rs.getInt("CodigoTime"));
	
			g.setCodigoTime(t);
			
			grupos.add(g);
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return grupos;
	}

}
