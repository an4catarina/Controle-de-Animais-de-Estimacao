package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelaCriarRemedio implements ActionListener {
	private static JFrame frame;
	private static JPanel painel;
	private static JRadioButton sim;
	private static JRadioButton nao;
	JLabel tempode;
	JTextField num;
	JComboBox<String> boxIntervalo;
	String[] intervalo = {"", "Dias", "Meses", "Anos"};
	String[] dosagens = {"", "mg", "ml", "g", "comprimido(s)", "cápsula(s)", "gota(s)"};
	
	
	TelaCriarRemedio() {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
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
		botao.addActionListener(this);
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
		labelAdicionarRemedio();
		nomeRemedio();
		necRevacinar();
		dosagem();
		botaoConfirmar();
		tempode();
	}
	
	
	public void labelAdicionarRemedio() {
		JLabel adicionarRemedio = new JLabel("Adicionar remédio");
		adicionarRemedio.setBounds(150, 0, 280, 150);
		adicionarRemedio.setFont(new Font("", Font.BOLD, 30));
		adicionarRemedio.setForeground(Color.BLACK);
		painel.add(adicionarRemedio);
	}
	
	public void nomeRemedio() {
		painel.setLayout(null);
		JLabel nomeRemedio = new JLabel("Nome:");
		nomeRemedio.setBounds(100, 110, 100, 40);
		nomeRemedio.setFont(new Font("", 0, 18));
		painel.add(nomeRemedio);
		
		JTextField textNome = new JTextField();
		textNome.setBounds(220, 120, 200, 20);
		painel.add(textNome);
		
	}

	
	public void dosagem() {
		painel.setLayout(null);
		JLabel dosagem = new JLabel("Dosagem:");
		dosagem.setBounds(100, 230, 100, 40);
		dosagem.setFont(new Font("", 0, 18));
		painel.add(dosagem);
		
		JTextField textLote = new JTextField();
		textLote.setBounds(220, 235, 55, 20);
		painel.add(textLote);
		
		JComboBox boxDosagem = new JComboBox(dosagens);
		boxDosagem.setBounds(275, 235, 145, 20);
		painel.add(boxDosagem);
	}
	
	
	public void necRevacinar() {
		painel.setLayout(null);
		JLabel necRevacinar = new JLabel("É necessário revacinar?");
		necRevacinar.setBounds(100, 270, 250, 40);
		necRevacinar.setFont(new Font("", 0, 18));
		painel.add(necRevacinar);
		
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
	
		
	}
	
	public void tempode() {
		tempode = new JLabel("Em um intervalo de:");
		tempode.setBounds(100, 310, 250, 40);
		tempode.setFont(new Font("", 0, 18));
		tempode.setVisible(false);
		painel.add(tempode);
		
	
		num = new JTextField();
		num.setBounds(280, 320, 60, 20);
		num.setVisible(false);
		painel.add(num);
		
		boxIntervalo = new JComboBox(intervalo);
		boxIntervalo.setBounds(340, 320, 90, 20);
		boxIntervalo.setVisible(false);
		painel.add(boxIntervalo);
	}
	
	
	public void botaoConfirmar() {
		JButton botao = new JButton("Confirmar");
		botao.setBounds(230, 400, 100, 40);
		botao.setActionCommand("Confirmar");
		botao.addActionListener(this);
		painel.add(botao);
		
	}
	
	
	public static void main(String[] args) {
		new TelaCriarVacina();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaPerfilPet();
	         frame.dispose();
		}
		if ("Confirmar" == e.getActionCommand()) {
			 new TelaPerfilPet();
	         frame.dispose();
		} 
		if (sim.isSelected() == true) {
			tempode.setVisible(true);
			num.setVisible(true);
			boxIntervalo.setVisible(true);
		}
		if (sim.isSelected() == false) {
			tempode.setVisible(false);
			num.setVisible(false);
			boxIntervalo.setVisible(false);
		} 
		
	}
}
