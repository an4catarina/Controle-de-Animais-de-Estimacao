package models;

import enumerate.Dosagem;
import enumerate.Frequencia;

/**
 *  classe que armazena informações de remedios, herda de {@link models.Medicamento};
 * 
 * @author catarina
 *
 */

public class Remedio extends Medicamento {
	private int nroDosagem;
	private Dosagem dosagem;
	private Frequencia frequencia;
	private int qtdVezes;
	private String dataFinal;

	public Remedio(int nroDosagem ,Dosagem dosagem, Frequencia frequencia, String dataFinal, int qtdVezes, String nomeMedicamento,String data) {
		super(nomeMedicamento, data);
		this.setNroDosagem(nroDosagem);
		this.dosagem = dosagem;
		this.frequencia = frequencia;
		this.qtdVezes = qtdVezes;
		this.dataFinal = dataFinal;
	}

	public int getNroDosagem() {
		return nroDosagem;
	}
	
	public void setNroDosagem(int nroDosagem) {
		this.nroDosagem = nroDosagem;
	}
	
	public Dosagem getDosagem() {
		return dosagem;
	}

	public void setDosagem(Dosagem dosagem) {
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
	
	public String getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
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
