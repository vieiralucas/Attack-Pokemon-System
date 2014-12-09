package game;


import java.util.Random;

import javax.swing.ImageIcon;

public class Baralho {
	
	private Pokemon venusaur = new Pokemon(2, "Venusaur", null, 7, 9, 5, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/venusaur.jpg")));
	private Pokemon ivysaur = new Pokemon(1, "Ivysaur", venusaur, 5, 7, 3, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/ivysaur.jpg")));
	private Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", ivysaur, 3, 5, 2, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/bulbasaur.jpg")));
	private Pokemon charmander = new Pokemon(3, "Charmander", null, 3, 5, 2, Pokemon.FOGO, new ImageIcon(getClass().getResource("res/charmander.jpg")));
	
	private Pokemon[] drawablePokemons = {
			bulbasaur,
			charmander
	};
	
	private Pokemon[] all = {
			bulbasaur,
			ivysaur,
			venusaur,
			charmander
	};
	
	public Pokemon draw() {
		Random r = new Random();
		return drawablePokemons[r.nextInt(drawablePokemons.length)];
	}

	public Pokemon find(int indice) {
		return all[indice];
	}

}
