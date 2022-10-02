package model;

public class Jogos {

	private Times codigoTimeA;
	private Times codigoTimeB;
	private int golsTimeA;
	private int golsTimeB;
	private int rodadas;
	
	public int getRodadas(int rodada) {
		return rodadas;
	}
	public void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}
	private String data;
	
	public Times getCodigoTimeA() {
		return codigoTimeA;
	}
	public Times setCodigoTimeA(Times codigoTimeA) {
		return this.codigoTimeA = codigoTimeA;
	}
	public Times getCodigoTimeB() {
		return codigoTimeB;
	}
	public Times setCodigoTimeB(Times codigoTimeB) {
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
