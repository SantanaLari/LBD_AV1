package model;

public class Grupos {

	private String grupo;
	private int codigoTime;
	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public int getCodigoTime() {
		return codigoTime;
	}
	public void setCodigoTime(int codigoTime) {
		this.codigoTime = codigoTime;
	}
	@Override
	public String toString() {
		return "Grupos [grupo=" + grupo + ", codigoTime=" + codigoTime + "]";
	}
	
}
