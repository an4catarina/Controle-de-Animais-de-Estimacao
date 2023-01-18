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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class TelaListaTutores implements ActionListener {
	private static JFrame frame;
	private static JPanel painel;
	String[] teste = {"teste"}; 
	
	TelaListaTutores() {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		implementarTemplate();
		painel();
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
	
	
	public void painel() {
		painel = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painel.setBounds(25, 170, 550, 480);
		painel.setBackground(new Color(211, 211, 211));
		painel.setBorder(blackline);
		painel.setLayout(null);
		frame.add(painel);
		
		implementarElementosPainel();
	}
	
	public void implementarElementosPainel() {
		texto();
		listaTutores();
		botaoVerTutor();
		botaoAdicaoTutor();
		botaoExcluirTutor();
	}
	
	public void listaTutores() {
		JList<String> listaTutores = new JList<String>(teste);
		listaTutores.setBounds(10, 50, 530, 420);
		listaTutores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		painel.add(listaTutores);
		
//		JScrollPane scroll = new JScrollPane(listaTutores, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scroll.setViewportView(listaTutores);
//		painel.add(scroll);
		
	}
	
	public void texto() {
		JLabel tutores = new JLabel("Tutores");
		tutores.setBounds(20, 13, 250, 20);
		tutores.setFont(new Font("", Font.BOLD, 25));
		tutores.setForeground(Color.BLACK);
		painel.add(tutores);
	}
	
	public void botaoVerTutor() {
		JButton botao = new JButton("Ver tutor");
		botao.setActionCommand("verTutor");
		botao.addActionListener(this);
		botao.setBounds(195, 13, 100, 30);
		painel.add(botao);	
	}
	
	public void botaoAdicaoTutor() {
		JButton botao = new JButton("Adicionar tutor");
		botao.setBounds(295, 13, 130, 30);
		botao.setActionCommand("adicionartutor");
		botao.addActionListener(this);
		painel.add(botao);	
	}
	
	public void botaoExcluirTutor() {
		JButton botao = new JButton("Excluir tutor");
		botao.setBounds(425, 13, 120, 30);
		painel.add(botao);	
	}
	
	public static void main(String[] args) {
		new TelaListaTutores();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("adicionartutor" == e.getActionCommand()) {
			 new TelaCriarTutor();
	         frame.dispose();
	} else if ("verTutor" == e.getActionCommand()) {
		 new TelaPerfilTutor();
         frame.dispose();
}
		
	}

}
