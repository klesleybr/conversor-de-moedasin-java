package model;

public class MoedasOptions {
	private String sigla;
	
	public MoedasOptions(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public String toString() {
		return getSigla();
	}

}
