package controller;

import java.util.ArrayList;

import models.Animal;
import models.BancoDeDados;
import models.Remedio;
import models.Vacina;

public class ControleDados {
	private BancoDeDados dados;
	
	ControleDados(){
		dados.preencherDados();
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
}
