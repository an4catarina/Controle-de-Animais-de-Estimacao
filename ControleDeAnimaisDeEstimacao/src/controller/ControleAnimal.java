package controller;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import enumerate.Especie;
import enumerate.Genero;
import enumerate.Porte;
import models.Animal;
import models.BancoDeDados;
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
				new TelaPerfilPet(dados, nome);
			} else {
				JOptionPane.showMessageDialog(null, "Animal não encontrado."); 
				break;
			}
		}
	}
	
	
    public Boolean editarAnimal(int i,String nome1, Especie especie1, String raca1, Genero genero1, int idade1, Porte porte1){
        String nomeAntigo = dados.getAnimais().get(i).getNome();

        for(int j = 0; j < dados.getQtdAnimais(); j++) {
            if(dados.getAnimais().get(j).getNome().equals(nomeAntigo)) {
                dados.getAnimais().get(j).setNome(nome1);
                dados.getAnimais().get(j).setEspecie(especie1);
                dados.getAnimais().get(j).setRaca(raca1);
                dados.getAnimais().get(j).setGenero(genero1);
                dados.getAnimais().get(j).setPorte(porte1);
                return true;
            }
        }
        return false;
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
				new TelaPerfilPet(dados, nome);
			}
		}
	}
}
