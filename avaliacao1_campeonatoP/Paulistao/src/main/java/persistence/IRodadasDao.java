package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Jogos;

public interface IRodadasDao {

	public String criarRodadas() throws SQLException, ClassNotFoundException;
	public String excluirRodadas() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada1() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada2() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada3() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada4() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada5() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada6() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada7() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada8() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada9() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada10() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada11() throws SQLException, ClassNotFoundException;
	public List<Jogos> consultaRodada12() throws SQLException, ClassNotFoundException;
	
}
