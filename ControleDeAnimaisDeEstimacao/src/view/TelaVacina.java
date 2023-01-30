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
import controller.ControleVacina;
import enumerate.Intervalo;

/**
 * tela responsável pelos dados da vacina
 * @author catarina
 *
 */
public class TelaVacina implements ActionListener {
	private JFrame frame;
	private JPanel painel;
	private ControleDados dados = new ControleDados();
	private ControleVacina controleVacina;
	private JLabel nomeString;
	private JLabel lblNome;
	private String nome;
	private JLabel lblData;
	private JLabel data;
	private JLabel lblLaboratorio;
	private JLabel laboratorio;
	private JLabel lblLote;
	private JLabel lote;
	private JLabel lblRevacina;
	private JLabel textRevacina;
	private String lblIntervalo;
	private JLabel anotacoes;
	private JLabel lblAnotacoes;
	private int i;
	
	public TelaVacina(ControleDados dados, int i, String nome) {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.dados = dados;
		this.controleVacina = new ControleVacina(dados);
		this.i = i;
		this.nome = nome;
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
		
		implementarElementosVacina();
	}
	
	public void implementarElementosVacina() {
		texto();
		botaoEditar();
		dadosVacina(i);
		botaoExcluir();
	}
	
	public void dadosVacina(int i) {
		for (int j = 0; j < dados.getAnimais().get(i).getVacinas().size(); j++) {
			if(dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento().equals(nome)) {
				String nome = dados.getAnimais().get(i).getVacinas().get(j).getNomeMedicamento();
				
				lblNome = new JLabel("Nome:");
				lblNome.setBounds(180, 100, 100, 40);
				lblNome.setFont(new Font("", Font.BOLD, 22));
				nomeString = new JLabel(nome);
				nomeString.setBounds(260, 100, 300, 40);
				nomeString.setFont(new Font("", Font.PLAIN, 22));
				
				lblData = new JLabel("Data:");
				lblData.setBounds(189, 140, 100, 40);
				lblData.setFont(new Font("", Font.BOLD, 22));
				data = new JLabel(dados.getAnimais().get(i).getVacinas().get(j).getData());
				data.setBounds(260, 140, 300, 40);
				data.setFont(new Font("", Font.PLAIN, 22));
				
				lblLaboratorio = new JLabel("Laboratório:");
				lblLaboratorio.setBounds(115, 180, 250, 40);
				lblLaboratorio.setFont(new Font("", Font.BOLD, 22));
				laboratorio = new JLabel(dados.getAnimais().get(i).getVacinas().get(j).getLaboratorio());
				laboratorio.setBounds(260, 180, 300, 40);
				laboratorio.setFont(new Font("", Font.PLAIN, 22));
				
				lblLote = new JLabel("Lote:");
				lblLote.setBounds(189, 220, 100, 40);
				lblLote.setFont(new Font("", Font.BOLD, 22));
				lote = new JLabel(dados.getAnimais().get(i).getVacinas().get(j).getLote());
				lote.setBounds(260, 220, 300, 40);
				lote.setFont(new Font("", Font.PLAIN, 22));
				
				lblRevacina = new JLabel("É necessário revacinar?");
				lblRevacina.setBounds(40, 260, 300, 40);
				lblRevacina.setFont(new Font("", Font.BOLD, 22));
				boolean revacina = dados.getAnimais().get(i).getVacinas().get(j).isNecRevacinar();
				if (revacina == true) {
					Intervalo intervalo = dados.getAnimais().get(i).getVacinas().get(j).getIntervalo();
					switch(intervalo) {
					case ANOS:
						lblIntervalo = new String("anos.");
						break;
					case MESES:
						lblIntervalo = new String("meses.");
						break;
					case DIAS:
						lblIntervalo = new String("dias.");
						break;
					default:
						break;
					}
					
					textRevacina = new JLabel("Sim, em " + dados.getAnimais().get(i).getVacinas().get(j).getPeriodo() + " " + lblIntervalo);
					textRevacina.setBounds(320, 260, 300, 40);
					textRevacina.setFont(new Font("", Font.PLAIN, 22));
				} else if (revacina == false) {
					textRevacina = new JLabel("Não");
					textRevacina.setBounds(320, 260, 300, 40);
					textRevacina.setFont(new Font("", Font.PLAIN, 22));
				}
				
				lblAnotacoes = new JLabel("Anotações:");
				lblAnotacoes.setBounds(100, 300, 300, 40);
				lblAnotacoes.setFont(new Font("", Font.BOLD, 22));
				anotacoes = new JLabel(dados.getAnimais().get(i).getVacinas().get(j).getAnotacoes());
				anotacoes.setBounds(230, 300, 300, 40);
				anotacoes.setFont(new Font("", Font.PLAIN, 22));
			}
		}
		painel.add(lblNome);
		painel.add(nomeString);
		painel.add(lblData);
		painel.add(data);
		painel.add(lblLaboratorio);
		painel.add(laboratorio);
		painel.add(lblLote);
		painel.add(lote);
		painel.add(lblRevacina);
		painel.add(textRevacina);
		painel.add(anotacoes);
		painel.add(lblAnotacoes);
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
		JLabel remedio = new JLabel("Vacina");
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
			new TelaEditarVacina(dados, i, nome);
			frame.dispose();
		} else if ("excluir" == e.getActionCommand()) {
			controleVacina.excluirVacina(nome, i);
			new TelaPerfilPet(dados, i);
			JOptionPane.showMessageDialog(null, "Vacina deletada com sucesso");
			frame.dispose();
		}
		
	}

}
