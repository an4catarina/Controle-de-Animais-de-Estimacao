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

public class TelaEditarVacina implements ActionListener {
	private static JFrame frame;
	private static JPanel painel;
	private static JRadioButton sim;
	private static JRadioButton nao;
	JLabel tempode;
	JTextField num;
	JComboBox<String> boxIntervalo;
	String[] intervalo = {"", "Dias", "Meses", "Anos"};
	
	
	TelaEditarVacina() {
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
	}
	
	
	public void labelEditarVacina() {
		JLabel editarVacina = new JLabel("Editar vacina");
		editarVacina.setBounds(150, 0, 280, 150);
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
		
		JTextField textNome = new JTextField();
		textNome.setBounds(220, 120, 200, 20);
		painel.add(textNome);
		
	}
	
	public void dataVacina() {
		painel.setLayout(null);
		JLabel data = new JLabel("Data:");
		data.setBounds(100, 150, 100, 40);
		data.setFont(new Font("", 0, 18));
		painel.add(data);
		
		JTextField boxVacina = new JTextField();
		boxVacina.setBounds(220, 120, 200, 20);
		boxVacina.setBounds(220, 162, 200, 20);
		painel.add(boxVacina);
	}

	public void laboratorio() {
		painel.setLayout(null);
		JLabel laboratorio = new JLabel("Laboratorio:");
		laboratorio.setBounds(100, 190, 130, 40);
		laboratorio.setFont(new Font("", 0, 18));
		painel.add(laboratorio);
		
		JTextField textLaboratorio = new JTextField();
		textLaboratorio.setBounds(220, 200, 200, 20);
		painel.add(textLaboratorio);
		
	}
	
	public void lote() {
		painel.setLayout(null);
		JLabel lote = new JLabel("Lote:");
		lote.setBounds(100, 230, 100, 40);
		lote.setFont(new Font("", 0, 18));
		painel.add(lote);
		
		JTextField textLote = new JTextField();
		textLote.setBounds(220, 238, 200, 20);
		painel.add(textLote);
		
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
			 new TelaPerfilAnimal();
	         frame.dispose();
		}
		if ("Confirmar" == e.getActionCommand()) {
			 new TelaPerfilAnimal();
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
