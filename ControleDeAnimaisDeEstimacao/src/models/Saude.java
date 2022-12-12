package models;

import java.util.List;

public class Saude {
	private List<Vacina> vacinas;
	private List<Remedio> remedios;
	
	
	public Saude(List<Vacina> vacinas, List<Remedio> remedios) {
		super();
		this.vacinas = vacinas;
		this.remedios = remedios;
	}
	
	public List<Vacina> getVacinas() {
		return vacinas;
	}
	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}
	public List<Remedio> getRemedios() {
		return remedios;
	}
	public void setRemedios(List<Remedio> remedios) {
		this.remedios = remedios;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vacinas: " + vacinas + "\n");
		sb.append("Remédios: " + remedios + "\n");
		
		return sb.toString();
	}
	
}
