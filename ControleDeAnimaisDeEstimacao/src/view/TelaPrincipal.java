package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal implements ActionListener {
	JFrame frame = new JFrame("My Pet Care");
	JLabel label = new JLabel();
	
	public TelaPrincipal() {
		frame.setSize(1100, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		implementarTemplate();
		textoPet();
	}
	public void implementarTemplate() {
		
		try {
			BufferedImage img = ImageIO.read(getClass().getResource("/imagens/telanormal.jpg"));
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

	
	public void framePets() {
	}
	
	public void listaPets() {
		
	}
	
	public void textoPet() {
		label.setText("Meus Pets");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setHorizontalTextPosition(JLabel.TOP);
		label.setForeground(Color.PINK);
	}

	public void botaoAdicaoPet() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
