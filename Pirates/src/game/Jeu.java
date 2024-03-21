package game;

import joueur.Pion;

public class Jeu {
	
	private Map map;
	
	private Dice de;
	
	private Affichage affichage;
	
	
	public Jeu() {
		
	}
	
	
	public void tourJoueur(Pion joueur) {
		 int diceNber = de.throwDice();
		 joueur.setPositionFromTheActualOne(diceNber);
		 map.getBoxTab[map.getJoueurTab[map.getTourJoueur].getPosition].action(map.getJoueurTab)
	}
	
}
