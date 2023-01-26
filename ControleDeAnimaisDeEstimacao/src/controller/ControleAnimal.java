package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import enumerate.Dosagem;
import enumerate.Especie;
import enumerate.Frequencia;
import enumerate.Genero;
import enumerate.Intervalo;
import enumerate.Porte;
import models.Animal;
import models.BancoDeDados;
import models.Remedio;
import models.Vacina;
import view.TelaListaPets;
import view.TelaPerfilPet;


public class ControleAnimal {
	private ArrayList<Animal> animais;
	private int qtdAnimal;
	private BancoDeDados dados;
	
	ControleAnimal(ArrayList<Animal> animais) {
		this.animais = animais;
		}
	
	public String[] getNomeAnimal() {
		String[] stringAnimais = new String[qtdAnimal];
		for (int i = 0; i < qtdAnimal; i++) {
			stringAnimais[i] = animais.get(i).getNome();
		}
		return stringAnimais;
	}
	
	public String getNome(int i) {
		return animais.get(i).getNome();
	}
	
	public Especie getEspecie(int i) {
		return animais.get(i).getEspecie();
	}
	
	public String getRaca(int i) {
		return animais.get(i).getRaca();
	}
	
	public Genero getGenero(int i) {
		return animais.get(i).getGenero();
	}
	
	public int getIdade(int i) {
		return animais.get(i).getIdade();
	}
	
	public Porte getPorte(int i) {
		return animais.get(i).getPorte();
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
				new TelaPerfilPet();
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
                dados.getAnimais().get(i).setNome(nome1);
                dados.getAnimais().get(i).setEspecie(especie1);
                dados.getAnimais().get(i).setRaca(raca1);
                dados.getAnimais().get(i).setGenero(genero1);
                dados.getAnimais().get(i).setPorte(porte1);
                return true;
            }
        }
        return false;
    } 

    public Boolean removerAnimal(int i) {
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
    
    public void adicionarVacnina(int i, int lote, String laboratorio, boolean necRevacinar, String nomeMedicamento, String data, int periodo, Intervalo intervalo, String anotacoes) {
    	Vacina vacina = new Vacina(lote, laboratorio, necRevacinar, nomeMedicamento, data, periodo, intervalo, anotacoes);
    	animais.get(i).cadastrarVacina(vacina);
    }
    
	public void buscarVacina(String nome) {
		for (int i = 0; i < dados.getQtdRemedios(); i++) {
			if(dados.getVacinas().get(i).getNomeMedicamento().equals(nome)) {
				System.out.println(dados.getVacinas().get(i).getNomeMedicamento());
			}
		}
	}
	
	public void excluirVacina(Vacina vacina, int i) {
		dados.getAnimais().get(i).excluirVacina(vacina);
	}
    
    public void adicionarRemedio(int i, int nroDosagem ,Dosagem dosagem, Frequencia frequencia, String dataFinal, int qtdVezes, String nomeMedicamento,String data, String anotacoes) {
    	Remedio remedio = new Remedio(nroDosagem, dosagem, frequencia, dataFinal, qtdVezes, nomeMedicamento, data, anotacoes);
    	animais.get(i).cadastrarRemedio(remedio);
    }
    
	public void buscarRemedio(String nome) {
		for (int i = 0; i < dados.getQtdRemedios(); i++) {
			if(dados.getRemedios().get(i).getNomeMedicamento().equals(nome)) {
				System.out.println(dados.getRemedios().get(i).getNomeMedicamento());
			}
		}
	}
	
	public void excluirRemedio(Remedio remedio, int i) {
		dados.getAnimais().get(i).excluirRemedio(remedio);
	}
    
}
