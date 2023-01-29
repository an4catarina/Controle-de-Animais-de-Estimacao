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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ControleDados;
import controller.ControleRemedio;
import enumerate.Dosagem;
import enumerate.Frequencia;
import enumerate.Intervalo;
import enumerate.Porte;

public class TelaRemedio implements ActionListener {
	private JFrame frame;
	private JPanel painel;
	private ControleDados dados = new ControleDados();
	private String nome;
	private int i;
	private ControleRemedio controleRemedio;
	private JLabel lblNome;
	private JLabel lblData;
	private String data;
	private JLabel lblDataF;
	private String dataF;
	private JLabel lblDosagem;
	private String dos;
	private JLabel frequencia;
	private JLabel labelVezesDia;
	
	public TelaRemedio(ControleDados dados, int i, String nome) {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.dados = dados;
		this.i = i;
		this.nome = nome;
		controleRemedio = new ControleRemedio(dados);
		
		implementarTemplate();
		botaoVoltar();
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
	
	public void botaoVoltar() {
		JButton botao = new JButton("Voltar");
		botao.setActionCommand("voltar");
		botao.addActionListener(this);
		botao.setBounds(500, 12, 70, 30);
		frame.add(botao);
	}
	
	public void painel() {
		painel = new JPanel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		painel.setBounds(25, 170, 550, 480);
		painel.setBackground(new Color(211, 211, 211));
		painel.setBorder(blackline);
		painel.setLayout(null);
		frame.add(painel);
		
		implementarElementosRemedio();
	}
	
	public void implementarElementosRemedio() {
		texto();
		botaoEditar();
		botaoExcluir();
		dadosRemedio(i);
	}
	
	public void dadosRemedio(int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getRemedios().size(); j++) {
			if(dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento().equals(nome)) {
				String nome = dados.getAnimais().get(i).getRemedios().get(j).getNomeMedicamento();
				
				JLabel nomeString = new JLabel(nome);
				lblNome = new JLabel("Nome:" + " " + nome);
				lblNome.setBounds(180, 100, 400, 40);
				lblNome.setFont(new Font("", Font.BOLD, 22));
				
				data = new String(dados.getAnimais().get(i).getRemedios().get(j).getData());
				lblData = new JLabel("Data inicial: "+ " " + data);
				lblData.setBounds(170, 140, 400, 40);
				lblData.setFont(new Font("", Font.BOLD, 22));
				
				dataF = new String(dados.getAnimais().get(i).getRemedios().get(j).getDataFinal());
				lblDataF = new JLabel("Data final: "+ " " + dataF);
				lblDataF.setBounds(155, 180, 400, 40);
				lblDataF.setFont(new Font("", Font.BOLD, 22));			
				
				Dosagem dosagem = dados.getAnimais().get(i).getRemedios().get(j).getDosagem();
				if (dosagem == Dosagem.ML) {
					dos = "ml";
				} else if (dosagem == Dosagem.MG) {
					dos = "mg";
				} else if (dosagem == Dosagem.G) {
					dos = "g";
				} else if (dosagem == Dosagem.GOTA) {
					dos = "gota(s)";
				} else if (dosagem == Dosagem.COMPRIMIDO) {
					dos = "comprimido(s)";
				} else if (dosagem == Dosagem.CAPSULA) {
					dos = "cápsula(s)";
				}
				String nroDosagem = new String(Integer.toString(dados.getAnimais().get(i).getRemedios().get(j).getNroDosagem()));
				lblDosagem = new JLabel("Dosagem: " + " " + nroDosagem + " " + dos);
				lblDosagem.setBounds(180, 220, 250, 40);
				lblDosagem.setFont(new Font("", Font.BOLD, 22));
				
				Frequencia fr = dados.getAnimais().get(i).getRemedios().get(j).getFrequencia();
				String sr = null;
				if (fr == Frequencia.UMAVEZ) {
					sr = "Uma vez.";
				} else if (fr == Frequencia.USOCONTINUO) {
					sr = "Uso contínuo.";
				} else if (fr == Frequencia.USOTEMPORARIO) {
					sr = "Uso temporário.";
				}
				frequencia = new JLabel("Frequência: " + sr);
				frequencia.setBounds(160, 260, 250, 40);
				frequencia.setFont(new Font("",Font.BOLD, 22));
				
				String qtd = new String(Integer.toString(dados.getAnimais().get(i).getRemedios().get(j).getQtdVezes()));
				labelVezesDia = new JLabel("Vezes por dia: " + qtd + " vez(es).");
				labelVezesDia.setBounds(145, 300, 400, 40);
				labelVezesDia.setFont(new Font("", Font.BOLD, 22));
			}
		}
		painel.add(lblNome);
		painel.add(lblData);
		painel.add(lblDataF);
		painel.add(lblDosagem);
		painel.add(frequencia);
		painel.add(labelVezesDia);
	}
	
	public void botaoEditar() {
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.setActionCommand("editar");
		botaoEditar.addActionListener(this);
		botaoEditar.setBounds(410, 12, 70, 30);
		painel.add(botaoEditar);
	}
	
	public void botaoExcluir() {
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.setActionCommand("excluir");
		botaoExcluir.addActionListener(this);
		botaoExcluir.setBounds(475, 12, 70, 30);
		painel.add(botaoExcluir);
		
	}
	
	public void texto() {
		JLabel remedio = new JLabel("Remedio");
		remedio.setBounds(20, 13, 250, 20);
		remedio.setFont(new Font("", Font.BOLD, 25));
		remedio.setForeground(Color.BLACK);
		painel.add(remedio);
	}
	
	public static void main(String[] args) {
		new Inicio();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaPerfilPet(dados, i);
	         frame.dispose();
		} else if ("editar" == e.getActionCommand()) {
			new TelaEditarRemedio(dados, i, nome);
			frame.dispose();
		} else if ("excluir" == e.getActionCommand()) {
			controleRemedio.excluirRemedio(nome, i);
			new TelaPerfilPet(dados, i);
			JOptionPane.showMessageDialog(null, "Remedio deletado com sucesso");
			frame.dispose();
		}
	}

}
