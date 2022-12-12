package models;

import java.util.Date;

import enumerate.Intervalo;

public class Remedio extends Medicamento {
	private double dosagem;
	private int frequencia;
	private String horario;
	
	public Remedio(double dosagem, int frequencia, String horario, String nomeMedicamento, Date data, int periodo, Intervalo intervalo) {
		super(nomeMedicamento, data, periodo, intervalo);
		this.dosagem = dosagem;
		this.frequencia = frequencia;
		this.horario = horario;
	
	}

	public double getDosagem() {
		return dosagem;
	}

	public void setDosagem(double dosagem) {
		this.dosagem = dosagem;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Remédio: \n");
		sb.append("Nome: " + getNomeMedicamento() + "\n");
		sb.append("Data: " + getData() + "\n");
		sb.append("Dosagem: " + dosagem + "\n");
		sb.append("Frequencia: " + frequencia + "\n");
		sb.append("Horario: " + horario + "\n");
		sb.append("Em um período de " + getPeriodo() + getIntervalo() + "\n");
		
		return sb.toString();
	}
}
