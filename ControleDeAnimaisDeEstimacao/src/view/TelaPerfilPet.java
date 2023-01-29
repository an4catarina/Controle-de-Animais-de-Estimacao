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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControleAnimal;
import controller.ControleDados;
import controller.ControleRemedio;
import controller.ControleVacina;
import enumerate.Especie;
import enumerate.Genero;
import enumerate.Porte;

public class TelaPerfilPet implements ActionListener, ListSelectionListener {
	private JFrame frame = new JFrame();
	private JPanel painelPet;
	private JPanel painelVacinas;
	private JPanel painelRemedios;
	private ControleVacina controleVacina;
	private ControleRemedio controleRemedio;
	private ControleAnimal controleAnimal;
	private ControleDados dados = new ControleDados();;
	private int i;
	private String nome;
	private String especieS;
	private String raca;
	private String generoS;
	private int idade;
	private String porteS;
	private JList<String> listaVacinas;
	private JList<String> listaRemedios;

	public TelaPerfilPet(ControleDados dados, int i) {
		frame = new JFrame("My Pet Care");
		frame.setSize(600, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		this.i = i;
		this.dados = dados;
		controleVacina = new ControleVacina(dados);
		controleRemedio = new ControleRemedio(dados);
		controleAnimal = new ControleAnimal(dados);
		
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
		botaoExcluirPet();
		texto();
		dadosPet(i);
	}
	
	public void texto() {
		JLabel pet = new JLabel("Pet");
		pet.setBounds(20, 10, 250, 40);
		pet.setFont(new Font("", Font.BOLD, 30));
		pet.setForeground(Color.BLACK);
		painelPet.add(pet);
	}
	
	public void dadosPet(int i) {
		nome = dados.getAnimais().get(i).getNome();
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(60, 70, 100, 40);
		labelNome.setFont(new Font("", Font.BOLD, 20));
		painelPet.add(labelNome);
		JLabel nomeString = new JLabel(nome);
		nomeString.setBounds(150, 70, 300, 40);
		nomeString.setFont(new Font("", Font.PLAIN, 20));
		painelPet.add(nomeString);

		Especie especie = dados.getAnimais().get(i).getEspecie();
		if (especie == Especie.CANINO) {
			especieS = "Canino";
		} else if (especie == Especie.FELINO) {
			especieS = "Felino";
		} else if (especie == Especie.AVE) {
			especieS = "Ave";
		} else if (especie == Especie.ROEDOR) {
			especieS = "Roedor";
		} else {
			especieS = "Não informado";
		}
		
		JLabel labelEspecie = new JLabel("Especie:");
		labelEspecie.setBounds(60, 110, 100, 40);
		labelEspecie.setFont(new Font("", Font.BOLD, 20));
		painelPet.add(labelEspecie);
		JLabel especieString = new JLabel(especieS);
		especieString.setBounds(150, 110, 300, 40);
		especieString.setFont(new Font("", Font.PLAIN, 20));
		painelPet.add(especieString);
		
		raca = dados.getAnimais().get(i).getRaca();
		JLabel labelRaca = new JLabel("Raça:");
		labelRaca.setBounds(60, 150, 100, 40);
		labelRaca.setFont(new Font("", Font.BOLD, 20));
		painelPet.add(labelRaca);
		JLabel racaString = new JLabel(raca);
		racaString.setBounds(150, 150, 300, 40);
		racaString.setFont(new Font("", Font.PLAIN, 20));
		painelPet.add(racaString);
		
		Genero genero = dados.getAnimais().get(i).getGenero();
		if (genero == Genero.FEMEA) {
			generoS = "Fêmea";
		} else if (genero == Genero.MACHO) {
			generoS = "Macho";
		} else if (genero == Genero.INDEFINIDO) {
			generoS = "Indefinido";
		} else {
			generoS = "Não informado";
		}
		
		JLabel labelGenero = new JLabel("Gênero:");
		labelGenero.setBounds(280, 70, 100, 40);
		labelGenero.setFont(new Font("", Font.BOLD, 20));
		painelPet.add(labelGenero);
		JLabel generoString = new JLabel(generoS);
		generoString.setBounds(370, 70, 300, 40);
		generoString.setFont(new Font("", Font.PLAIN, 20));
		painelPet.add(generoString);
		
		idade = dados.getAnimais().get(i).getIdade();
		JLabel labelIdade = new JLabel("Idade:");
		labelIdade.setBounds(282, 110, 100, 40);
		labelIdade.setFont(new Font("", Font.BOLD, 20));
		painelPet.add(labelIdade);
		JLabel idadeString = new JLabel(idade + " anos");
		idadeString.setBounds(370, 110, 300, 40);
		idadeString.setFont(new Font("", Font.PLAIN, 20));
		painelPet.add(idadeString);
		
		Porte porte = dados.getAnimais().get(i).getPorte();
		if (porte == Porte.GRANDE) {
			porteS = "Grande";
		} else if (porte == Porte.MEDIO) {
			porteS = "Médio";
		} else if (porte == Porte.MINI) {
			porteS = "Mini";
		} else if (porte == Porte.PEQUENO) {
			porteS = "Pequeno";
		} else {
			porteS = "Não informado";
		}
		JLabel labelPorte = new JLabel("Porte:");
		labelPorte.setBounds(280, 150, 100, 40);
		labelPorte.setFont(new Font("", Font.BOLD, 20));
		painelPet.add(labelPorte);
		JLabel porteString = new JLabel(porteS);
		porteString.setBounds(370, 150, 300, 40);
		porteString.setFont(new Font("", Font.PLAIN, 20));
		painelPet.add(porteString);
				
			}
	
	public void botaoEditarPet() {
		JButton botaoEditarPet = new JButton("Editar");
		botaoEditarPet.setActionCommand("editarPet");
		botaoEditarPet.addActionListener(this);
		botaoEditarPet.setBounds(410, 12, 70, 30);
		painelPet.add(botaoEditarPet);
	}
	
	public void botaoExcluirPet() {
		JButton botaoExcluirPet = new JButton("Excluir");
		botaoExcluirPet.setActionCommand("excluirPet");
		botaoExcluirPet.addActionListener(this);
		botaoExcluirPet.setBounds(475, 12, 70, 30);
		painelPet.add(botaoExcluirPet);
		
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
		listaVacinas();
	}
	
	public void textoVacinas() {
		JLabel vacinas = new JLabel("Vacinas");
		vacinas.setBounds(10, 13, 150, 20);
		vacinas.setFont(new Font("", Font.BOLD, 15));
		vacinas.setForeground(Color.BLACK);
		painelVacinas.add(vacinas);
	}
	
	public void botaoCriarVacina() {
		JButton botaoCriarVacina = new JButton("Criar");
		botaoCriarVacina.setActionCommand("criarVacina");
		botaoCriarVacina.addActionListener(this);
		botaoCriarVacina.setBounds(195, 11, 70, 30);
		painelVacinas.add(botaoCriarVacina);
	}
	
	public void listaVacinas() {
		listaVacinas = new JList<String>();
		listaVacinas.setModel(controleVacina.getNomeVacina());
		listaVacinas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaVacinas.setBounds(10, 50, 250, 170);
		painelVacinas.add(listaVacinas);
		listaVacinas.addListSelectionListener(this);
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
		listaRemedios();
	}
	
	public void textoRemedios() {
		JLabel remedios = new JLabel("Remedios");
		remedios.setBounds(10, 13, 150, 20);
		remedios.setFont(new Font("", Font.BOLD, 15));
		remedios.setForeground(Color.BLACK);
		painelRemedios.add(remedios);
	}
	
	
	public void botaoCriarRemedio() {
		JButton botaoCriarRemedio = new JButton("Criar");
		botaoCriarRemedio.setActionCommand("criarRemedio");
		botaoCriarRemedio.addActionListener(this);
		botaoCriarRemedio.setBounds(195, 11, 70, 30);
		painelRemedios.add(botaoCriarRemedio);
		
	}
	
	public void listaRemedios() {
		listaRemedios = new JList<String>();
		listaRemedios.setModel(controleRemedio.getNomeRemedio());
		listaRemedios.setBounds(10, 50, 250, 170);
		painelRemedios.add(listaRemedios);
		listaRemedios.addListSelectionListener(this);
	}
	
	public static void main(String[] args) {
		new Inicio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("voltar" == e.getActionCommand()) {
			 new TelaListaPets(dados);
	         frame.dispose();
		} else if ("editarPet" == e.getActionCommand()) {
			 new TelaEditarPet(dados, i);
	         frame.dispose();
		} else if ("criarVacina" == e.getActionCommand()) {
			 new TelaCriarVacina(dados, i);
	         frame.dispose();
		} else if ("criarRemedio" == e.getActionCommand()) {
			 new TelaCriarRemedio(dados, i);
	         frame.dispose();
		} else if ("verRemedio" == e.getActionCommand()) {
			 new TelaRemedio(dados, i);
	         frame.dispose();
		} else if ("excluirPet" == e.getActionCommand()) {
			 controleAnimal.excluirAnimal(i);
			 new TelaListaPets(dados);
			 JOptionPane.showMessageDialog(null, "Animal excluído com sucesso");
	         frame.dispose();
		} 
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaVacinas) {
			controleVacina.verVacina(listaVacinas.getSelectedValue().toString(), i);
			frame.dispose();
		} else if(e.getValueIsAdjusting() && src == listaRemedios) {
			controleRemedio.verRemedio(listaRemedios.getSelectedValue().toString());
			frame.dispose();
		}
		
	}

}
