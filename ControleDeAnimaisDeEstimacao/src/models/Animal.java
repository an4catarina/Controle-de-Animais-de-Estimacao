package models;

import java.util.ArrayList;

import enumerate.Especie;
import enumerate.Genero;
import enumerate.Porte;

public class Animal {
	private String nome;
	private Especie especie;
	private String raca;
	private Genero genero;
	private int idade;
	private Porte porte;
	private ArrayList<Vacina> vacinas;
	private ArrayList<Remedio> remedios;
	
	public Animal() {
		
	}
	
	public Animal(String nome, Especie especie, String raca, Genero genero, int idade, Porte porte, ArrayList<Vacina> vacinas, ArrayList<Remedio> remedios) {
		super();
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.genero = genero;
		this.idade = idade;
		this.porte = porte;
		this.vacinas = vacinas;
		this.remedios = remedios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
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
	
	public void criarAnimal() {
		BancoDeDados.getAnimais().add(this);
	}
	
	public void editarAnimal(String end) {
		for (int i = 0; i <= BancoDeDados.getAnimais().size(); i++) {
			if(BancoDeDados.getAnimais().get(i).getNome().contains(end)) {
				BancoDeDados.getAnimais().set(i, this);
				return;
			}
			BancoDeDados.getAnimais().add(this);
		}
		for (Tutor tutor: BancoDeDados.getTutores()) {
			for(int k = 0; k < tutor.getAnimais().size(); k++) {
				if(tutor.getAnimais().get(k).getNome().equals(end)) {
					tutor.getAnimais().set(k, this);
					}
			}
		}
	}
	
	public void deletarAnimal() {
		for (int i = 0; i < BancoDeDados.getAnimais().size(); i++) {
			if(BancoDeDados.getAnimais().get(i).getNome().equals(this.getNome())) {
				BancoDeDados.getAnimais().remove(i);			}
		}
		for (Tutor tutor: BancoDeDados.getTutores()) {
			for(int k = 0; k < tutor.getAnimais().size(); k++) {
				if(tutor.getAnimais().get(k).getNome().contains(this.getNome())) {
					tutor.getAnimais().remove(k);				}
			}
		}
	}

	public static Animal verAnimal(String nomeAnimal) {
		for (Tutor tutor: BancoDeDados.getTutores()) {
			for(int k = 0; k < tutor.getAnimais().size(); k++) {
				if(tutor.getAnimais().get(k).getNome().equals(nomeAnimal)) {
					return tutor.getAnimais().get(k);
					}
			}
		}
		return null;
		}
}

