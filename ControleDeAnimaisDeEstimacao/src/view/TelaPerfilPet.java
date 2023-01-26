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
import javax.swing.border.Border;

public class TelaPerfilPet implements ActionListener {
	JFrame frame = new JFrame();
	private static JPanel painelPet;
	private static JPanel painelVacinas;
	private static JPanel painelRemedios;

	public TelaPerfilPet() {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		implementarTemplate();
		painelPet();
		painelRemedios();
		painelVacinas();
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
	
	public void painelPet() {
		painelPet = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painelPet.setBounds(25, 170, 550, 240);
		painelPet.setBackground(new Color(211, 211, 211));
		painelPet.setBorder(blackline);
		painelPet.setLayout(null);
		frame.add(painelPet);
		implementarElementosPet();
	}
	
	public void implementarElementosPet() {
		botaoEditarPet();
		texto();
	}
	
	public void texto() {
		JLabel pet = new JLabel("Pet");
		pet.setBounds(20, 13, 250, 20);
		pet.setFont(new Font("", Font.BOLD, 25));
		pet.setForeground(Color.BLACK);
		painelPet.add(pet);
	}
	
	public void botaoEditarPet() {
		JButton botaoEditarPet = new JButton("Editar");
		botaoEditarPet.setActionCommand("editarPet");
		botaoEditarPet.addActionListener(this);
		botaoEditarPet.setBounds(475, 12, 70, 30);
		painelPet.add(botaoEditarPet);
		
	}
	
	public void painelVacinas() {
		painelVacinas = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painelVacinas.setBounds(25, 430, 270, 230);
		painelVacinas.setBackground(new Color(211, 211, 211));
		painelVacinas.setBorder(blackline);
		painelVacinas.setLayout(null);
		frame.add(painelVacinas);
		implementarElementosVacinas();
	}
	
	public void implementarElementosVacinas() {
		textoVacinas();
		botaoCriarVacina();
		botaoVerVacina();
		botaoExcluirVacina();
		listaVacinas();
	}
	
	public void textoVacinas() {
		JLabel vacinas = new JLabel("Vacinas");
		vacinas.setBounds(10, 13, 150, 20);
		vacinas.setFont(new Font("", Font.BOLD, 15));
		vacinas.setForeground(Color.BLACK);
		painelVacinas.add(vacinas);
	}
	
	public void botaoVerVacina() {
		JButton botao = new JButton("Ver");
		botao.setBounds(80, 11, 70, 30);
		botao.setActionCommand("verVacina");
		botao.addActionListener(this);
		painelVacinas.add(botao);	
	}
	
	public void botaoCriarVacina() {
		JButton botaoCriarVacina = new JButton("Criar");
		botaoCriarVacina.setActionCommand("criarVacina");
		botaoCriarVacina.addActionListener(this);
		botaoCriarVacina.setBounds(140, 11, 70, 30);
		painelVacinas.add(botaoCriarVacina);
	}

	public void botaoExcluirVacina() {
		JButton botao = new JButton("Excluir");
		botao.setBounds(200, 11, 70, 30);
		painelVacinas.add(botao);	
	}
	
	public void listaVacinas() {
		JList<String> vacinas = new JList<String>();
		vacinas.setBounds(10, 50, 250, 170);
		painelVacinas.add(vacinas);
	}
	
	public void painelRemedios() {
		painelRemedios = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painelRemedios.setBounds(306, 430, 267, 230);
		painelRemedios.setBackground(new Color(211, 211, 211));
		painelRemedios.setBorder(blackline);
		painelRemedios.setLayout(null);
		frame.add(painelRemedios);
		implementarElementosRemedios();
	}
	
	public void implementarElementosRemedios() {
		botaoCriarRemedio();
		textoRemedios();
		botaoVerRemedio();
		botaoExcluirRemedio();
		listaRemedios();
	}
	
	public void textoRemedios() {
		JLabel remedios = new JLabel("Remedios");
		remedios.setBounds(10, 13, 150, 20);
		remedios.setFont(new Font("", Font.BOLD, 15));
		remedios.setForeground(Color.BLACK);
		painelRemedios.add(remedios);
	}
	
	public void botaoVerRemedio() {
		JButton botao = new JButton("Ver");
		botao.setBounds(80, 11, 70, 30);
		botao.setActionCommand("verRemedio");
		botao.addActionListener(this);
		painelRemedios.add(botao);	
	}
	
	public void botaoCriarRemedio() {
		JButton botaoCriarRemedio = new JButton("Criar");
		botaoCriarRemedio.setActionCommand("criarRemedio");
		botaoCriarRemedio.addActionListener(this);
		botaoCriarRemedio.setBounds(140, 11, 70, 30);
		painelRemedios.add(botaoCriarRemedio);
		
	}

	public void botaoExcluirRemedio() {
		JButton botao = new JButton("Excluir");
		botao.setBounds(200, 11, 70, 30);
		painelRemedios.add(botao);	
	}
	
	public void listaRemedios() {
		JList<String> remedios = new JList<String>();
		remedios.setBounds(10, 50, 250, 170);
		painelRemedios.add(remedios);
	}
	
	public static void main(String[] args) {
		new TelaPerfilPet();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaListaPets();
	         frame.dispose();
		} else if ("editarPet" == e.getActionCommand()) {
			 new TelaEditarPet();
	         frame.dispose();
		} else if ("criarVacina" == e.getActionCommand()) {
			 new TelaCriarVacina();
	         frame.dispose();
		} else if ("criarRemedio" == e.getActionCommand()) {
			 new TelaCriarRemedio();
	         frame.dispose();
		} else if ("verRemedio" == e.getActionCommand()) {
			 new TelaRemedio();
	         frame.dispose();
		} else if ("verVacina" == e.getActionCommand()) {
			 new TelaVacina();
	         frame.dispose();
		} 
		
	}

}
