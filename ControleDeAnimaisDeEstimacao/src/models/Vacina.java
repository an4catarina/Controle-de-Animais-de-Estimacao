package models;

import java.util.Date;

import enumerate.Intervalo;

public class Vacina extends Medicamento {
	private int lote;
	private String laboratorio;
	private boolean necRevacinar;
	
	public Vacina(int lote, String laboratorio, boolean necRevacinar, String nomeMedicamento, Date data, int periodo, Intervalo intervalo, String anotacoes) {
		super(nomeMedicamento, data, periodo, intervalo, anotacoes);
		this.lote = lote;
		this.laboratorio = laboratorio;
		this.necRevacinar = necRevacinar;
	}
	
	public int getLote() {
		return lote;
	}
	public void setLote(int lote) {
		this.lote = lote;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public boolean isNecRevacinar() {
		return necRevacinar;
	}
	public void setNecRevacinar(boolean necRevacinar) {
		this.necRevacinar = necRevacinar;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vacina: " + getNomeMedicamento() + "\n");
		sb.append("Data: " + getData() + "\n");
		sb.append("Lote: " + lote + "\n");
		sb.append("Laboratório: " + laboratorio + "\n");
		sb.append("Necessário revacinar? " + necRevacinar + "\n");
		sb.append("Em um período de " + getPeriodo() + " " + getIntervalo());
		sb.append("\n");
		
		return sb.toString();
	}
}
