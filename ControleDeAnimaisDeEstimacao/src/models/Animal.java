package models;

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
	private Saude saude;
	
	public Animal() {
		
	}
	
	public Animal(String nome, Especie especie, String raca, Genero genero, int idade, Porte porte, Saude saude) {
		super();
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.genero = genero;
		this.idade = idade;
		this.porte = porte;
		this.saude = saude;
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


	public Saude getSaude() {
		return saude;
	}

	public void setSaude(Saude saude) {
		this.saude = saude;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + nome + "\n");
		sb.append("Especie: " + especie + "\n");
		sb.append("Raça: " + raca + "\n");
		sb.append("Gênero: " + genero + "\n");
		sb.append("Idade: " + idade + "\n");
		sb.append("Porte " + porte + "\n");
		sb.append("Saude: " + saude + "\n");
		sb.append("\n");
		
		return sb.toString();
	}
	
}
