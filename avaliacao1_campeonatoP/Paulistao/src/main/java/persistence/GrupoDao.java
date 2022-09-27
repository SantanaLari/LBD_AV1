package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Grupos;

public class GrupoDao implements IGrupoDao {

	private GenericDao gDao;
	
	public GrupoDao (GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public String criarGrupos(Grupos g) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "EXEC p_geraGrupo";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,g.getGrupo());
		ps.setInt(2,g.getCodigoTime());
		ps.execute();
		ps.close();
		c.close();
		
		return "Grupos criados com sucesso.";
	}

	@Override
	public String excluirGrupos(Grupos g) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE grupos";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1,g.getGrupo());
		ps.setInt(2,g.getCodigoTime());
		ps.execute();
		ps.close();
		c.close();
		
		return "Grupos excluídos com sucesso.";
	}

	@Override
	public List<Grupos> consultaGrupos() throws SQLException, ClassNotFoundException {
		List<Grupos> grupos = new ArrayList<Grupos>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT Grupo, CodigoTime FROM grupos";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Grupos g = new Grupos();
			g.setGrupo(rs.getString("Grupo"));
			g.setCodigoTime(rs.getInt("CodigoTime"));

			grupos.add(g);
		}
		ps.execute();
		ps.close();
		c.close();
		
		return grupos;
	}

}
