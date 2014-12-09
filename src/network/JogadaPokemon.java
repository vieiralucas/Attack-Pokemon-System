package network;

import gui.AtorJogador;
import br.ufsc.inf.leobr.cliente.Jogada;

public class JogadaPokemon implements Jogada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3318708796487792585L;
	
	private int indiceInvocamento;
	private int indicePokemonInvocado;
	
	private int indicePokemonAtacado;
	private int indicePokemonAtacou;
	
	private int espacoPokemonEvoluido;
	private int indicePokemonEvoluido;
	
	private int energiaAdversario;
	private int vidaAdversario;
	private int vidaLocal;
	
	private String msg;
	private int acao;
	
	public JogadaPokemon(int indiceInvocamento, int indicePokemonInvocado, int indicePokemonAtacado, int indicePokemonAtacou, int espacoPokemonEvoluido, int indicePokemonEvoluido, int energiaAdversario, int vidaLocal, int vidaAdversario, String msg, int acao) {
		if (acao == 0) { // invocamento
			this.indiceInvocamento = indiceInvocamento;
			this.indicePokemonInvocado = indicePokemonInvocado;			
		} else if (acao == 1) { // ataque
			this.indicePokemonAtacado = indicePokemonAtacado;
			this.indicePokemonAtacou = indicePokemonAtacou;
		} else if (acao == 2) { // evolucao
			this.espacoPokemonEvoluido = espacoPokemonEvoluido;
			this.indicePokemonEvoluido = indicePokemonEvoluido;
		}
		this.energiaAdversario = energiaAdversario;
		this.vidaAdversario = vidaAdversario;
		this.vidaLocal = vidaLocal;
		this.msg = msg;
		this.acao = acao;
	}
	
	public int getIndiceInvocamento() {
		return indiceInvocamento;
	}

	public void setIndiceInvocamento(int indiceInvocamento) {
		this.indiceInvocamento = indiceInvocamento;
	}

	public int getIndicePokemonInvocado() {
		return indicePokemonInvocado;
	}

	public void setIndicePokemonInvocado(int indicePokemonInvocado) {
		this.indicePokemonInvocado = indicePokemonInvocado;
	}

	public int getIndicePokemonAtacado() {
		return indicePokemonAtacado;
	}

	public void setIndicePokemonAtacado(int indicePokemonAtacado) {
		this.indicePokemonAtacado = indicePokemonAtacado;
	}

	public int getIndicePokemonAtacou() {
		return indicePokemonAtacou;
	}

	public void setIndicePokemonAtacou(int indicePokemonAtacou) {
		this.indicePokemonAtacou = indicePokemonAtacou;
	}

	public int getEspacoPokemonEvoluido() {
		return espacoPokemonEvoluido;
	}

	public void setEspacoPokemonEvoluido(int espacoPokemonEvoluido) {
		this.espacoPokemonEvoluido = espacoPokemonEvoluido;
	}
	
	public int getIndicePokemonEvoluido() {
		return indicePokemonEvoluido;
	}

	public void setIndicePokemonEvoluido(int indicePokemonEvoluido) {
		this.indicePokemonEvoluido = indicePokemonEvoluido;
	}

	public int getEnergiaAdversario() {
		return energiaAdversario;
	}

	public void setEnergiaAdversario(int energiaAdversario) {
		this.energiaAdversario = energiaAdversario;
	}

	public int getVidaAdversario() {
		return vidaAdversario;
	}

	public void setVidaAdversario(int vidaAdversario) {
		this.vidaAdversario = vidaAdversario;
	}

	public int getVidaLocal() {
		return vidaLocal;
	}

	public void setVidaLocal(int vidaLocal) {
		this.vidaLocal = vidaLocal;
	}

	public int getAcao() {
		return acao;
	}

	public void setAcao(int acao) {
		this.acao = acao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
