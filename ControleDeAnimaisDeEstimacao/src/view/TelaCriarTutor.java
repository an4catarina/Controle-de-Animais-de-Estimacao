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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelaCriarTutor implements ActionListener {
	private static JFrame frame;
	private static JPanel painel;
	
	TelaCriarTutor() {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
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
		nomeTutor();
		email();
		numero();
		labelAdicionarTutor();
	}
	
	public void labelAdicionarTutor() {
		JLabel meusPets = new JLabel("Adicionar tutor");
		meusPets.setBounds(170, 0, 250, 150);
		meusPets.setFont(new Font("", Font.BOLD, 30));
		meusPets.setForeground(Color.BLACK);
		painel.add(meusPets);
	}
	
	public void nomeTutor() {
		painel.setLayout(null);
		JLabel nomeTutor = new JLabel("Nome:");
		nomeTutor.setBounds(140, 120, 100, 40);
		nomeTutor.setFont(new Font("", 0, 18));
		painel.add(nomeTutor);
		
		JTextField textTutor = new JTextField();
		textTutor.setBounds(220, 130, 200, 20);
		painel.add(textTutor);
		
	}

	public void email() {
		painel.setLayout(null);
		JLabel email = new JLabel("E-mail:");
		email.setBounds(140, 190, 100, 40);
		email.setFont(new Font("", 0, 18));
		painel.add(email);
		
		JTextField textEmail = new JTextField();
		textEmail.setBounds(220, 200, 200, 20);
		painel.add(textEmail);
		
	}

	
	public void numero() {
		painel.setLayout(null);
		JLabel numero = new JLabel("Número:");
		numero.setBounds(140, 270, 100, 40);
		numero.setFont(new Font("", 0, 18));
		painel.add(numero);
		
		JTextField textNumero = new JTextField();
		textNumero.setBounds(220, 280, 200, 20);
		painel.add(textNumero);
		
	}

	public void botaoConfirmar() {
		JButton botao = new JButton("Confirmar");
		botao.setBounds(230, 400, 100, 40);
		botao.setActionCommand("Confirmar");
		botao.addActionListener(this);
		painel.add(botao);
		
	}
	
	public static void main(String[] args) {
		new TelaCriarTutor();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaPrincipal();
	         frame.dispose();
		} else if ("Confirmar" == e.getActionCommand()) {
			 new TelaPrincipal();
	         frame.dispose();
		}
		
	}

}
