package models;

import java.util.ArrayList;

import enumerate.Especie;
import enumerate.Genero;
import enumerate.Porte;

/**
 * classe responsável por criar o Animal;
 * 
 * @param nome
 * @param especie
 * @param raca
 * @param genero
 * @param idade
 * @param porte
 * @param vacinas
 * @param remedios
 */
public class Animal {
	private String nome;
	private Especie especie;
	private String raca;
	private Genero genero;
	private int idade;
	private Porte porte;
	private ArrayList<Vacina> vacinas;
	private ArrayList<Remedio> remedios;
	
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

	/**
	 * método responsável por excluir a vacina associada ao animal;
	 * 
	 * @param vacina
	 */
	public void excluirVacina(Vacina vacina) {
		for (int i = 0; i < vacinas.size(); i++) {
			if(vacinas.get(i).equals(vacina)) {
					vacinas.remove(vacinas.get(i));
			}
		}
	}
	
	/**
	 * método responsável por excluir o remédio associado ao animal
	 * @param remedio
	 */
	public void excluirRemedio(Remedio remedio) {
		for (int i = 0; i < remedios.size(); i++) {
			if(remedios.get(i).equals(remedio)) {
					remedios.remove(remedios.get(i));
			}
		}
	}
}

