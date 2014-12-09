package game;

import javax.swing.Icon;

public class Pokemon {
	
	public static final int FOGO = 0, PLANTA = 1, AGUA = 2, ELETRICO = 3;
	
	protected int indice;
	protected String nome;
	protected Pokemon evolucao;
	protected int ataque;
	protected int vida;
	protected int custo;
	protected int tipo;
	protected Icon image;
	
	public Pokemon(int indice, String nome, Pokemon evolucao, int ataque, int vida, int custo, int tipo, Icon image) {
		this.indice = indice;
		this.nome = nome;
		this.evolucao = evolucao;
		this.ataque = ataque;
		this.vida = vida;
		this.custo = custo;
		this.tipo = tipo;
		this.image = image;
	}
	
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice= indice;
	}		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Pokemon getEvolucao() {
		return evolucao;
	}
	public void setEvolucao(Pokemon evolucao) {
		this.evolucao = evolucao;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo= tipo;
	}
	public int getCusto() {
		return custo;
	}
	public void setCusto(int custo) {
		this.custo = custo;
	}
	public Icon getImage() {
		return image;
	}
	public void setImage(Icon image) {
		this.image = image;
	}
	
	// retorna true se o pokemon alvo perder
	public boolean atacar(Pokemon alvo) {
		if (tipo == FOGO) {
			switch (alvo.getTipo()) {
			case PLANTA:
				return ataque * 2 > alvo.getAtaque();
			case AGUA:
				return ataque > alvo.getAtaque() * 2;
			case ELETRICO:
				return ataque > alvo.getAtaque();
			default:
				return ataque > alvo.getAtaque();
			}
		} else if(tipo == PLANTA) {
			switch (alvo.getTipo()) {
			case PLANTA:
				return ataque > alvo.getAtaque();
			case AGUA:
				return ataque > alvo.getAtaque();
			case ELETRICO:
				return ataque * 2 > alvo.getAtaque();
			default:
				return ataque > alvo.getAtaque() * 2;
			}
		} else if(tipo == ELETRICO) {
			switch (alvo.getTipo()) {
			case PLANTA:
				return ataque > alvo.getAtaque() * 2;
			case AGUA:
				return ataque * 2 > alvo.getAtaque();
			case ELETRICO:
				return ataque > alvo.getAtaque();
			default:
				return ataque > alvo.getAtaque() * 2;
			}
		} else {
			switch (alvo.getTipo()) {
			case PLANTA:
				return ataque > alvo.getAtaque();
			case AGUA:
				return ataque > alvo.getAtaque();
			case ELETRICO:
				return ataque > alvo.getAtaque() * 2;
			default:
				return ataque * 2 > alvo.getAtaque();
			}
		}
	}
	
	
}
