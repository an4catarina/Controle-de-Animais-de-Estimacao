package models;

import java.util.ArrayList;

public class Tutor {
	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Animal> animais = new ArrayList<Animal>();
	
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

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
	
//	public void adicionarTutor(Tutor tutor) {
//		BancoDeDados.getTutores().add(tutor);
//	}
	
//	public void editarTutor(Tutor tutor) {
//		BancoDeDados
//
//	}
	
}
