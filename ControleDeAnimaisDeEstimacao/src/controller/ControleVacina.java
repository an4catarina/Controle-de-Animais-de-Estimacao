package controller;

import javax.swing.DefaultListModel;

import enumerate.Intervalo;
import models.Vacina;
import view.TelaVacina;

public class ControleVacina {
	private ControleDados dados;
	
	public ControleVacina(ControleDados dados) {
		this.dados = dados;
	}
	
	 public void adicionarVacnina(int i, String lote, String laboratorio, boolean necRevacinar, String nomeMedicamento, String data, int periodo, Intervalo intervalo, String anotacoes) {
	    	Vacina vacina = new Vacina(lote, laboratorio, necRevacinar, nomeMedicamento, data, periodo, intervalo, anotacoes);
	    	dados.getAnimais().get(i).cadastrarVacina(vacina);
	    }
    
	public void buscarVacina(String nome) {
		for (int i = 0; i < dados.getQtdRemedios(); i++) {
			if(dados.getVacinas().get(i).getNomeMedicamento().equals(nome)) {
				System.out.println(dados.getVacinas().get(i).getNomeMedicamento());
			}
		}
	}
	
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
    	
    
	public void excluirVacina(String nome, int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getVacinas().size(); j++) {
			if(dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento().equals(nome)) {
					dados.getAnimais().get(i).excluirVacina(dados.getAnimais().get(i).getVacinas().get(j));
			}
		}
	}
	
    public DefaultListModel<String> getNomeVacina() {
    	DefaultListModel<String> listaNomesVacinas = new DefaultListModel<String>();
    	for (int i = 0; i < dados.getQtdVacinas(); i++) {
    		String nome = dados.getVacinas().get(i).getNomeMedicamento();
    		listaNomesVacinas.add(i, nome);
    	}
    	return listaNomesVacinas;
    }
	
	public void verVacina(String nome, int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getVacinas().size(); j++) {
			if(dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento().equals(nome)) {
				new TelaVacina(dados, i, nome);
			}
		}
	}
	
	    
}
