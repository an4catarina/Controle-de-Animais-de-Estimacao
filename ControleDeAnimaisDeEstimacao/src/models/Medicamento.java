package models;

import java.util.Date;

import enumerate.Intervalo;

public abstract class Medicamento {
	private String nomeMedicamento;
	private Date data;
	private int periodo;
	private Intervalo intervalo;
	
	public Medicamento(String nomeMedicamento, Date data, int periodo, Intervalo intervalo) {
		this.nomeMedicamento = nomeMedicamento;
		this.data = data;
		this.periodo = periodo;
		this.intervalo = intervalo;
	}
	
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
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

	
	
}

