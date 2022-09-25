package persistence;

import java.sql.SQLException;
import java.util.List;
import model.Jogos;

public interface IJogosDao {

	public String criarJogos(Jogos j) throws SQLException, ClassNotFoundException;
	public String excluirJogos(Jogos j) throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaJogos() throws SQLException, ClassNotFoundException;
	
}
