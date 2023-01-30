package controller;

import java.util.ArrayList;

import models.Animal;
import models.BancoDeDados;
import models.Remedio;
import models.Vacina;

/**
 * classe responsável pelo controle de dados
 * @author catarina
 *
 */
public class ControleDados {
	private BancoDeDados dados;
	private int qtdAnimais = 0;
	
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
		return dados.getAnimais().size();
	}
	
	public int getQtdVacinas() {
		return dados.getVacinas().size();
	}
	
	public int getQtdRemedios() {
		return dados.getRemedios().size();
	}
	
	public void setQtdAnimais(int qtdAnimais) {
		this.qtdAnimais = qtdAnimais;
	}
	
	/**
	 * método responsável pelo cadastro de um animal no banco de dados
	 * 
	 * @param animal
	 */
	public void cadastrarAnimal(Animal animal) {
		dados.getAnimais().add(animal);
	}
	
}
