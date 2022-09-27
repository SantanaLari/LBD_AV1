package model;

public class Jogos {

	private int codigoTimeA;
	private int codigoTimeB;
	private int golsTimeA;
	private int golsTimeB;
	private String data;
	
	public int getCodigoTimeA() {
		return codigoTimeA;
	}
	public int setCodigoTimeA(int codigoTimeA) {
		return this.codigoTimeA = codigoTimeA;
	}
	public int getCodigoTimeB() {
		return codigoTimeB;
	}
	public int setCodigoTimeB(int codigoTimeB) {
		return this.codigoTimeB = codigoTimeB;
	}
	public int getGolsTimeA() {
		return golsTimeA;
	}
	public void setGolsTimeA(int golsTimeA) {
		this.golsTimeA = golsTimeA;
	}
	public int getGolsTimeB() {
		return golsTimeB;
	}
	public void setGolsTimeB(int golsTimeB) {
		this.golsTimeB = golsTimeB;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Jogos [codigoTimeA=" + codigoTimeA + ", codigoTimeB=" + codigoTimeB + ", golsTimeA=" + golsTimeA
				+ ", golsTimeB=" + golsTimeB + ", data=" + data + "]";
	}
	
}
