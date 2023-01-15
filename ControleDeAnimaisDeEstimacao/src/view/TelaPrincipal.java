package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal implements ActionListener {
	private static JFrame frame;
	
	public TelaPrincipal() {
		frame = new JFrame("My Pet Care");
		frame.setSize(1100, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		implementarTemplate();
		painelPets();
		botaoAdicaoPet();
		textoPet();
	}
	public void implementarTemplate() {
		
		try {
			BufferedImage img = ImageIO.read(getClass().getResource("/imagens/telageral.jpg"));
			Image dimg = img.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(dimg);
			JLabel label = new JLabel();
			label.setIcon(icon);
			frame.getContentPane().add(label, BorderLayout.CENTER);
			frame.setContentPane(label);
			frame.setLocationRelativeTo(null);
			frame.pack();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void painelPets() {
		JPanel painel = new JPanel();
		painel.setBounds(25, 150, 1050, 490);
		painel.setBackground(Color.cyan);
		painel.setLayout(new BorderLayout());
		frame.add(painel);
	}
	
	public void listaPets() {
		
	}
	
	public void textoPet() {
		JLabel meusPets = new JLabel("Meus Pets");
		meusPets.setBounds(160, 15, 250, 150);
		meusPets.setFont(new Font("", Font.BOLD, 40));
		meusPets.setForeground(Color.BLACK);
		frame.add(meusPets);
	}

	public void botaoAdicaoPet() {
		JButton botao = new JButton("Adicionar pet");
		botao.setBounds(980, 650, 100, 40);
		frame.add(botao);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
