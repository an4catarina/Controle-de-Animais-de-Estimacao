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
import javax.swing.JTextField;


public class TelaEntrada implements ActionListener {
	private static JFrame frame;
		
	TelaEntrada(){
		frame = new JFrame("My Pet Care");
		frame.setSize(1100, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		implementarTemplate();
		implementarBotao();
		implementarCaixaDeTexto();
	}
	
	public void implementarTemplate() {
		try {
			BufferedImage img = ImageIO.read(getClass().getResource("/imagens/fundodetelaentrada.jpg"));
			Image dimg = img.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
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
	
	public void implementarCaixaDeTexto() {
		JTextField caixaDeTexto = new JTextField("escreva seu nome");
		caixaDeTexto.setBounds(430, 520, 250, 40);
		frame.add(caixaDeTexto);
	}

	public void implementarBotao() {
		JButton botao = new JButton("Confirmar");
		botao.setBounds(500, 570, 100, 40);
		frame.add(botao);
		
	}

	public void main(String[] args) {
		new TelaEntrada();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
