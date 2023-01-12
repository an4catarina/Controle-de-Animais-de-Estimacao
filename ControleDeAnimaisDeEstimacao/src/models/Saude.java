package models;

import java.util.ArrayList;

public class Saude {
	private ArrayList<Vacina> vacinas;
	private ArrayList<Remedio> remedios;
	
	
	public Saude(ArrayList<Vacina> vacinas, ArrayList<Remedio> remedios) {
		super();
		this.vacinas = vacinas;
		this.remedios = remedios;
	}
	
	public ArrayList<Vacina> getVacinas() {
		return vacinas;
	}
	public void setVacinas(ArrayList<Vacina> vacinas) {
		this.vacinas = vacinas;
	}
	public ArrayList<Remedio> getRemedios() {
		return remedios;
	}
	public void setRemedios(ArrayList<Remedio> remedios) {
		this.remedios = remedios;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n Vacinas: \n" + vacinas);
		sb.append("\n");
		sb.append("Remédios: \n" + remedios + "\n");
		
		return sb.toString();
	}
	
}

