package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import enumerate.Especie;
import enumerate.Genero;
import enumerate.Porte;
import models.Animal;
import models.Remedio;
import view.TelaListaPets;
import view.TelaPerfilPet;
import models.Vacina;

/**
 * classe responsável pelo controle de animal;
 * 
 * @author catarina
 *
 */

public class ControleAnimal {
	private ControleDados dados = new ControleDados();
	
	public ControleAnimal(ControleDados dados) {
		this.dados = dados;
		}
	
	/**
	 * método responsável pela criação e adição de animal no banco de dados;
	 * 
	 * @param nome
	 * @param especie
	 * @param raca
	 * @param genero
	 * @param idade
	 * @param porte
	 * @return
	 */
	public void adicionarAnimal(String nome, Especie especie, String raca, Genero genero, int idade, Porte porte) {
		ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
		ArrayList<Remedio> remedios = new ArrayList<Remedio>();
        Animal animal = new Animal(nome, especie, raca, genero, idade, porte, vacinas, remedios);
        dados.cadastrarAnimal(animal);
    }
	
	/**
	 * método resonsável pelo funcionamento da barra de pesquisa;
	 * 
	 * @param string
	 */
	
	public void buscarAnimal(String string) {
		String nome = string;
		for(int i = 0; i < dados.getQtdAnimais(); i++) {
			if(dados.getAnimais().get(i).getNome().equals(nome)) {
				new TelaPerfilPet(dados, i);
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Animal não encontrado.");
				new TelaListaPets(dados);
				break;
			}
		}
	}
	
	/**
	 * método responsável pela edição de um Animal;
	 * 
	 * @param i
	 * @param nome
	 * @param especie
	 * @param raca
	 * @param genero
	 * @param idade
	 * @param porte
	 */
	
    public void editarAnimal(int i,String nome, Especie especie, String raca, Genero genero, int idade, Porte porte){
        dados.getAnimais().get(i).setNome(nome);
        dados.getAnimais().get(i).setEspecie(especie);
        dados.getAnimais().get(i).setRaca(raca);
        dados.getAnimais().get(i).setGenero(genero);
        dados.getAnimais().get(i).setIdade(idade);
        dados.getAnimais().get(i).setPorte(porte);
    } 

    
    /**
     * exclui um animal;
     * 
     * @param i
     * @return
     */
    public Boolean excluirAnimal(int i) {
        String nome = dados.getAnimais().get(i).getNome();

        for(int j = 0; j < dados.getQtdAnimais(); j++) {
            if(dados.getAnimais().get(j).getNome().equals(nome)) {
                dados.getAnimais().remove(j);
                dados.setQtdAnimais(dados.getQtdAnimais() - 1);
                return true;
            }
        }

        return false;
    }
    
    /**
     * pecorre o banco de dados e retorna a lista de nomes de animais
     * 
     * @return
     */
    
    public DefaultListModel<String> getListaAnimais() {
    	DefaultListModel<String> listaNomesAnimais = new DefaultListModel<String>();
    	
    	for (int i = 0; i < dados.getQtdAnimais(); i++) {
    		String nome = dados.getAnimais().get(i).getNome();
    		listaNomesAnimais.addElement(nome);
    	}
    	return listaNomesAnimais;
    }
   
    /**
     * método responsável por acessar um animal específico a partir do seu nome
     * 
     * @param nome
     */
	public void verAnimal(String nome) {
		for (int j = 0; j < dados.getQtdAnimais(); j++) {
			if(dados.getAnimais().get(j).getNome().equals(nome)) {
				new TelaPerfilPet(dados, j);
			}
		}
	}
}
