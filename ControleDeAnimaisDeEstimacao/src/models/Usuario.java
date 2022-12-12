package models;

import java.util.List;

public class Usuario {
	private String id;
	private String nome;
	private List<Animal> animais;
	
	public Usuario(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuário: \n");
		sb.append("Id: " + id + "\n");
		sb.append("Nome: "+ nome + "\n");
		sb.append("Animais: " + animais);
		
		return sb.toString();
	}
}
