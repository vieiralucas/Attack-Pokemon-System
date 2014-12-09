package gui;

import game.Espaco;
import game.Pokemon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import network.JogadaPokemon;

@SuppressWarnings("serial")
public class InterfaceGrafica extends JFrame {

	private JMenuBar menuBar;
	private JMenu menuJogo;
	private JMenuItem menuItemConectar;
	private JMenuItem menuItemIniciar;
	private JMenuItem menuItemDesconectar;
	private JMenuItem menuItemSair;

	private JPanel panel;

	private JLabel jogador1Name;
	private JLabel energiaJogador1;
	private JLabel energiaJogador2;
	private JLabel[] maoJogador1 = new JLabel[6];
	private JLabel[] espacosJogador1 = new JLabel[6];

	private JLabel jogador2Name;
	private JLabel vidaJogador1;
	private JLabel vidaJogador2;
	private JLabel[] maoJogador2 = new JLabel[6];
	private JLabel[] espacosJogador2 = new JLabel[6];
	
	private JButton passarVez;
	private JButton[] evoluidores = new JButton[6];
	
	private Icon espacoVazio = new ImageIcon(getClass().getResource("res/espacoVazio.jpg"));
	private Icon maoInimiga = new ImageIcon(getClass().getResource("res/maoInimiga.jpg"));

	private AtorJogador jogo;

	public InterfaceGrafica() {
		createComponents();

		setTitle("APS - Attack Pokémon System");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jogo = new AtorJogador(this);
		setVisible(true);
	}

	private void createComponents() {
		panel = new JPanel();
		panel.setLayout(null);

		// menu bar
		menuBar = new JMenuBar();
		menuJogo = new JMenu("Jogo");
		menuItemConectar = new JMenuItem("Conectar");
		menuItemConectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				conectar();
			}
		});
		menuItemIniciar = new JMenuItem("Iniciar Partida");
		menuItemIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciar();
			}
		});
		menuItemDesconectar = new JMenuItem("Desconectar");
		menuItemDesconectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desconectar();
			}
		});
		menuItemSair = new JMenuItem("Sair");
		menuItemSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desconectar();
				System.exit(0);
			}
		});
		menuJogo.add(menuItemConectar);
		menuJogo.add(menuItemIniciar);
		menuJogo.add(menuItemDesconectar);
		menuJogo.add(menuItemSair);
		menuBar.add(menuJogo);
		setJMenuBar(menuBar);

		// jogador 1
		jogador1Name = new JLabel("Jogador 1");
		jogador1Name.setBounds(10, 420, 75, 50);
		panel.add(jogador1Name);
		energiaJogador1 = new JLabel("ENERGIA: 0/5");
		energiaJogador1.setBounds(600, 530, 100, 50);
		panel.add(energiaJogador1);
		vidaJogador1 = new JLabel("VIDA: 50");
		vidaJogador1.setBounds(700, 420, 100, 50);
		panel.add(vidaJogador1);
		for (int i = 0; i < maoJogador1.length; i++) {
			maoJogador1[i] = new JLabel(espacoVazio);
			maoJogador1[i].setBounds(90 + (i * 101), 440, 101, 100);
			panel.add(maoJogador1[i]);
			espacosJogador1[i] = new JLabel(espacoVazio);
			espacosJogador1[i].setBounds(90 + (i * 101), 300, 101, 100);
			panel.add(espacosJogador1[i]);
			evoluidores[i] = new JButton("Evoluir");
			evoluidores[i].setBounds(90 + (i * 102), 405, 90, 25);
			panel.add(evoluidores[i]);
		}
		maoJogador1[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.maoClick(0); 
			}
		});
		maoJogador1[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.maoClick(1); 
			}
		});
		maoJogador1[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.maoClick(2); 
			}
		});
		maoJogador1[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.maoClick(3); 
			}
		});
		maoJogador1[4].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.maoClick(4); 
			}
		});
		maoJogador1[5].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.maoClick(5); 
			}
		});
		espacosJogador1[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.ataqueClick(0); 
			}
		});
		espacosJogador1[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.ataqueClick(1); 
			}
		});
		espacosJogador1[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.ataqueClick(2); 
			}
		});
		espacosJogador1[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.ataqueClick(3); 
			}
		});
		espacosJogador1[4].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.ataqueClick(4); 
			}
		});
		espacosJogador1[5].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.ataqueClick(5); 
			}
		});
		evoluidores[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.evoluir(0);
			}
		});
		evoluidores[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.evoluir(1);
			}
		});
		evoluidores[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.evoluir(2);
			}
		});
		evoluidores[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.evoluir(3);
			}
		});
		evoluidores[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.evoluir(4);
			}
		});
		evoluidores[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.evoluir(5);
			}
		});
		passarVez = new JButton("Passar");
		passarVez.setBounds(700, 280, 90, 40);
		passarVez.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.passarVez();
			}
		});
		panel.add(passarVez);

		// jogador 2
		jogador2Name = new JLabel("Jogador 2");
		jogador2Name.setBounds(10, 110, 75, 50);
		panel.add(jogador2Name);
		energiaJogador2 = new JLabel("ENERGIA: 0/5");
		energiaJogador2.setBounds(600, 5, 100, 50);
		panel.add(energiaJogador2);
		vidaJogador2 = new JLabel("VIDA: 50");
		vidaJogador2 = new JLabel("VIDA: 50");
		vidaJogador2.setBounds(700, 110, 100, 50);
		panel.add(vidaJogador2);
		for (int i = 0; i < maoJogador1.length; i++) {
			maoJogador2[i] = new JLabel(maoInimiga);
			maoJogador2[i].setBounds(90 + (i * 101), 40, 101, 100);
			panel.add(maoJogador2[i]);
			espacosJogador2[i] = new JLabel(espacoVazio);
			espacosJogador2[i].setBounds(90 + (i * 101), 180, 101, 100);
			panel.add(espacosJogador2[i]);
		}
		espacosJogador2[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.clickPkmnAdv(0); 
			}
		});
		espacosJogador2[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.clickPkmnAdv(1); 
			}
		});
		espacosJogador2[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.clickPkmnAdv(2); 
			}
		});
		espacosJogador2[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.clickPkmnAdv(3); 
			}
		});
		espacosJogador2[4].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.clickPkmnAdv(4); 
			}
		});
		espacosJogador2[5].addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				jogo.clickPkmnAdv(5); 
			}
		});
		add(panel);
	}

	public void conectar() {
		int resultado = jogo.conectar();
		this.notificar(resultado);
	}

	public void desconectar() {
		int resultado = jogo.desconectar();
		this.notificar(resultado);
	}

	public void iniciar() {
		int resultado = jogo.iniciarPartida();
		this.notificar(resultado);
	}

	public void notificar(int codigo) {
		switch (codigo) {
		case 0:
			JOptionPane.showMessageDialog(this, "Conexão efetuada com sucesso");
			break;
		case 1:
			JOptionPane.showMessageDialog(this, "Você já está conectado!");
			break;
		case 2:
			JOptionPane.showMessageDialog(this, "Falha ao conectar-se!");
			break;
		case 3:
			JOptionPane.showMessageDialog(this,
					"Desconexão efetuada com sucesso!");
			break;
		case 4:
		case 7:
			JOptionPane.showMessageDialog(this, "Você não está conectado!");
			break;
		case 5:
			JOptionPane.showMessageDialog(this, "Você já está conectado!");
			break;
		case 6:
			JOptionPane.showMessageDialog(this,
					"Solicitação de inicio efetuada com sucesso!");
			break;
		case 8:
			JOptionPane.showMessageDialog(this, "Não é a sua vez");
			break;
		case 9:
			JOptionPane.showMessageDialog(this, "Partida encerrada");
			break;
		}
	}

	public static void main(String[] args) {
		new InterfaceGrafica();
	}

	public String obterNomeJogador() {
		String nome = ("jogador");
		nome = JOptionPane.showInputDialog(this, ("Insira o nome do jogador"));
		return nome;
	}

	public String obterServidor() {
		String servidor = ("venus.inf.ufsc.br");
		servidor = JOptionPane.showInputDialog(this, ("Insira o endereço do servidor"), servidor);
		return servidor;
	}

	public void setPlayersName(String nome, String nomeAdversario) {
		jogador1Name.setText(nome);
		jogador2Name.setText(nomeAdversario);
	}

	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public void setEnergiaLocal(int energia) {
		energiaJogador1.setText("ENERGIA: " + energia + "/5");
	}
	
	public void setEnergiaRemota(int energia) {
		energiaJogador2.setText("ENERGIA: " + energia + "/5");
	}

	public void update() {
		Icon icon;
		for(int i = 0; i < maoJogador1.length; i++) {
			icon = jogo.getIconMaoLocal(i);
			if (icon != null) {
				maoJogador1[i].setIcon(icon);
			} else {
				maoJogador1[i].setIcon(espacoVazio);
			}
		}
		
		for(int i = 0; i < espacosJogador1.length; i++) {
			icon = jogo.getIconEspacoLocal(i);
			if (icon != null) {
				espacosJogador1[i].setIcon(icon);
			} else {
				espacosJogador1[i].setIcon(espacoVazio);
			}
		}
		
		for(int i = 0; i < espacosJogador2.length; i++) {
			icon = jogo.getIconEspacoRemoto(i);
			if (icon != null) {
				espacosJogador2[i].setIcon(icon);
			} else {
				espacosJogador2[i].setIcon(espacoVazio);
			}
		}

		energiaJogador1.setText("ENERGIA: " + jogo.getEnergiaLocal() + "/5");
		vidaJogador1.setText("VIDA: " + jogo.getVidaLocal());
		
		energiaJogador2.setText("ENERGIA: " + jogo.getEnergiaRemota() + "/5");
		vidaJogador2.setText("VIDA: " + jogo.getVidaRemota());
	}

}
