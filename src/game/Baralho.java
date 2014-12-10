package game;


import java.util.Random;

import javax.swing.ImageIcon;

public class Baralho {
	
	private Pokemon ampharos = new Pokemon(23, "Ampharos", null, 7, 9, 5, Pokemon.ELETRICO, new ImageIcon(getClass().getResource("res/ampharos.jpg")));
	private Pokemon flaafy = new Pokemon(22, "Flaafy", ampharos, 5, 7, 3, Pokemon.ELETRICO, new ImageIcon(getClass().getResource("res/flaafy.jpg")));
	private Pokemon mareep = new Pokemon(21, "Mareep", flaafy, 3, 5, 2, Pokemon.ELETRICO, new ImageIcon(getClass().getResource("res/mareep.jpg")));
	private Pokemon typhlosion = new Pokemon(20, "Typhlosion", null, 7, 9, 5, Pokemon.FOGO, new ImageIcon(getClass().getResource("res/typhlosion.jpg")));
	private Pokemon quilava = new Pokemon(19, "Quilava", typhlosion, 5, 7, 3, Pokemon.FOGO, new ImageIcon(getClass().getResource("res/quilava.jpg")));
	private Pokemon cyndaquil = new Pokemon(18, "Cyndaquil", quilava, 3, 5, 2, Pokemon.FOGO, new ImageIcon(getClass().getResource("res/cyndaquil.jpg")));
	private Pokemon poliwrath = new Pokemon(17, "Poliwrath", null, 7, 9, 5, Pokemon.AGUA, new ImageIcon(getClass().getResource("res/poliwrath.jpg")));
	private Pokemon poliwhirl = new Pokemon(16, "Poliwhirl", poliwrath, 5, 7, 3, Pokemon.AGUA, new ImageIcon(getClass().getResource("res/poliwhirl.jpg")));
	private Pokemon poliwag = new Pokemon(15, "Poliwag", poliwhirl, 3, 5, 2, Pokemon.AGUA, new ImageIcon(getClass().getResource("res/poliwag.jpg")));
	private Pokemon vileplume = new Pokemon(14, "Vileplume", null, 7, 9, 5, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/vileplume.jpg")));
	private Pokemon gloom = new Pokemon(13, "Gloom", vileplume, 5, 7, 3, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/gloom.jpg")));
	private Pokemon oddish = new Pokemon(12, "Oddish", gloom, 3, 5, 2, Pokemon.PLANTA, new ImageIcon(getClass().getResource("res/oddish.jpg")));
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
			pichu,
			oddish,
			poliwag,
			cyndaquil,
			mareep
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
			raichu,
			oddish,
			gloom,
			vileplume,
			poliwag,
			poliwhirl,
			poliwrath,
			cyndaquil,
			quilava,
			typhlosion,
			mareep,
			flaafy,
			ampharos
	};
	
	public Pokemon draw() {
		Random r = new Random();
		return drawablePokemons[r.nextInt(drawablePokemons.length)];
	}

	public Pokemon find(int indice) {
		return all[indice];
	}

}
