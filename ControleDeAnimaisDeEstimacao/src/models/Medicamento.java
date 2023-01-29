package models;

import enumerate.Intervalo;

public abstract class Medicamento {
	private String nomeMedicamento;
	private String data;
	private int periodo;
	private Intervalo intervalo;
	private String anotacoes;
	
	public Medicamento(String nomeMedicamento, String data, int periodo, Intervalo intervalo, String anotacoes) {
		this.nomeMedicamento = nomeMedicamento;
		this.data = data;
		this.periodo = periodo;
		this.intervalo = intervalo;
		this.anotacoes = anotacoes;
	}
	
	public Medicamento(String nomeMedicamento, String data) {
		this.nomeMedicamento = nomeMedicamento;
		this.data = data;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public Intervalo getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Intervalo intervalo) {
		this.intervalo = intervalo;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	
	
}

