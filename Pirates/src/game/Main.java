package game;

import power.ApplyPower;

public class Main {
	public static void main(String[] args) {
    	ApplyPower applyPower = new ApplyPower();
        Jeu jeu = new Jeu(applyPower);
        jeu.startGame();
    }
}
