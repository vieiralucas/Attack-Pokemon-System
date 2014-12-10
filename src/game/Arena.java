package game;

import javax.swing.Icon;

public class Arena {

	protected Espaco[] espacosLocal = new Espaco[6];
	protected Espaco[] espacosRemotos = new Espaco[6];
	protected boolean conectado;
	protected boolean emAndamento;
	protected Baralho baralho;
	
	public Arena() {
		baralho = new Baralho();
		init();
	}

	public void init() {
		for (int i = 0; i < espacosLocal.length; i++) {
			espacosLocal[i] = new Espaco();
		}
		for (int i = 0; i < espacosRemotos.length; i++) {
			espacosRemotos[i] = new Espaco();
		}				
	}
	
	public boolean isConectado() {
		return conectado;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

	public boolean isEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(boolean emAndamento) {
		this.emAndamento = emAndamento;
	}

	public Espaco[] getEspacosLocal() {
		return espacosLocal;
	}
	
	public Espaco[] getEspacosRemotos() {
		return espacosRemotos;
	}

	public int invocaPokemonLocal(Pokemon pokemon) {
		for (int i = 0; i < espacosLocal.length; i++) {
			if(espacosLocal[i].getPokemon() == null) {
				espacosLocal[i].setPokemon(pokemon);
				return i;
			}
		}
		return -1;
	}

	public boolean hasPokemonAdversario() {
		for (int i = 0; i < espacosRemotos.length; i++) {
			if(espacosRemotos[i].getPokemon() != null) {
				return true;
			}
		}
		return false;
	}

	public Icon getIconEspacoLocal(int i) {
		if (espacosLocal[i].getPokemon() == null) {
			return null;
		}
		return espacosLocal[i].getPokemon().getImage();
	}

	public Icon getIconEspacoRemoto(int i) {
		if (espacosRemotos[i].getPokemon() == null) {
			return null;
		}
		return espacosRemotos[i].getPokemon().getImage();
	}

	public void invocaPokemonRemoto(int posInvocamento, int indicePokemonInvocado) {
		Pokemon invocado = baralho.find(indicePokemonInvocado);
		espacosRemotos[posInvocamento].setPokemon(invocado);
	}

	public int batalhaRemota(int posPokemonAtacado, int posPokemonAtacou) {
		Pokemon atacado = espacosLocal[posPokemonAtacado].getPokemon();
		Pokemon atacou = espacosRemotos[posPokemonAtacou].getPokemon();
		if (atacou.atacar(atacado)) {
			espacosLocal[posPokemonAtacado].setPokemon(null);
			return atacado.getVida();
		} else {
			espacosRemotos[posPokemonAtacou].setPokemon(null);
			return -atacou.getVida();
		}
	}

	public void evoluirLocal(int i) {
		espacosLocal[i].setPokemon(espacosLocal[i].getPokemon().getEvolucao());
	}

	public void evoluirRemoto(int posPokemonEvoluido) {
		espacosRemotos[posPokemonEvoluido].setPokemon(espacosRemotos[posPokemonEvoluido].getPokemon().getEvolucao());
	}
	
	public void setAtacou(int i, boolean atacou) {
		espacosLocal[i].setAtacou(atacou);
	}

	public void resetPokemonsQueAtacaram() {
		for (int i = 0; i < espacosLocal.length; i++) {
			espacosLocal[i].setAtacou(false);
		}
	}
}
