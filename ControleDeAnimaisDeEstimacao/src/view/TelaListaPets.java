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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControleAnimal;
import controller.ControleDados;

public class TelaListaPets implements ActionListener, ListSelectionListener {
	private static JFrame frame;
	private static JPanel painel;
	JList<String> listaPets; 
	private ControleAnimal controleAnimal;
	private ControleDados dados = new ControleDados();
	
	public TelaListaPets(ControleDados dados) {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.dados = dados;
		controleAnimal = new ControleAnimal(dados);
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
		listaPets();
		botaoAdicaoPet();
	}
	
	public void listaPets() {
		listaPets = new JList<String>();
		listaPets.setModel(controleAnimal.getListaAnimais());
		listaPets.setBounds(10, 50, 530, 420);
		listaPets.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaPets.addListSelectionListener(this);
		painel.add(listaPets);
	}
	
	public void texto() {
		JLabel Pets = new JLabel("Pets");
		Pets.setBounds(20, 13, 250, 20);
		Pets.setFont(new Font("", Font.BOLD, 25));
		Pets.setForeground(Color.BLACK);
		painel.add(Pets);
	}
	
	public void botaoAdicaoPet() {
		JButton botaoCadastrar = new JButton("Adicionar Pet");
		botaoCadastrar.setBounds(425, 13, 120, 30);
		botaoCadastrar.setActionCommand("adicionarPet");
		botaoCadastrar.addActionListener(this);
		painel.add(botaoCadastrar);	
	}
	
	public static void main(String[] args) {
		new Inicio();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("adicionarPet" == e.getActionCommand()) {
			 new TelaCriarPet();
	         frame.dispose();
		} 
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaPets) {
			controleAnimal.verAnimal(listaPets.getSelectedValue().toString());
			frame.dispose();
		}
		
	}

}
