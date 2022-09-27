package persistence;

import java.sql.SQLException;
import java.util.List;
import model.Grupos;

public interface IGrupoDao {
	
	public String criarGrupos(Grupos g) throws SQLException, ClassNotFoundException;
	public String excluirGrupos(Grupos g) throws SQLException, ClassNotFoundException;
	public List<Grupos> consultaGrupos() throws SQLException, ClassNotFoundException; 
	
}
