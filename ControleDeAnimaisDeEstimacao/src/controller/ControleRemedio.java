package controller;

import javax.swing.DefaultListModel;

import enumerate.Dosagem;
import enumerate.Frequencia;
import models.BancoDeDados;
import models.Remedio;
import view.TelaRemedio;

public class ControleRemedio {
	private ControleDados dados;
	
	public ControleRemedio() {
		
	}

    public void adicionarRemedio(int i, int nroDosagem ,Dosagem dosagem, Frequencia frequencia, String dataFinal, int qtdVezes, String nomeMedicamento,String data, String anotacoes) {
    	Remedio remedio = new Remedio(nroDosagem, dosagem, frequencia, dataFinal, qtdVezes, nomeMedicamento, data, anotacoes);
    	dados.getAnimais().get(i).cadastrarRemedio(remedio);
    }
    
	public void buscarRemedio(String nome) {
		for (int i = 0; i < dados.getQtdRemedios(); i++) {
			if(dados.getRemedios().get(i).getNomeMedicamento().equals(nome)) {
				System.out.println(dados.getRemedios().get(i).getNomeMedicamento());
			}
		}
	}
	
    public Boolean editarRemedio(int i, int nroDosagem1 ,Dosagem dosagem1, Frequencia frequencia1, String dataFinal1, int qtdVezes1, String nomeMedicamento1,String data1, String anotacoes1){
        String nomeMedicamento = dados.getRemedios().get(i).getNomeMedicamento();

        for(int j = 0; j < dados.getQtdRemedios(); j++) {
            if(dados.getRemedios().get(j).getNomeMedicamento().equals(nomeMedicamento)) {
            	dados.getRemedios().get(j).setNroDosagem(nroDosagem1);
            	dados.getRemedios().get(j).setDosagem(dosagem1);
            	dados.getRemedios().get(j).setFrequencia(frequencia1);
            	dados.getRemedios().get(j).setDataFinal(dataFinal1);
            	dados.getRemedios().get(j).setNomeMedicamento(nomeMedicamento1);
            	dados.getRemedios().get(j).setData(data1);
            	dados.getRemedios().get(j).setAnotacoes(anotacoes1);
                return true;
            }
        }
        return false;
    } 
	
	public void excluirRemedio(Remedio remedio, int i) {
		dados.getAnimais().get(i).excluirRemedio(remedio);
	}
	
    public DefaultListModel<String> getNomeRemedio() {
    	DefaultListModel<String> listaNomesRemedios = new DefaultListModel<String>();
    	for (int i = 0; i < dados.getQtdRemedios(); i++) {
    		String nome = dados.getRemedios().get(i).getNomeMedicamento();
    		listaNomesRemedios.add(i, nome);
    	}
    	return listaNomesRemedios;
    }
    
	public void verRemedio(String nome) {
		for (int j = 0; j < dados.getQtdRemedios(); j++) {
			if(dados.getRemedios().get(j).getNomeMedicamento().equals(nome)) {
				new TelaRemedio(dados, j);
			}
		}
	}
	
}
