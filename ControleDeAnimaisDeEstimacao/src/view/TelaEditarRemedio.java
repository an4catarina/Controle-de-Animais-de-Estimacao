package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import controller.ControleDados;
import controller.ControleRemedio;
import enumerate.Dosagem;
import enumerate.Frequencia;

public class TelaEditarRemedio implements ActionListener {
	private JFrame frame;
	private JPanel painel;
	private JLabel textDataFinal;
	private JFormattedTextField dataFinal;
	private JComboBox<String> boxFrequencia;

	private String[] dosagens = {"", "mg", "ml", "g", "comprimido(s)", "cápsula(s)", "gota(s)"};
	private String[] frequenciaS = {"", "Uma vez", "Uso contínuo", "Temporário"};
	
	private ControleDados dados = new ControleDados();
	private String nome;
	private ControleRemedio controleRemedio;
	private int i;
	private JTextField textNome;
	private JTextField textDosagem;
	private JComboBox<String> boxDosagem;
	private JFormattedTextField dataInicio;
	private JTextField num;

	
	TelaEditarRemedio(ControleDados dados, int i, String nome) {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.dados = dados;
		controleRemedio = new ControleRemedio(dados);
		this.i = i;
		this.nome = nome;
		implementarTemplate();
		painelRemedio();
		botaoVoltar();
	}
	public void implementarTemplate() {
		
		try {
			BufferedImage img = ImageIO.read(getClass().getResource("/imagens/telageral.jpg"));
			Image dimg = img.getScaledInstance(600, 700, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel label = new JLabel();
			label.setIcon(icon);
			frame.getContentPane().add(label, BorderLayout.CENTER);
			frame.setContentPane(label);
			frame.pack();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	public void botaoVoltar() {
		JButton botao = new JButton("Voltar");
		botao.setBounds(500, 12, 70, 30);
		frame.add(botao);	
		botao.setActionCommand("voltar");
		botao.addActionListener(this);
	}
	
	public void painelRemedio() {
		painel = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painel.setBounds(25, 170, 550, 480);
		painel.setBackground(new Color(211, 211, 211));
		painel.setBorder(blackline);
		painel.setLayout(null);
		frame.add(painel);
		construirRemedio();
	}
	
	public void construirRemedio() {
		labelEditarRemedio();
		nomeRemedio();
		frequencia();
		dosagem();
		datas();
		botaoConfirmar();
		qtdDia();
		dadosRemedio();
	}
	
	public void dadosRemedio() {
		for (int j = 0; j < dados.getAnimais().get(i).getRemedios().size(); j++) {
			if(dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento().equals(nome)) {
				
				textNome = new JTextField(dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento());
				textNome.setBounds(220, 150, 200, 20);
				painel.add(textNome);
				
				textDosagem = new JTextField(Integer.toString(dados.getAnimais().get(i).getRemedios().get(j).getNroDosagem()));
				textDosagem.setBounds(220, 180, 55, 20);
				painel.add(textDosagem);

				int index;
				switch(dados.getAnimais().get(i).getRemedios().get(j).getDosagem()) {
				case MG:
					index = 1;
					break;
				case ML:
					index = 2;
					break;
				case G:
					index = 3;
					break;
				case COMPRIMIDO:
					index = 4;
					break;
				case CAPSULA:
					index = 5;
					break;
				case GOTA:
					index = 6;
					break;
				default:
					index = 0;
					break;
				}
				boxDosagem = new JComboBox<String>(dosagens);
				boxDosagem.setSelectedIndex(index);
				boxDosagem.setBounds(275, 180, 145, 20);
				painel.add(boxDosagem);

				int indexF;
				switch(dados.getAnimais().get(i).getRemedios().get(j).getFrequencia()) {
				case UMAVEZ:
					indexF = 1;
					break;
				case USOCONTINUO:
					indexF = 2;
					break;
				case USOTEMPORARIO:
					indexF = 3;
					break;
				default:
					indexF = 0;
					break;
				}
				boxFrequencia = new JComboBox<String>(frequenciaS);
				boxFrequencia.setSelectedIndex(indexF);
				boxFrequencia.setBounds(220, 220, 200, 20);
				boxFrequencia.addActionListener(this);
				painel.add(boxFrequencia);
				
				dataInicio = new JFormattedTextField(dados.getAnimais().get(i).getRemedios().get(j).getData());
				dataInicio.setBounds(220, 240, 88, 20);
				painel.add(dataInicio);
				

				dataFinal = new JFormattedTextField(dados.getAnimais().get(i).getRemedios().get(j).getDataFinal());
				dataFinal.setBounds(375, 240, 88, 20);
				painel.add(dataFinal);
				
				num = new JTextField(Integer.toString(dados.getAnimais().get(i).getRemedios().get(j).getQtdVezes()));
				num.setBounds(320, 280, 40, 20);
				painel.add(num);
				
			}
		}
	}
	
	
	public void labelEditarRemedio() {
		JLabel editarRemedio = new JLabel("Editar remédio");
		editarRemedio.setBounds(190, 0, 280, 150);
		editarRemedio.setFont(new Font("", Font.BOLD, 30));
		editarRemedio.setForeground(Color.BLACK);
		painel.add(editarRemedio);
	}
	
	public void nomeRemedio() {
		JLabel nomeRemedio = new JLabel("Nome:");
		nomeRemedio.setBounds(100, 150, 100, 40);
		nomeRemedio.setFont(new Font("", 0, 18));
		painel.add(nomeRemedio);
	}
	
	public void dosagem() {
		JLabel dosagem = new JLabel("Dosagem:");
		dosagem.setBounds(100, 180, 100, 40);
		dosagem.setFont(new Font("", 0, 18));
		painel.add(dosagem);
	}
	
	
	public void frequencia() {
		JLabel frequencia = new JLabel("Frequência:");
		frequencia.setBounds(100, 210, 250, 40);
		frequencia.setFont(new Font("", 0, 18));
		painel.add(frequencia);
	}
	
	public void datas() {
		JLabel textDatainicio = new JLabel("Data:");
		textDatainicio.setBounds(100, 240, 100, 40);
		textDatainicio.setFont(new Font("", 0, 18));
		painel.add(textDatainicio);
		
		textDataFinal = new JLabel("Data final:");
		textDataFinal.setBounds(315, 240, 65, 40);
		textDataFinal.setFont(new Font("", 0, 12));
		painel.add(textDataFinal);
		
		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void qtdDia() {
		JLabel qtd = new JLabel("Quantas vezes por dia?");
		qtd.setBounds(100, 270, 300, 40);
		qtd.setFont(new Font("", 0, 18));
		painel.add(qtd);
	}
	
	public void botaoConfirmar() {
		JButton botao = new JButton("Confirmar");
		botao.setBounds(230, 400, 100, 40);
		botao.setActionCommand("Confirmar");
		botao.addActionListener(this);
		painel.add(botao);
		
	}
	
	public void dadosRemedio(JTextField textNome, JTextField textDosagem, JComboBox<Object> boxDosagem, JComboBox<String> boxFrequencia,
			JFormattedTextField dataInicio,JFormattedTextField dataFinal, JTextField num, JTextArea textAnotacoes) {
		
		int nroDosagem = Integer.parseInt(textDosagem.getText());
		
		Dosagem dosagem = null;
		int escolherDosagem = boxDosagem.getSelectedIndex();
		switch(escolherDosagem) {
		case 1:
			dosagem = Dosagem.MG;
			break;
		case 2:
			dosagem = Dosagem.ML;
			break;
		case 3:
			dosagem = Dosagem.G;
			break;
		case 4:
			dosagem = Dosagem.COMPRIMIDO;
			break;
		case 5:
			dosagem = Dosagem.CAPSULA;
			break;
		case 6:
			dosagem = Dosagem.GOTA;
			break;
		default:
			dosagem = null;
			break;
		}
		
		Frequencia frequencia = null;
		int escolhaFrequencia = boxFrequencia.getSelectedIndex();
		switch(escolhaFrequencia) {
		case 1:
			frequencia = Frequencia.UMAVEZ;
			break;
		case 2:
			frequencia = Frequencia.USOCONTINUO;
			break;
		case 3:
			frequencia = Frequencia.USOTEMPORARIO;
			break;
		}
		
		String dataF = dataFinal.getText();
		int qtdVezes = Integer.parseInt(num.getText());
		String nomeMedicamento = textNome.getText();
		String dataI = dataInicio.getText();
		
		controleRemedio.editarRemedio(i, nroDosagem , dosagem, frequencia, dataF, qtdVezes, nomeMedicamento, dataI);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaRemedio(dados, i, nome);
	         frame.dispose();
		}
		if ("Confirmar" == e.getActionCommand()) {
			 new TelaRemedio(dados, i, nome);
	         frame.dispose();
		}		
	}

}
