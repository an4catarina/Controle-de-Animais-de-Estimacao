package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
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
	}
	
	public void botaoAdicionarPet() {
		JButton botaoEditarPet = new JButton("Adicionar pet");
		botaoEditarPet.setActionCommand("adicionarPet");
		botaoEditarPet.addActionListener(this);
		botaoEditarPet.setBounds(430, 12, 108, 30);
		painelPet.add(botaoEditarPet);
		
	}
	
	public static void main(String[] args) {
		new TelaPerfilTutor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaPrincipal();
	         frame.dispose();
		} else if ("adicionarPet" == e.getActionCommand()) {
			 new TelaCriarAnimal();
	         frame.dispose();
		} else if ("editarTutor" == e.getActionCommand()) {
			 new TelaEditarTutor();
	         frame.dispose();
		}
	}
}
