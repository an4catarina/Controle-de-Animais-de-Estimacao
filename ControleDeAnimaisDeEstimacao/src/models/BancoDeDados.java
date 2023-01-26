package models;

import java.util.ArrayList;

import enumerate.Dosagem;
import enumerate.Especie;
import enumerate.Frequencia;
import enumerate.Genero;
import enumerate.Intervalo;
import enumerate.Porte;

public class BancoDeDados {
	private ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
	private ArrayList<Remedio> remedios = new ArrayList<Remedio>();
	private ArrayList<Animal> animais = new ArrayList<Animal>();
	private int qtdAnimais = 0;
	private int qtdVacinas = 0;
	private int qtdRemedios = 0;
	
	public void preencherDados() {
		for(int i = 0; i < 5; i++) {
			Animal animal = new Animal("Animal" + i, Especie.Felino, "Raca" + i, Genero.Indefinido, i, Porte.MEDIO, null, null);
			Vacina vacina = new Vacina(i, "Laboraotorio" + i, false, "nome" + i, "data" + i, i, Intervalo.ANOS, "Anotacoes" + i);
			Remedio remedio = new Remedio(i, Dosagem.G, Frequencia.UMAVEZ, "Data final" + i, i, "Nome" + i, "Data" + i, "Anotacoes" + i);
			vacinas.add(vacina);
			animal.setVacinas(vacinas);
			remedios.add(remedio);
			animal.setRemedios(remedios);
			animais.add(animal);
		}
	}
	
	public ArrayList<Vacina> getVacinas() {
		return vacinas;
	}
	
	public ArrayList<Remedio> getRemedios() {
		return remedios;
	}
	
	public ArrayList<Animal> getAnimais() {
		return animais;
	}
	
	public int getQtdAnimais() {
		return qtdAnimais = this.animais.size();
	}
	
	public int getQtdVacinas() {
		return qtdVacinas = this.vacinas.size();
	}
	
	public int getQtdRemedios() {
		return qtdRemedios = this.remedios.size();
	}
	
	public void setQtdAnimais(int qtdAnimais) {
		this.qtdAnimais = qtdAnimais;
	}
	
	public void cadastrarAnimal(Animal animal) {
		animais.add(animal);
	}

}