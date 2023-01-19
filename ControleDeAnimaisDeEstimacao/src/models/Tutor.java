package models;

import java.util.ArrayList;

public class Tutor {
	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Animal> animais;
	
	public Tutor(String nome, String email, String telefone, ArrayList<Animal> animais) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.animais = animais;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais2) {
		this.animais = animais2;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tutor: \n");
		sb.append("Nome: "+ nome + "\n");
		sb.append("E-mail: "+ email + "\n");
		sb.append("Telefone: "+ telefone + "\n");
		sb.append("Animais: " + animais);
		
		return sb.toString();
	}
}
