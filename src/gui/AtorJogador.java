package gui;

import game.Arena;
import game.Baralho;
import game.Pokemon;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;

import network.AtorNetGames;
import network.JogadaPokemon;

public class AtorJogador {

	protected String nome;
	protected Pokemon[] mao = new Pokemon[6];
	protected int energia;
	protected int energiaAdv;
	protected int vida;
	protected int vidaAdv;
	protected AtorNetGames netGames;
	protected InterfaceGrafica gui;
	protected Arena arena;
	protected boolean vez;
	protected Pokemon pkmnAtacando;
	protected int pkmnAtacandoPos;
	protected Baralho baralho;

	public AtorJogador(InterfaceGrafica gui) {
		this.gui = gui;
		baralho = new Baralho();
		netGames = new AtorNetGames(this);
		arena = new Arena();
	}

	public Component getFrame() {
		return gui;
	}

	public int iniciarPartida() {
		boolean interromper = false;
		boolean conectado = false;
		boolean emAndamento = arena.isEmAndamento();
		if (emAndamento) {
			interromper = true;
		} else {
			conectado = arena.isConectado();
		}
		if (interromper || ((!emAndamento) && conectado)) {
			netGames.iniciarPartida();
			return 6;
		}
		if (!conectado) {
			return 7;
		}
		return 13;
	}

	public void receberNovaPartida(int posicao) {
		String nomeAdversario = netGames.getNomeAdversario(nome);
		gui.setPlayersName(nome, nomeAdversario);
		gui.showMessage("O jogo vai começar!");
		energia = energiaAdv = 5;
		vida = vidaAdv = 50;
		mao = new Pokemon[6];
		pkmnAtacando = null;
		arena.init();
		
		if (posicao == 1) {
			gui.showMessage("É a sua vez!");
			vez = true;
			mao[0] = baralho.draw();
		} else {
			gui.showMessage("É a vez do jogador adversário!");
			vez = false;
		}
		gui.update();
		arena.setConectado(true);
		arena.setEmAndamento(true);
	}
	
	public int conectar() {
		boolean conectado = arena.isConectado();
		if (!conectado) {
			String servidor = obterDadosConexao();
			boolean exito = netGames.conectar(nome, servidor);
			if (exito) {
				arena.setConectado(true);
				return 0;
			} else {
				return 2;
			}
		} else {
			return 1;
		}
	}

	public String obterDadosConexao() {
		nome = gui.obterNomeJogador();
		String servidor = gui.obterServidor();
		return servidor;
	}

	public int desconectar() {
		boolean conectado = arena.isConectado();
		if (conectado) {
			boolean exito = netGames.desconectar();
			if (exito) {
				arena.setConectado(false);
				return 3;
			} else {
				return 5;
			}
		} else {
			return 4;
		}
	}

	public void receberJogada(Jogada lance) {
		JogadaPokemon jogada = (JogadaPokemon) lance;
		if (jogada.getAcao() == 0) {
			arena.getEspacosRemotos()[jogada.getIndiceInvocamento()].setPokemon(baralho.find(jogada.getIndicePokemonInvocado()));
		}
		if (jogada.getAcao() == 1) {
			if (arena.getEspacosRemotos()[jogada.getIndicePokemonAtacou()].getPokemon().atacar(arena.getEspacosLocal()[jogada.getIndicePokemonAtacado()].getPokemon())) {
				arena.getEspacosLocal()[jogada.getIndicePokemonAtacado()].setPokemon(null);
			} else {
				arena.getEspacosRemotos()[jogada.getIndicePokemonAtacou()].setPokemon(null);
			}
		}
		energiaAdv = jogada.getEnergiaAdversario();
		vida = jogada.getVidaLocal();
		vidaAdv = jogada.getVidaAdversario();
		gui.showMessage(jogada.getMsg());
		gui.drawRemoto(jogada);
		if (jogada.getAcao() == 3) { // passar vez
			vez = true;
			energia = 5;
			drawDeck();
			gui.update();
		}
	}

	public void drawDeck() {
		for(int i = 0; i < mao.length; i++) {
			if(mao[i] == null) {
				mao[i] = baralho.draw();
				return;
			}
		}
	}

	public void maoClick(int i) {
		if (mao[i] != null && vez) {
			if (energia - mao[i].getCusto() >= 0) {
				int confirm = JOptionPane.showConfirmDialog(gui, "Tem certeza que deseja invocar " + mao[i].getNome() + "?");
				if (confirm == JOptionPane.YES_OPTION) {
					int indiceInvocamento = arena.invocaPokemonLocal(mao[i]); 
					if (indiceInvocamento != -1) {
						energia -= mao[i].getCusto();
						enviaInvocamento(indiceInvocamento, mao[i].getIndice(), "O adversário invocou um " + mao[i].getNome());
						mao[i] = null;
						gui.update();
					}
				}
			} else {
				gui.showMessage("Você não possui energia para invocar " + mao[i].getNome());
			}
		} else if(!vez) {
			gui.showMessage("Aguarde a sua vez.");
		}
	}

	public void enviaInvocamento(int indiceInvocamento, int indicePokemonInvocado, String msg) {
		JogadaPokemon jPokemon = new JogadaPokemon(indiceInvocamento, indicePokemonInvocado, 0, 0, 0, 0, energia, vidaAdv, vida, msg, 0);
		netGames.enviarJogada(jPokemon);
	}

	public void evoluir(int i) {
		if (vez) {
			Pokemon pkmn = arena.getEspacosLocal()[i].getPokemon(); 
			if (pkmn != null) {
				if (pkmn.getEvolucao() != null) {
					if (energia - pkmn.getEvolucao().getCusto() >= 0) {
						int confirm = JOptionPane.showConfirmDialog(gui, "Tem certeza que deseja evoluir seu " + pkmn.getNome() + "? Custo: " + pkmn.getEvolucao().getCusto());
						if (confirm == JOptionPane.YES_OPTION) {
							energia -= pkmn.getEvolucao().getCusto();
							arena.getEspacosLocal()[i].setPokemon(pkmn.getEvolucao());
							gui.update();
							gui.showMessage("Seu " + pkmn.getNome() + " está evoluindo para um " + pkmn.getEvolucao().getNome());
							enviaEvolucao(i, pkmn.getIndice(), nome + " evoluiu seu " + pkmn.getNome() + " para um " + pkmn.getEvolucao().getNome());
						}
					} else {
						gui.showMessage("Vocẽ não possui energia para evoluir seu " + pkmn.getNome() + " em um " + pkmn.getEvolucao().getNome());
					}
				} else {
					gui.showMessage("Este pokémon já atingiu sua maior evolução.");
				}
			}			
		} else if(!arena.isEmAndamento()) {
			gui.showMessage("Inicie um jogo.");
		} else {
			gui.showMessage("Aguarde a sua vez.");
		}
	}
	
	public void enviaEvolucao(int espacoPokemonEvoluido, int indicePokemonEvoluido, String msg) {
		JogadaPokemon jPokemon = new JogadaPokemon(0, 0, 0, 0, espacoPokemonEvoluido, indicePokemonEvoluido, energia, vidaAdv, vida, msg, 2);
		netGames.enviarJogada(jPokemon);
	}

	public void passarVez() {
		if(arena.isEmAndamento()) {
			if (vez) {
				int confirm = JOptionPane.showConfirmDialog(gui, "Tem certeza que deseja passar sua vez? Você perderá " + energia + " pontos de vida.");
				if (confirm == JOptionPane.YES_OPTION) {
					vida -= energia;
					gui.update();
					vez = false;
					JogadaPokemon jPokemon = new JogadaPokemon(0, 0, 0, 0, 0, 0, 0, vidaAdv, vida, nome + " passou a vez para você!", 3);
					netGames.enviarJogada(jPokemon);
				}
			} else {
				gui.showMessage("Aguarde a sua vez.");
			}
		} else {
			gui.showMessage("Inicie um jogo.");
		}
	}

	public void ataqueClick(int i) {
		if (arena.isEmAndamento() && arena.getEspacosLocal()[i].getPokemon() != null && vez) {
			if (energia >= 2) {
				pkmnAtacando = arena.getEspacosLocal()[i].getPokemon();
				pkmnAtacandoPos = i;
				if (arena.hasPokemonAdversario()) {
					gui.showMessage("Escolha um pokémon adversário para atacar.");
				} else {
					int confirm = JOptionPane.showConfirmDialog(gui, "Deseja atacar seu adversário diretamente nos pontos de vida? Dano: " + pkmnAtacando.getAtaque() + ".");
					if (confirm == JOptionPane.YES_OPTION) {
						// atacar pontos de vida
					}
				}
			} else {
				gui.showMessage("É necessário ter 2 energias para poder atacar.");
			}
		}
	}

	public void clickPkmnAdv(int i) {
		if (pkmnAtacando != null) {
			Pokemon alvo = arena.getEspacosRemotos()[i].getPokemon();
			int confirm = JOptionPane.showConfirmDialog(gui, "Deseja atacar " + alvo.getNome() + " com seu " + pkmnAtacando.getNome() + "?");
			if (confirm == JOptionPane.YES_OPTION) {
				if (pkmnAtacando.atacar(alvo)) {
					vidaAdv -= alvo.getVida();
					gui.showMessage("Seu pokémon venceu a batalha! Você causou " + alvo.getVida() + " de dano no seu adversário.");
					arena.getEspacosRemotos()[i].setPokemon(null);
					enviaAtaque(i, pkmnAtacandoPos, "Seu adversário atacou seu " + alvo.getNome() + " e o derrotou.");
				} else {
					vida -= pkmnAtacando.getVida();
					gui.showMessage("Seu pokémon perdeu a batalha! Você perdeu " + pkmnAtacando.getVida() + " pontos de vida.");
					arena.getEspacosLocal()[pkmnAtacandoPos].setPokemon(null);
					enviaAtaque(i, pkmnAtacandoPos, "Seu adversário atacou seu " + alvo.getNome() + " e foi derrotado.");
				}
				gui.update();
			}
		}
		
	}

	public void enviaAtaque(int indicePokemonAtacado, int indicePokemonAtacou, String msg) {
		JogadaPokemon jPokemon = new JogadaPokemon(0, 0, indicePokemonAtacado, indicePokemonAtacou, 0, 0, energia, vidaAdv, vida, msg, 1);
		netGames.enviarJogada(jPokemon);
	}

	public Icon getIconMaoLocal(int i) {
		if (mao[i] == null) {
			return null;
		}
		return mao[i].getImage();
	}

	public Icon getIconEspacoLocal(int i) {
		return arena.getIconEspacoLocal(i);
	}

	public Icon getIconEspacoRemoto(int i) {
		return arena.getIconEspacoRemoto(i);
	}

	public int getEnergiaLocal() {
		return energia;
	}

	public int getEnergiaRemota() {
		return energiaAdv;
	}

	public int getVidaLocal() {
		return vida;
	}

	public int getVidaRemota() {
		return vidaAdv;
	}
	
	

}
