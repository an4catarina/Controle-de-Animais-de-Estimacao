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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import controller.ControleDados;
import controller.ControleVacina;
import enumerate.Intervalo;

/**
 * tela de edição de vacina
 */
public class TelaEditarVacina implements ActionListener {
	private JFrame frame;
	private JPanel painel;
	private String[] intervaloList = {"", "Dias", "Meses", "Anos"};
	private ControleDados dados = new ControleDados();
	private ControleVacina controleVacina;
	private int i;
	private String nome;
	private JTextField textNome;
	private JFormattedTextField textData;
	private JTextField textLaboratorio;
	private JTextField textLote;
	private JRadioButton sim;
	private JRadioButton nao;
	private JLabel tempode;
	private JTextField intIntervalo;
	private JComboBox<String> boxIntervalo;
	private JTextArea textAnotacoes;
	
	
	TelaEditarVacina(ControleDados dados, int i, String nome) {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.dados = dados;
		this.nome= nome;
		controleVacina = new ControleVacina(dados);
		
		implementarTemplate();
		painelVacina();
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
		botao.setActionCommand("voltar");
		botao.addActionListener((ActionListener) this);
		botao.setBounds(500, 12, 70, 30);
		frame.add(botao);	
	}
	
	public void painelVacina() {
		painel = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painel.setBounds(25, 170, 550, 480);
		painel.setBackground(new Color(211, 211, 211));
		painel.setBorder(blackline);
		painel.setLayout(null);
		frame.add(painel);
		construirVacinas();
	}
	
	public void construirVacinas() {
		labelEditarVacina();
		nomeVacina();
		dataVacina();
		laboratorio();
		lote();
		necRevacinar();
		botaoConfirmar();
		tempode();
		anotacoes();
		criarElementosEdicao();
	}
	
	public void criarElementosEdicao() {
		for (int j = 0; j < dados.getAnimais().get(i).getVacinas().size(); j++) {
			if(dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento().equals(nome)) {
				textNome = new JTextField(nome);
				textNome.setBounds(220, 120, 200, 20);
				painel.add(textNome);
				
				MaskFormatter maskData = null;
				try {
					maskData = new MaskFormatter("##/##/####");
					maskData.setPlaceholderCharacter('_');
				} catch (ParseException e) {
					e.printStackTrace();
				}
				textData = new JFormattedTextField(dados.getAnimais().get(i).getVacinas().get(j).getData());
				textData.setBounds(220, 162, 88, 20);
				painel.add(textData);
				
				textLaboratorio = new JTextField(dados.getAnimais().get(i).getVacinas().get(j).getLaboratorio());
				textLaboratorio.setBounds(220, 200, 200, 20);
				painel.add(textLaboratorio);
				
				textLote = new JTextField(dados.getAnimais().get(i).getVacinas().get(j).getLote());
				textLote.setBounds(220, 238, 200, 20);
				painel.add(textLote);
				
				sim = new JRadioButton("Sim");
				nao = new JRadioButton("Não");
				sim.setBounds(300, 278, 55, 20);
				nao.setBounds(368, 278, 57, 20);
				painel.add(sim);
				painel.add(nao);
				sim.addActionListener(this);
				nao.addActionListener(this);
				ButtonGroup opcoes = new ButtonGroup();
				opcoes.add(nao);
				opcoes.add(sim);
				
				intIntervalo = new JTextField(Integer.toString(dados.getAnimais().get(i).getVacinas().get(j).getPeriodo()));
				intIntervalo.setBounds(280, 320, 60, 20);
				intIntervalo.setVisible(false);
				painel.add(intIntervalo);
				
				int index;
				switch(dados.getAnimais().get(i).getVacinas().get(j).getIntervalo()) {
				case DIAS:
					index = 1;
					break;
				case MESES:
					index = 2;
					break;
				case ANOS:
					index = 3;
					break;
				default:
					index = 0;
					break;
				}
				boxIntervalo = new JComboBox<String>(intervaloList);
				boxIntervalo.setSelectedIndex(index);
				boxIntervalo.setBounds(340, 320, 90, 20);
				boxIntervalo.setVisible(false);
				painel.add(boxIntervalo);
				
				if (dados.getAnimais().get(i).getVacinas().get(j).isNecRevacinar() == true) {
					sim.setSelected(true);
					intIntervalo.setVisible(true);
					tempode.setVisible(true);
					boxIntervalo.setVisible(true);
				} else if (dados.getAnimais().get(i).getVacinas().get(j).isNecRevacinar() == false) {
					nao.setSelected(true);
				}
				
				textAnotacoes = new JTextArea(dados.getAnimais().get(i).getVacinas().get(j).getAnotacoes());
				textAnotacoes.setBounds(200, 350, 250, 80);
				painel.add(textAnotacoes);
			}
		}
		painel.add(textNome);
	}
	
	public void labelEditarVacina() {
		JLabel editarVacina = new JLabel("Editar vacina");
		editarVacina.setBounds(160, 0, 280, 150);
		editarVacina.setFont(new Font("", Font.BOLD, 30));
		editarVacina.setForeground(Color.BLACK);
		painel.add(editarVacina);
	}
	
	public void nomeVacina() {
		painel.setLayout(null);
		JLabel nomeVacina = new JLabel("Nome:");
		nomeVacina.setBounds(100, 110, 100, 40);
		nomeVacina.setFont(new Font("", 0, 18));
		painel.add(nomeVacina);

	}
	
	public void dataVacina() {
		JLabel data = new JLabel("Data:");
		data.setBounds(100, 150, 100, 40);
		data.setFont(new Font("", 0, 18));
		painel.add(data);
	}

	public void laboratorio() {
		JLabel laboratorio = new JLabel("Laboratorio:");
		laboratorio.setBounds(100, 190, 130, 40);
		laboratorio.setFont(new Font("", 0, 18));
		painel.add(laboratorio);
	}
	
	public void lote() {
		JLabel lote = new JLabel("Lote:");
		lote.setBounds(100, 230, 100, 40);
		lote.setFont(new Font("", 0, 18));
		painel.add(lote);

	}
	
	
	public void necRevacinar() {
		JLabel necRevacinar = new JLabel("É necessário revacinar?");
		necRevacinar.setBounds(100, 270, 250, 40);
		necRevacinar.setFont(new Font("", 0, 18));
		painel.add(necRevacinar);
	}
	
	public void tempode() {
		tempode = new JLabel("Em um intervalo de:");
		tempode.setBounds(100, 310, 250, 40);
		tempode.setFont(new Font("", 0, 18));
		tempode.setVisible(false);
		painel.add(tempode);
	}
	
	public void anotacoes() {
		JLabel anot = new JLabel("Anotações:");
		anot.setBounds(100, 340, 300, 40);
		anot.setFont(new Font("", 0, 18));
		painel.add(anot);
	}
	
	public void botaoConfirmar() {
		JButton botao = new JButton("Confirmar");
		botao.setBounds(230, 435, 100, 40);
		botao.setActionCommand("Confirmar");
		botao.addActionListener(this);
		painel.add(botao);
		
	}
	
	public void dadosVacina(JTextField textNome, JFormattedTextField textData, JTextField textLaboratorio, JTextField textLote,
			JRadioButton sim, JRadioButton nao, JTextField intIntervalo, JComboBox<String> boxIntervalo, JTextArea textAnotacoes) {

		String nomeMedicamento = textNome.getText();
		String data = textData.getText();
		String laboratorio = textLaboratorio.getText();
		String lote = textLote.getText();
		boolean necRevacinar = sim.isSelected();
		int periodo = 0;
		Intervalo tempoIntervalo = null;
		if (necRevacinar == true) {
			periodo = Integer.parseInt(intIntervalo.getText());

			int escolhaIntervalo = boxIntervalo.getSelectedIndex();
			switch(escolhaIntervalo) {
			case 1:
				tempoIntervalo = Intervalo.DIAS;
				break;
			case 2:
				tempoIntervalo = Intervalo.MESES;
				break;
			case 3:
				tempoIntervalo = Intervalo.ANOS;
				break;
			default:
				tempoIntervalo = null;
				break;
			}
		} else {
			periodo = 0;
			tempoIntervalo = null;
		}
		
		String anotacoes = textAnotacoes.getText();
		
		controleVacina.editarVacina(i, lote, laboratorio, necRevacinar, nomeMedicamento, data, periodo, tempoIntervalo, anotacoes);
		
	}
	
	public static void main(String[] args) {
		new Inicio();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaVacina(dados, i, nome);
	         frame.dispose();
		}
		if ("Confirmar" == e.getActionCommand()) {
			 dadosVacina(textNome, textData, textLaboratorio, textLote, sim, nao, intIntervalo, boxIntervalo, textAnotacoes);
			 new TelaVacina(dados, i, nome);
			 JOptionPane.showMessageDialog(null, "Vacina alterada com sucesso!");
	         frame.dispose();
		} 
		if (sim.isSelected() == true) {
			tempode.setVisible(true);
			intIntervalo.setVisible(true);
			boxIntervalo.setVisible(true);
		}
		if (sim.isSelected() == false) {
			tempode.setVisible(false);
			intIntervalo.setVisible(false);
			boxIntervalo.setVisible(false);
		} 
		
	}
}
