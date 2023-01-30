package controller;

import javax.swing.DefaultListModel;

import enumerate.Dosagem;
import enumerate.Frequencia;
import models.Remedio;
import view.TelaRemedio;

public class ControleRemedio {
	private ControleDados dados;
	
	/**
	 * classe responsável pelo controle de um remédio
	 * @param dados
	 */
	public ControleRemedio(ControleDados dados) {
		this.dados = dados;
	}
	/**
	 * método responsável por relacionar um remédio a um animal
	 * 
	 * @param i
	 * @param nroDosagem
	 * @param dosagem
	 * @param frequencia
	 * @param dataFinal
	 * @param qtdVezes
	 * @param nomeMedicamento
	 * @param data
	 */
    public void adicionarRemedio(int i, int nroDosagem ,Dosagem dosagem, Frequencia frequencia, String dataFinal, int qtdVezes, String nomeMedicamento,String data) {
    	Remedio remedio = new Remedio(nroDosagem, dosagem, frequencia, dataFinal, qtdVezes, nomeMedicamento, data);
    	dados.getAnimais().get(i).getRemedios().add(remedio);
    }
	
    /**
     * método responsável pela edição de um remédio
     * @param i
     * @param nroDosagem1
     * @param dosagem1
     * @param frequencia1
     * @param dataFinal1
     * @param qtdVezes1
     * @param nomeMedicamento1
     * @param data1
     */
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
	
    /**
     * método responsável por apagar um remédio
     * 
     * @param nome
     * @param i
     */
	public void excluirRemedio(String nome, int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getRemedios().size(); j++) {
			if(dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento().equals(nome)) {
					dados.getAnimais().get(i).excluirRemedio(dados.getAnimais().get(i).getRemedios().get(j));
			}
		}
	}
	
	/**
	 * método responsável pela geração de uma lista com o nome de remédios
	 * 
	 * @return
	 */
    public DefaultListModel<String> getNomeRemedio(int i) {
    	DefaultListModel<String> listaNomesRemedios = new DefaultListModel<String>();
    	for (int j = 0; j < dados.getAnimais().get(i).getRemedios().size(); j++) {
    		String nome = dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento();
    		listaNomesRemedios.add(j, nome);
    	}
    	return listaNomesRemedios;
    }
    /**
     * método responsável pela leitura de um remedio
     * 
     * @param nome
     * @param i
     */
	public void verRemedio(String nome, int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getRemedios().size(); j++) {
			if(dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento().equals(nome)) {
				new TelaRemedio(dados, i, nome);
			}
		}
	}
	
}
