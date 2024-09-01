package model;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.UnknownCurrencyException;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

public class Conversor {
	private String moedaOrigem, moedaDestino;
	private double valorOrigem, valorDestino;
	
	public Conversor() {
		this.moedaOrigem = "USD";
		this.moedaDestino = "BRL";
	}
	
	public Conversor(String moedaOrigem, String moedaDestino, double valorOrigem) {
		this.moedaOrigem = moedaOrigem;
		this.moedaDestino = moedaDestino;
		this.valorOrigem = valorOrigem;
	}
	
	public String getMoedaOrigem() {
		return moedaOrigem;
	}
	public void setMoedaOrigem(String moedaOrigem) {
		this.moedaOrigem = moedaOrigem;
	}
	
	public double getValorOrigem() {
		return valorOrigem;
	}
	public void setValorOrigem(double valorOrigem) {
		this.valorOrigem = valorOrigem;
	}
	
	public String getMoedaDestino() {
		return moedaDestino;
	}
	public void setMoedaDestino(String moedaDestino) {
		this.moedaDestino = moedaDestino;
	}
	
	public double converterMoeda() {
		if(moedaOrigem == moedaDestino) return -1;
		
		try {
			MonetaryAmount moedaOrigemApi = Monetary.getDefaultAmountFactory().setCurrency(moedaOrigem).setNumber(valorOrigem).create();
			CurrencyConversion moedaDestinoApi = MonetaryConversions.getConversion(moedaDestino);
			MonetaryAmount efetuarConversao = moedaOrigemApi.with(moedaDestinoApi);
			
			String resultadoConversaoInString = efetuarConversao.toString().substring(3);
			this.valorDestino = Double.valueOf(resultadoConversaoInString).doubleValue();
			
			return valorDestino;		
		} catch(UnknownCurrencyException e) {
			return -2;
		} 
	}
}
