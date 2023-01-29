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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import controller.ControleDados;
import controller.ControleRemedio;
import enumerate.Dosagem;
import enumerate.Frequencia;

public class TelaCriarRemedio implements ActionListener {
	private JFrame frame;
	private JPanel painel;
	private JLabel textDataFinal;
	private String[] dosagens = {"", "mg", "ml", "g", "comprimido(s)", "cápsula(s)", "gota(s)"};
	private ControleDados dados = new ControleDados();
	private ControleRemedio controleRemedio;
	int i;
	private JTextField textNome;
	private JTextField textDosagem;
	private JComboBox<Object> boxDosagem;
	private JComboBox<String> boxFrequencia;
	private JFormattedTextField dataInicio;
	private JFormattedTextField dataFinal;
	private JTextField num;
	private JTextArea textAnotacoes;
	
	
	TelaCriarRemedio(ControleDados dados, int i) {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.dados = dados;
		this.i = i;
		this.controleRemedio = new ControleRemedio(dados);
		
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
		labelAdicionarRemedio();
		nomeRemedio();
		frequencia();
		dosagem();
		datas();
		botaoConfirmar();
		qtdDia();
	}
	
	
	public void labelAdicionarRemedio() {
		JLabel adicionarRemedio = new JLabel("Criar remédio");
		adicionarRemedio.setBounds(190, 0, 280, 150);
		adicionarRemedio.setFont(new Font("", Font.BOLD, 30));
		adicionarRemedio.setForeground(Color.BLACK);
		painel.add(adicionarRemedio);
	}
	
	public void nomeRemedio() {
		JLabel nomeRemedio = new JLabel("Nome:");
		nomeRemedio.setBounds(100, 130, 100, 40);
		nomeRemedio.setFont(new Font("", 0, 18));
		painel.add(nomeRemedio);
		
		textNome = new JTextField();
		textNome.setBounds(220, 150, 200, 20);
		painel.add(textNome);
	}
	
	public void dosagem() {
		JLabel dosagem = new JLabel("Dosagem:");
		dosagem.setBounds(100, 170, 100, 40);
		dosagem.setFont(new Font("", 0, 18));
		painel.add(dosagem);
		
		textDosagem = new JTextField();
		textDosagem.setBounds(220, 180, 55, 20);
		painel.add(textDosagem);
		
		boxDosagem = new JComboBox<Object>(dosagens);
		boxDosagem.setBounds(275, 180, 145, 20);
		painel.add(boxDosagem);
	}
	
	
	public void frequencia() {
		JLabel frequencia = new JLabel("Frequência:");
		frequencia.setBounds(100, 200, 250, 40);
		frequencia.setFont(new Font("", 0, 18));
		painel.add(frequencia);
		
		String[] frequenciaS = {"", "Uma vez", "Uso contínuo", "Temporário"};
		boxFrequencia = new JComboBox<String>(frequenciaS);
		boxFrequencia.setBounds(220, 210, 200, 20);
		boxFrequencia.addActionListener(this);
		painel.add(boxFrequencia);
	}
	
	public void datas() {
		JLabel textDatainicio = new JLabel("Data:");
		textDatainicio.setBounds(100, 230, 100, 40);
		textDatainicio.setFont(new Font("", 0, 18));
		painel.add(textDatainicio);
		
		textDataFinal = new JLabel("Data final:");
		textDataFinal.setBounds(315, 230, 65, 40);
		textDataFinal.setFont(new Font("", 0, 12));
		painel.add(textDataFinal);
		
		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
			maskData.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dataInicio = new JFormattedTextField(maskData);
		dataInicio.setBounds(220, 240, 88, 20);
		painel.add(dataInicio);
		

		dataFinal = new JFormattedTextField(maskData);
		dataFinal.setBounds(375, 240, 88, 20);
		painel.add(dataFinal);
	}
	
	public void qtdDia() {
		JLabel qtd = new JLabel("Quantas vezes por dia?");
		qtd.setBounds(100, 260, 300, 40);
		qtd.setFont(new Font("", 0, 18));
		painel.add(qtd);
		
		num = new JTextField();
		num.setBounds(320, 270, 40, 20);
		painel.add(num);
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
		
		controleRemedio.adicionarRemedio(i, nroDosagem , dosagem, frequencia, dataF, qtdVezes, nomeMedicamento, dataI);
	}
	
	public static void main(String[] args) {
		new Inicio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaPerfilPet(dados, i);
	         frame.dispose();
		}
		if ("Confirmar" == e.getActionCommand()) {
			 dadosRemedio(textNome, textDosagem, boxDosagem, boxFrequencia, dataInicio, dataFinal, num, textAnotacoes);
			 new TelaPerfilPet(dados, i);
			 JOptionPane.showMessageDialog(null, "Remédio cadastrado com sucesso!");
	         frame.dispose();
		}		
	}
}
