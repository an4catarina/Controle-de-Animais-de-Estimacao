package controller;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enumerate.Especie;
import enumerate.Genero;
import enumerate.Porte;
import models.Animal;
import view.TelaPerfilPet;


public class ControleAnimal {
	private ControleDados dados = new ControleDados();
	
	public ControleAnimal(ControleDados dados) {
		this.dados = dados;
		}
	
	public boolean adicionarAnimal(String nome, Especie especie, String raca, Genero genero, int idade, Porte porte) {
        int count = 0;
     
        for(int i = 0; i < dados.getQtdAnimais(); i++) {
            boolean verif = dados.getAnimais().get(i).getNome().equals(nome);
            if(verif) {
                count++;
            }
        }
        if(count >= 1) {
            System.out.println("Animal já cadastrado!");
            return false;
        } else {
            Animal animal = new Animal(nome, especie, raca, genero, idade, porte, null, null);
            dados.cadastrarAnimal(animal);
            System.out.println("Animal cadastrado com sucesso!");
            return true;
        }
    }
	
	public void buscarAnimal(String string) {
		String nome = string;
		for(int i = 0; i < dados.getQtdAnimais(); i++) {
			if(dados.getAnimais().get(i).getNome().equals(nome) == true) {
				new TelaPerfilPet(dados, i);
			} else {
				JOptionPane.showMessageDialog(null, "Animal não encontrado."); 
				break;
			}
		}
	}
	
	
    public void editarAnimal(int i,String nome, Especie especie, String raca, Genero genero, int idade, Porte porte){
        dados.getAnimais().get(i).setNome(nome);
        dados.getAnimais().get(i).setEspecie(especie);
        dados.getAnimais().get(i).setRaca(raca);
        dados.getAnimais().get(i).setGenero(genero);
        dados.getAnimais().get(i).setIdade(idade);
        dados.getAnimais().get(i).setPorte(porte);
    } 

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
    
    public DefaultListModel<String> getListaAnimais() {
    	DefaultListModel<String> listaNomesAnimais = new DefaultListModel<String>();
    	for (int i = 0; i < dados.getQtdAnimais(); i++) {
    		String nome = dados.getAnimais().get(i).getNome();
    		listaNomesAnimais.add(i, nome);
    	}
    	return listaNomesAnimais;
    }
   
	public void verAnimal(String nome) {
		for (int j = 0; j < dados.getQtdAnimais(); j++) {
			if(dados.getAnimais().get(j).getNome().equals(nome)) {
				new TelaPerfilPet(dados, j);
			}
		}
	}
}
