package view;

import java.awt.BorderLayout;
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

import controller.ControleDados;

/**
 * tela de início
 * 
 * @author catarina
 *
 */
public class Inicio implements ActionListener {
	private JFrame frame;
	private ControleDados dados = new ControleDados();
		
	Inicio(){
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		implementarTemplate();
		implementarBotao();
	}
	
	Inicio(ControleDados dados){
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.dados = dados;
		implementarTemplate();
		implementarBotao();
	}
	
	public void implementarTemplate() {
		try {
			BufferedImage img = ImageIO.read(getClass().getResource("/imagens/telaentrada.jpg"));
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


	public void implementarBotao() {
		JButton botao = new JButton("Começar");
		botao.setBounds(260, 500, 100, 40);
		botao.setActionCommand("começar");
		botao.addActionListener(this);
		frame.add(botao);
		
	}

	public static void main(String[] args) {
		new Inicio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("começar" == e.getActionCommand()) {
			 new TelaListaPets(dados);
	         frame.dispose();
	}
		
	}
}
