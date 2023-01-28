package controller;

import java.util.ArrayList;

import models.Animal;
import models.BancoDeDados;
import models.Remedio;
import models.Vacina;

public class ControleDados {
	private BancoDeDados dados;
	private int qtdAnimais = 0;
	private int qtdVacinas = 0;
	private int qtdRemedios = 0;
	
	public ControleDados(){
		dados = new BancoDeDados();
	}
	
	public BancoDeDados getDados() {
		return dados;
	}
	
	public ArrayList<Animal> getAnimais() {
		return dados.getAnimais();
	}
	
	public ArrayList<Vacina> getVacinas() {
		return dados.getVacinas();
	}
	
	public ArrayList<Remedio> getRemedios() {
		return dados.getRemedios();
	}
	
	public int getQtdAnimais() {
		return qtdAnimais = dados.getAnimais().size();
	}
	
	public int getQtdVacinas() {
		return qtdVacinas = dados.getVacinas().size();
	}
	
	public int getQtdRemedios() {
		return qtdRemedios = dados.getRemedios().size();
	}
	
	public void setQtdAnimais(int qtdAnimais) {
		this.qtdAnimais = qtdAnimais;
	}
	
	public void cadastrarAnimal(Animal animal) {
		dados.getAnimais().add(animal);
	}
	
}
