package game;


import java.util.Random;

import javax.swing.ImageIcon;

public class Baralho {
	
	private Pokemon raichu = new Pokemon(11, "Raichu", null, 7, 9, 5, Pokemon.ELETRICO, new ImageIcon(getClass().getResource("res/raichu.jpg")));
	private Pokemon pikachu = new Pokemon(10, "Pikachu", raichu, 5, 7, 3, Pokemon.ELETRICO, new ImageIcon(getClass().getResource("res/pikachu.jpg")));
	private Pokemon pichu = new Pokemon(9, "Pichu", pikachu, 3, 5, 2, Pokemon.ELETRICO, new ImageIcon(getClass().getResource("res/pichu.jpg")));
	private Pokemon blastoise = new Pokemon(8, "Blastoise", null, 7, 9, 5, Pokemon.AGUA, new ImageIcon(getClass().getResource("res/blastoise.jpg")));
	private Pokemon wartortle = new Pokemon(7, "Wartortle", blastoise, 5, 7, 3, Pokemon.AGUA, new ImageIcon(getClass().getResource("res/wartortle.jpg")));
	private Pokemon squirtle = new Pokemon(6, "Squirtle", wartortle, 3, 5, 2, Pokemon.AGUA, new ImageIcon(getClass().getResource("res/squirtle.jpg")));
	private Pokemon charizard = new Pokemon(5, "Charizard", null, 7, 9, 5, Pokemon.FOGO, new ImageIcon(getClass().getResource("res/charizard.jpg")));
	private Pokemon charmeleon = new Pokemon(4, "Charmeleon", charizard, 5, 7, 3, Pokemon.FOGO, new ImageIcon(getClass().getResource("res/charmeleon.jpg")));
	private Pokemon charmander = new Pokemon(3, "Charmander", charmeleon, 3, 5, 2, Pokemon.FOGO, new ImageIcon(getClass().getResource("res/charmander.jpg")));
	private Pokemon venusaur = new Pokemon(2, "Venusaur", null, 7, 9, 5, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/venusaur.jpg")));
	private Pokemon ivysaur = new Pokemon(1, "Ivysaur", venusaur, 5, 7, 3, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/ivysaur.jpg")));
	private Pokemon bulbasaur = new Pokemon(0, "Bulbasaur", ivysaur, 3, 5, 2, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/bulbasaur.jpg")));
	
	private Pokemon[] drawablePokemons = {
			bulbasaur,
			charmander,
			squirtle,
			pichu
	};
	
	private Pokemon[] all = {
			bulbasaur,
			ivysaur,
			venusaur,
			charmander,
			charmeleon,
			charizard,
			squirtle,
			wartortle,
			blastoise,
			pichu,
			pikachu,
			raichu
	};
	
	public Pokemon draw() {
		Random r = new Random();
		return drawablePokemons[r.nextInt(drawablePokemons.length)];
	}

	public Pokemon find(int indice) {
		return all[indice];
	}

}
