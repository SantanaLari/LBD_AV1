package persistence;

import java.sql.SQLException;
import java.util.List;
import model.Jogos;

public interface IJogosDao {

	public List<Jogos> consultaData(Jogos j)throws SQLException, ClassNotFoundException;
	
}
