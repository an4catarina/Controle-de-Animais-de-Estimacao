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
	
	public BancoDeDados() {
		preencherDados();
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
	
	public void preencherDados() {
		for(int i = 0; i < 5; i++) {
			Animal animal = new Animal("Animal" + i, Especie.FELINO, "Raca" + i, Genero.INDEFINIDO, i, Porte.MEDIO, null, null);
			Vacina vacina = new Vacina("Lote" + i, "Laboraotorio" + i, false, "nome" + i, "data" + i, i, Intervalo.ANOS, "Anotacoes" + i);
			Remedio remedio = new Remedio(i, Dosagem.G, Frequencia.UMAVEZ, "Data final" + i, i, "Nome" + i, "Data" + i);
			vacinas.add(vacina);
			animal.setVacinas(vacinas);
			remedios.add(remedio);
			animal.setRemedios(remedios);
			animais.add(animal);
		}
	}

}