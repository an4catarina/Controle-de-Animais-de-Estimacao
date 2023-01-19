package models;

import java.util.Date;

import enumerate.Frequencia;
import enumerate.Intervalo;

public class Remedio extends Medicamento {
	private double dosagem;
	private Frequencia frequencia;
	private int qtdVezes;

	public Remedio(double dosagem, Frequencia frequencia, int qtdVezes, String nomeMedicamento, Date data, int periodo, Intervalo intervalo) {
		super(nomeMedicamento, data, periodo, intervalo);
		this.dosagem = dosagem;
		this.frequencia = frequencia;
		this.qtdVezes = qtdVezes;
	}

	public double getDosagem() {
		return dosagem;
	}

	public void setDosagem(double dosagem) {
		this.dosagem = dosagem;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public int getQtdVezes() {
		return qtdVezes;
	}

	public void setQtdVezes(int qtdVezes) {
		this.qtdVezes = qtdVezes;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome remédio:  " + getNomeMedicamento() + "\n");
		sb.append("Data: " + getData() + "\n");
		sb.append("Dosagem: " + dosagem + "\n");
		sb.append("Frequencia: " + frequencia + "\n");
		sb.append("Qtd: " + qtdVezes + "\n");
		sb.append("Em um período de " + getPeriodo() + " " + getIntervalo() + "\n");
		
		return sb.toString();
	}
}
