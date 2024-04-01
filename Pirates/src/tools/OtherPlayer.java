package tools;

import joueur.Pion;
import game.Jeu;

public class OtherPlayer {
    private Jeu jeu;

    public OtherPlayer(Jeu jeu) {
        this.jeu = jeu;
    }

    public Pion getOtherPlayer(Pion currentPlayer) {
        if (currentPlayer.equals(jeu.getPlayer1())) {
            return jeu.getPlayer2();
        } else {
            return jeu.getPlayer1();
        }
    }
}
