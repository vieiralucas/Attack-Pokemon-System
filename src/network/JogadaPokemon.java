package network;

import br.ufsc.inf.leobr.cliente.Jogada;

public class JogadaPokemon implements Jogada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3318708796487792585L;
	
	public static final int INVOCAMENTO = 0, ATAQUE = 1, EVOLUCAO = 2, PASSARVEZ = 3, ATAQUEVIDA = 4, FIM = 5; 
	
	private int posInvocamento;
	private int indicePokemonInvocado;
	
	private int posPokemonAtacado;
	private int posPokemonAtacou;
	
	private int posPokemonEvoluido;
	private int indicePokemonEvoluido;
	
	private int energiaAdversario;
	private int vidaAdversario;
	private int vidaLocal;
	
	private String msg;
	private int acao;
	
	public JogadaPokemon(int energiaAdversario, int vidaLocal, int vidaAdversario, String msg) {
		this.posInvocamento = 0;
		this.indicePokemonInvocado = 0;
		this.posPokemonAtacado = 0;
		this.posPokemonAtacou = 0;
		this.posPokemonEvoluido = 0;
		this.indicePokemonEvoluido = 0;
		this.energiaAdversario = energiaAdversario;
		this.vidaAdversario = vidaAdversario;
		this.vidaLocal = vidaLocal;
		this.msg = msg;
	}
	
	public void configuraInvocamento(int posInvocamento, int indicePokemonInvocado) {
		this.posInvocamento = posInvocamento;
		this.indicePokemonInvocado = indicePokemonInvocado;
		acao = JogadaPokemon.INVOCAMENTO;
	}

	public void configuraEvolucao(int posPokemonEvoluido, int indicePokemonEvoluido) {
		this.posPokemonEvoluido = posPokemonEvoluido;
		this.indicePokemonEvoluido = indicePokemonEvoluido;
		acao = JogadaPokemon.EVOLUCAO;
	}

	public void configuraPassarVez() {
		acao = JogadaPokemon.PASSARVEZ;
	}

	public void configuraAtaque(int posPokemonAtacado, int posPokemonAtacou) {
		this.posPokemonAtacado = posPokemonAtacado;
		this.posPokemonAtacou = posPokemonAtacou;
		acao = JogadaPokemon.ATAQUE;
	}

	public int getPosInvocamento() {
		return posInvocamento;
	}

	public void setPosInvocamento(int posInvocamento) {
		this.posInvocamento = posInvocamento;
	}

	public int getIndicePokemonInvocado() {
		return indicePokemonInvocado;
	}

	public void setIndicePokemonInvocado(int indicePokemonInvocado) {
		this.indicePokemonInvocado = indicePokemonInvocado;
	}

	public int getPosPokemonAtacado() {
		return posPokemonAtacado;
	}

	public void setPosPokemonAtacado(int posPokemonAtacado) {
		this.posPokemonAtacado = posPokemonAtacado;
	}

	public int getPosPokemonAtacou() {
		return posPokemonAtacou;
	}

	public void setPosPokemonAtacou(int posPokemonAtacou) {
		this.posPokemonAtacou = posPokemonAtacou;
	}

	public int getPosPokemonEvoluido() {
		return posPokemonEvoluido;
	}

	public void setPosPokemonEvoluido(int posPokemonEvoluido) {
		this.posPokemonEvoluido = posPokemonEvoluido;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getAcao() {
		return acao;
	}

	public void setAcao(int acao) {
		this.acao = acao;
	}

}
