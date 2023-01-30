package controller;

import javax.swing.DefaultListModel;

import enumerate.Intervalo;
import models.Vacina;
import view.TelaVacina;

public class ControleVacina {
	private ControleDados dados;
	
	/**
	 * classe responsavel pelo gerenciamento de vacinas
	 * @param dados
	 */
	public ControleVacina(ControleDados dados) {
		this.dados = dados;
	}
	/**
	 * método responsável por relacionar uma vacina a um animal
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
	 public void adicionarVacnina(int i, String lote, String laboratorio, boolean necRevacinar, String nomeMedicamento, String data, int periodo, Intervalo intervalo, String anotacoes) {
    	Vacina vacina = new Vacina(lote, laboratorio, necRevacinar, nomeMedicamento, data, periodo, intervalo, anotacoes);
    	dados.getAnimais().get(i).getVacinas().add(vacina);
    }
	    /**
	     * método responsável pela edição de uma Vacina
	     * @param i
	     * @param nroDosagem1
	     * @param dosagem1
	     * @param frequencia1
	     * @param dataFinal1
	     * @param qtdVezes1
	     * @param nomeMedicamento1
	     * @param data1
	     */
    public void editarVacina(int i, String lote1, String laboratorio1, boolean necRevacinar1, String nomeMedicamento1, String data1, int periodo1, Intervalo intervalo1, String anotacoes1){
    	for (int j = 0; j < dados.getAnimais().get(i).getVacinas().size(); j++) {
			if(dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento() != null) {
				dados.getVacinas().get(j).setLote(lote1);
				dados.getVacinas().get(j).setLaboratorio(laboratorio1);
				dados.getVacinas().get(j).setNecRevacinar(necRevacinar1);
				dados.getVacinas().get(j).setNomeMedicamento(nomeMedicamento1);
				dados.getVacinas().get(j).setData(data1);
				dados.getVacinas().get(j).setPeriodo(periodo1);
				dados.getVacinas().get(j).setIntervalo(intervalo1);
				dados.getVacinas().get(j).setAnotacoes(anotacoes1);
			}
		}
	}
    /**
     * método responsável por apagar uma vacina
     * 
     * @param nome
     * @param i
     */	
    
	public void excluirVacina(String nome, int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getVacinas().size(); j++) {
			if(dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento().equals(nome)) {
					dados.getAnimais().get(i).excluirVacina(dados.getAnimais().get(i).getVacinas().get(j));
			}
		}
	}
	/**
	 * método responsável pela geração de uma lista com o nome de vacina
	 * 
	 * @return
	 */
    public DefaultListModel<String> getNomeVacina(int i) {
    	DefaultListModel<String> listaNomesVacinas = new DefaultListModel<String>();
    	for (int j = 0; j < dados.getAnimais().get(i).getVacinas().size(); j++) {
    		String nome = dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento();
    		listaNomesVacinas.add(j, nome);
    	}
    	return listaNomesVacinas;
    }
    /**
     * método responsável pela leitura de uma vacina
     * 
     * @param nome
     * @param i
     */
	public void verVacina(String nome, int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getVacinas().size(); j++) {
			if(dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento().equals(nome)) {
				new TelaVacina(dados, i, nome);
			}
		}
	}
	
	    
}
