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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class TelaPerfilTutor implements ActionListener {
	JFrame frame = new JFrame();
	private static JPanel painelTutor;
	private static JPanel painelPet;

	TelaPerfilTutor() {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		implementarTemplate();
		painelTutor();
		painelPet();
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
	
	public void painelTutor() {
		painelTutor = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painelTutor.setBounds(25, 170, 550, 220);
		painelTutor.setBackground(new Color(211, 211, 211));
		painelTutor.setBorder(blackline);
		painelTutor.setLayout(null);
		frame.add(painelTutor);
		implementarElementosTutor();
	}
	
	public void implementarElementosTutor() {
		botaoEditarTutor();
		textoTutor();
	}
	
	public void textoTutor() {
		JLabel tutor = new JLabel("Tutor");
		tutor.setBounds(20, 13, 250, 20);
		tutor.setFont(new Font("", Font.BOLD, 25));
		tutor.setForeground(Color.BLACK);
		painelTutor.add(tutor);
	}
	
	public void botaoEditarTutor() {
		JButton botaoEditarPet = new JButton("Editar");
		botaoEditarPet.setActionCommand("editarTutor");
		botaoEditarPet.addActionListener(this);
		botaoEditarPet.setBounds(470, 12, 70, 30);
		painelTutor.add(botaoEditarPet);
		
	}
	
	public void painelPet() {
		painelPet = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painelPet.setBounds(25, 410, 550, 250);
		painelPet.setBackground(new Color(211, 211, 211));
		painelPet.setBorder(blackline);
		painelPet.setLayout(null);
		frame.add(painelPet);
		implementarElementosPet();
	}
	
	public void implementarElementosPet() {
		botaoAdicionarPet();
		listaPets();
		texto();
		botaoVerPet();
		botaoAdicionarPet();
		botaoExcluirPet();
	}
	
	public void listaPets() {
		JList listaPet = new JList();
		listaPet.setBounds(10, 50, 530, 190);
		listaPet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		painelPet.add(listaPet);
	}
	
	public void texto() {
		JLabel pet = new JLabel("Pets");
		pet.setBounds(20, 13, 250, 20);
		pet.setFont(new Font("", Font.BOLD, 25));
		pet.setForeground(Color.BLACK);
		painelPet.add(pet);
	}
	
	public void botaoVerPet() {
		JButton botao = new JButton("Ver pet");
		botao.setActionCommand("verPet");
		botao.addActionListener(this);
		botao.setBounds(195, 13, 100, 30);
		painelPet.add(botao);	
	}

	public void botaoAdicionarPet() {
		JButton botaoEditarPet = new JButton("Adicionar pet");
		botaoEditarPet.setBounds(295, 13, 130, 30);
		botaoEditarPet.setActionCommand("adicionarPet");
		botaoEditarPet.addActionListener(this);
		painelPet.add(botaoEditarPet);
		
	}
	
	public void botaoExcluirPet() {
		JButton botao = new JButton("Excluir pet");
		botao.setBounds(425, 13, 120, 30);
		painelPet.add(botao);	
	}
	
	public static void main(String[] args) {
		new TelaPerfilTutor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaListaTutores();
	         frame.dispose();
		} else if ("adicionarPet" == e.getActionCommand()) {
			 new TelaCriarPet();
	         frame.dispose();
		} else if ("editarTutor" == e.getActionCommand()) {
			 new TelaEditarTutor();
	         frame.dispose();
		} else if ("verPet" == e.getActionCommand()) {
			 new TelaPerfilPet();
	         frame.dispose();
		} 
	}
}
