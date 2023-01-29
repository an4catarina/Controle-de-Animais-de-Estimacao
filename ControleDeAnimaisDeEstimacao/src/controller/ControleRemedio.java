package controller;

import javax.swing.DefaultListModel;

import enumerate.Dosagem;
import enumerate.Frequencia;
import models.Remedio;
import view.TelaRemedio;

public class ControleRemedio {
	private ControleDados dados;
	
	public ControleRemedio(ControleDados dados) {
		this.dados = dados;
	}

    public void adicionarRemedio(int i, int nroDosagem ,Dosagem dosagem, Frequencia frequencia, String dataFinal, int qtdVezes, String nomeMedicamento,String data) {
    	Remedio remedio = new Remedio(nroDosagem, dosagem, frequencia, dataFinal, qtdVezes, nomeMedicamento, data);
    	dados.getAnimais().get(i).cadastrarRemedio(remedio);
    }
	
    public void editarRemedio(int i, int nroDosagem1 ,Dosagem dosagem1, Frequencia frequencia1, String dataFinal1, int qtdVezes1, String nomeMedicamento1,String data1){
    	for (int j = 0; j < dados.getAnimais().get(i).getRemedios().size(); j++) {
			if(dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento() != null) {
            	dados.getRemedios().get(j).setNroDosagem(nroDosagem1);
            	dados.getRemedios().get(j).setDosagem(dosagem1);
            	dados.getRemedios().get(j).setFrequencia(frequencia1);
            	dados.getRemedios().get(j).setDataFinal(dataFinal1);
            	dados.getRemedios().get(j).setNomeMedicamento(nomeMedicamento1);
            	dados.getRemedios().get(j).setData(data1);
            }
        }
    } 
	
	public void excluirRemedio(String nome, int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getRemedios().size(); j++) {
			if(dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento().equals(nome)) {
					dados.getAnimais().get(i).excluirRemedio(dados.getAnimais().get(i).getRemedios().get(j));
			}
		}
	}
	
    public DefaultListModel<String> getNomeRemedio() {
    	DefaultListModel<String> listaNomesRemedios = new DefaultListModel<String>();
    	for (int i = 0; i < dados.getQtdRemedios(); i++) {
    		String nome = dados.getRemedios().get(i).getNomeMedicamento();
    		listaNomesRemedios.add(i, nome);
    	}
    	return listaNomesRemedios;
    }
    
	public void verRemedio(String nome, int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getRemedios().size(); j++) {
			if(dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento().equals(nome)) {
				new TelaRemedio(dados, i, nome);
			}
		}
	}
	
}
