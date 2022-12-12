package models;

import java.util.Date;

public class Peso {
	private double peso;
	private Date dataRegistro;
	
	public Peso(double peso, Date dataRegistro) {
		this.peso = peso;
		this.dataRegistro = dataRegistro;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Date getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Peso: " + peso + ".");
		sb.append("Data de registro: " + dataRegistro + ". \n");
		
		return sb.toString();
	}
}
