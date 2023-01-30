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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.ControleAnimal;
import controller.ControleDados;
import enumerate.Especie;
import enumerate.Genero;
import enumerate.Porte;
/** 
 * tela responsável pela criação do pet
 * 
 */
public class TelaCriarPet implements ActionListener {
	private JFrame frame;
	private JPanel painel;
	private JTextField textNome;
	private JComboBox<String> boxEspecie;
	private JTextField textRaca;
	private JComboBox<String> boxGeneros;
	private JTextField textIdade;
	private JComboBox<String> boxPorte;
	private ControleAnimal controleAnimal;
	private ControleDados dados;

	TelaCriarPet() {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		dados = new ControleDados();
		controleAnimal = new ControleAnimal(dados);
		implementarTemplate();
		painelPets();
		botaoVoltar();
	}
	
	/**
	 * implementação imagem de fundo
	 */
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
	
	/**
	 * botao voltar 
	 */
	public void botaoVoltar() {
		JButton botao = new JButton("Voltar");
		botao.setActionCommand("voltar");
		botao.addActionListener(this);
		botao.setBounds(500, 12, 70, 30);
		frame.add(botao);
	}
	/**
	 * painel com os elementos relacionados ao pet
	 */
	public void painelPets() {
		painel = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painel.setBounds(25, 170, 550, 480);
		painel.setBackground(new Color(211, 211, 211));
		painel.setBorder(blackline);
		painel.setLayout(new BorderLayout());
		frame.add(painel);
		construirCadastro();
	}
	/**
	 * construção dos elementos do painel do pet
	 */
	public void construirCadastro() {
		botaoConfirmar();
		nomeAnimal();
		especie();
		raca();
		genero();
		idade();
		porte();
		labelAdicionarPet();
	}
	/**
	 * label com o texto de adicionar pet
	 */
	public void labelAdicionarPet() {
		JLabel meusPets = new JLabel("Adicionar pet");
		meusPets.setBounds(170, 0, 250, 150);
		meusPets.setFont(new Font("", Font.BOLD, 30));
		meusPets.setForeground(Color.BLACK);
		painel.add(meusPets);
	}
	/*
	 * método com a adição do nome do animal
	 */
	public void nomeAnimal() {
		painel.setLayout(null);
		JLabel nomeAnimal = new JLabel("Nome:");
		nomeAnimal.setBounds(140, 110, 100, 40);
		nomeAnimal.setFont(new Font("", 0, 18));
		painel.add(nomeAnimal);
		
		textNome = new JTextField();
		textNome.setBounds(220, 120, 200, 20);
		painel.add(textNome);
		
	}	
	
	/*
	 * método com a adição do nome da esoécie
	 */
	public void especie() {
		painel.setLayout(null);
		JLabel especie = new JLabel("Especie:");
		especie.setBounds(140, 150, 100, 40);
		especie.setFont(new Font("", 0, 18));
		painel.add(especie);
		
		String[] especies = {"", "Canino", "Felino", "Ave", "Roedor"};
		boxEspecie = new JComboBox<String>(especies);
		boxEspecie.setBounds(220, 162, 200, 20);
		painel.add(boxEspecie);
	}
	/*
	 * método com a adição da raça
	 */

	public void raca() {
		painel.setLayout(null);
		JLabel raca = new JLabel("Raça:");
		raca.setBounds(140, 190, 100, 40);
		raca.setFont(new Font("", 0, 18));
		painel.add(raca);
		
		textRaca = new JTextField();
		textRaca.setBounds(220, 200, 200, 20);
		painel.add(textRaca);
		
	}
	/*
	 * método com a adição do nome do genero
	 */
	public void genero() {
		painel.setLayout(null);
		JLabel genero = new JLabel("Genero:");
		genero.setBounds(140, 230, 100, 40);
		genero.setFont(new Font("", 0, 18));
		painel.add(genero);
		
		String[] generos = {"", "Macho", "Fêmea", "Indefinido"};
		boxGeneros = new JComboBox<String>(generos);
		boxGeneros.setBounds(220, 238, 200, 20);
		painel.add(boxGeneros);
		
	}
	/*
	 * método com a adição do nome da idade
	 */
	public void idade() {
		painel.setLayout(null);
		JLabel idade = new JLabel("Idade:");
		idade.setBounds(140, 270, 100, 40);
		idade.setFont(new Font("", 0, 18));
		painel.add(idade);
		
		textIdade = new JTextField();
		textIdade.setBounds(220, 280, 200, 20);
		painel.add(textIdade);
		
	}
	/*
	 * método com a adição do nome do porte
	 */
	
	public void porte() {
		painel.setLayout(null);
		JLabel porte = new JLabel("Porte:");
		porte.setBounds(140, 310, 100, 40);
		porte.setFont(new Font("", 0, 18));
		painel.add(porte);
		
		String[] portes = {"", "Mini", "Pequeno", "Medio", "Grande"};
		boxPorte = new JComboBox<String>(portes);
		boxPorte.setBounds(220, 321, 200, 20);
		painel.add(boxPorte);
		
	}
	/*
	 * botao confirmar
	 */
	public void botaoConfirmar() {
		JButton botao = new JButton("Confirmar");
		botao.setBounds(230, 380, 100, 40);
		botao.setActionCommand("Confirmar");
		botao.addActionListener(this);
		painel.add(botao);
		
	}
	
	/*
	 * método responsável pela adição dos dados escitos em um animal
	 */
	public void dadosAnimal(JTextField textNome, JComboBox<String> boxEspecie, JTextField textRaca, JComboBox<String> boxGeneros, JTextField textIdade, JComboBox<String> boxPorte) {
		String nome = textNome.getText();
		
		Especie especie = null;
		int escolhaEspecie = boxEspecie.getSelectedIndex();
		switch(escolhaEspecie) {
		case 1:
			especie = Especie.CANINO;
			break;
		case 2:
			especie = Especie.FELINO;
			break;
		case 3:
			especie = Especie.AVE;
			break;
		case 4:
			especie = Especie.ROEDOR;
			break;
		default:
			especie = null;
			break;
		}
		
		String raca = textRaca.getText();
		
		Genero genero = null;
		int escolhaGenero = boxGeneros.getSelectedIndex();
		switch(escolhaGenero) {
		case 1:
			genero = Genero.MACHO;
			break;
		case 2:
			genero = Genero.FEMEA;
			break;
		case 3:
			genero = Genero.INDEFINIDO;
			break;
		default:
			genero = null;
			break;
		}
		
		int idade = Integer.parseInt(textIdade.getText());
		
		Porte porte = null;
		int escolhaPorte = boxPorte.getSelectedIndex();
		switch(escolhaPorte) {
		case 1:
			porte = Porte.MINI;
			break;
		case 2:
			porte = Porte.PEQUENO;
			break;
		case 3:
			porte = Porte.MEDIO;
			break;
		case 4:
			porte = Porte.GRANDE;
			break;
		default:
			porte = null;
			break;
		}
			
		controleAnimal.adicionarAnimal(nome, especie, raca, genero, idade, porte);
		
		
		} 
	
	public static void main(String[] args) {
		new Inicio();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaListaPets(dados);
	         frame.dispose();
		}
		else if ("Confirmar" == e.getActionCommand()) {
			 dadosAnimal(textNome, boxEspecie, textRaca, boxGeneros, textIdade, boxPorte);
			 new TelaListaPets(dados);
			 JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
	         frame.dispose();
		}
		
	}

}
