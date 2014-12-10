package game;

public class Espaco {
	protected Pokemon pokemon;

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void setAtacou(boolean atacou) {
		if (pokemon != null) {
			pokemon.setAtacou(atacou);			
		}
	}
}
