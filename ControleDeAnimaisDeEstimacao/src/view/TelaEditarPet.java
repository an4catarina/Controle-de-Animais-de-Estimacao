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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.ControleDados;

public class TelaEditarPet implements ActionListener {
	private static JFrame frame;
	private static JPanel painel;
	ControleDados dados = new ControleDados();
	
	TelaEditarPet(ControleDados dados) {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.dados = dados;
		
		implementarTemplate();
		painelPets();
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
	
	public void labelAdicionarPet() {
		JLabel meusPets = new JLabel("Editar pet");
		meusPets.setBounds(210, 0, 250, 150);
		meusPets.setFont(new Font("", Font.BOLD, 30));
		meusPets.setForeground(Color.BLACK);
		painel.add(meusPets);
	}
	
	public void nomeAnimal() {
		painel.setLayout(null);
		JLabel nomeAnimal = new JLabel("Nome:");
		nomeAnimal.setBounds(140, 110, 100, 40);
		nomeAnimal.setFont(new Font("", 0, 18));
		painel.add(nomeAnimal);
		
		JTextField textNome = new JTextField();
		textNome.setBounds(220, 120, 200, 20);
		painel.add(textNome);
		
	}
	
	public void especie() {
		painel.setLayout(null);
		JLabel especie = new JLabel("Especie:");
		especie.setBounds(140, 150, 100, 40);
		especie.setFont(new Font("", 0, 18));
		painel.add(especie);
		
		String[] especies = {"", "Canino", "Felino", "Ave", "Roedor"};
		JComboBox<String> boxEspecie = new JComboBox(especies);
		boxEspecie.setBounds(220, 162, 200, 20);
		painel.add(boxEspecie);
	}

	public void raca() {
		painel.setLayout(null);
		JLabel raca = new JLabel("Raça:");
		raca.setBounds(140, 190, 100, 40);
		raca.setFont(new Font("", 0, 18));
		painel.add(raca);
		JTextField textRaca = new JTextField();
		textRaca.setBounds(220, 200, 200, 20);
		painel.add(textRaca);
		
	}
	
	public void genero() {
		painel.setLayout(null);
		JLabel genero = new JLabel("Genero:");
		genero.setBounds(140, 230, 100, 40);
		genero.setFont(new Font("", 0, 18));
		painel.add(genero);
		
		String[] generos = {"", "Machp", "Fêmea", "Indefinido"};
		JComboBox<String> boxGeneros = new JComboBox(generos);
		boxGeneros.setBounds(220, 238, 200, 20);
		painel.add(boxGeneros);
		
	}
	
	public void idade() {
		painel.setLayout(null);
		JLabel idade = new JLabel("Idade:");
		idade.setBounds(140, 270, 100, 40);
		idade.setFont(new Font("", 0, 18));
		painel.add(idade);
		JTextField textIdade = new JTextField();
		textIdade.setBounds(220, 280, 200, 20);
		painel.add(textIdade);
		
	}
	
	public void porte() {
		painel.setLayout(null);
		JLabel porte = new JLabel("Porte:");
		porte.setBounds(140, 310, 100, 40);
		porte.setFont(new Font("", 0, 18));
		painel.add(porte);
		
		String[] portes = {"", "Mini", "Pequeno", "Medio", "Grande"};
		JComboBox<String> boxPorte = new JComboBox(portes);
		boxPorte.setBounds(220, 321, 200, 20);
		painel.add(boxPorte);
		
	}
	
	public void botaoConfirmar() {
		JButton botao = new JButton("Confirmar");
		botao.setBounds(230, 400, 100, 40);
		botao.setActionCommand("Confirmar");
		botao.addActionListener(this);
		painel.add(botao);
		
	}
	
	public static void main(String[] args) {
		new Inicio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if ("voltar" == e.getActionCommand()) {
//			 new TelaPerfilPet(dados);
//	         frame.dispose();
//		}
//		else if ("Confirmar" == e.getActionCommand()) {
//			 new TelaPerfilPet(dados);
//	         frame.dispose();
//		}
		
	}
}
