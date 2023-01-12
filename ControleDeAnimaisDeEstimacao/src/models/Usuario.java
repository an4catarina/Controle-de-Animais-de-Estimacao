package models;

import java.util.ArrayList;

public class Usuario {
	private String nome;
	private ArrayList<Animal> animais;
	
	public Usuario(String nome, ArrayList<Animal> animais) {
		this.nome = nome;
		this.animais = animais;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais2) {
		this.animais = animais2;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuário: \n");
		sb.append("Nome: "+ nome + "\n");
		sb.append("Animais: " + animais);
		
		return sb.toString();
	}
}
