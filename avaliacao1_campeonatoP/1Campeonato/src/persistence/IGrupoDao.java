package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Grupos;

public interface IGrupoDao {
	
	public String criarGrupos() throws SQLException, ClassNotFoundException;
	public String excluirGrupos() throws SQLException, ClassNotFoundException;
	public List<Grupos> consultaGrupos() throws SQLException, ClassNotFoundException; 
	
}
