package game;

import power.ApplyPower;

public class Main {
	public static void main(String[] args) {
		ApplyPower apply = new ApplyPower();
        Jeu jeu = new Jeu(apply);
        jeu.startGame();
    }
}
