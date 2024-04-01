package game;

import box.*;
import joueur.Pion;
import power.ApplyPower;
import tools.*;

import java.util.List;

public class Jeu {

    private List<Box> map;
    private Pion player1;
    private Pion player2;
    private Affichage affichage;
    private Entrer entrer;
    private ApplyPower applyPower;

    public Jeu(ApplyPower applyPower) {
        this.applyPower = applyPower;
        affichage = new Affichage();
        entrer = new Entrer();
        initializePlayers();
        Map mapGenerator = new Map(this, applyPower);
        map = mapGenerator.createMap();
    }

    private void initializePlayers() {
        String playerName1 = entrer.askForName(1);
        String playerName2 = entrer.askForName(2);
        map = new Map(this, applyPower).createMap();
        player1 = new Pion(Color.BLUE, playerName1, affichage,map);
        player2 = new Pion(Color.RED, playerName2, affichage,map);
    }

    public void startGame() {
        while (!isGameOver()) {
            executePlayerTurn(map, player1, player2 ,affichage);
            if (isGameOver()) break;
            executePlayerTurn(map, player2, player1 ,affichage);
        }
        String name;
        if(player1.getPosition() == Map.WIN_POSITION-1 || player2.getPV() <= 0) {
        	name = player1.getName();
        }else {
        	name = player2.getName();
        }
        affichage.displayMessage("Le jeu est terminé ! "+name+" est le grand gagnant !");
    }

    private void executePlayerTurn(List<Box> map, Pion player1, Pion player2 ,Affichage affichage) {
        affichage.displayGameState(map, player1, player2);
        affichage.displayMessage(player1.getName() + ", appuyez sur Entrée pour jouer votre tour.");
        entrer.waitForEnter();
        int diceResult = rollDice();
        affichage.displayMessage("\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+player1.getName() + " a lancé les dés et a obtenu un " + diceResult + ".");
        player1.setPosition(diceResult);
        affichage.displayMessage("Il est sur la case n°"+player1.getPosition()+".\n");
        Box currentBox = map.get(player1.getPosition());
        currentBox.action(player1, affichage);
        affichage.displayMessage("Appuyez sur Entrée pour continuer ....");
        entrer.waitForEnter();

    }

    private int rollDice() {
        Dice dice = new Dice(6);
        return dice.getDice();
    }

    private boolean isGameOver() {
        return player1.getPosition() == Map.WIN_POSITION-1 || player2.getPosition() == Map.WIN_POSITION-1 || player1.getPV() <= 0 || player2.getPV() <= 0;
    }


    public Pion getPlayer1() {
        return player1;
    }

    public Pion getPlayer2() {
        return player2;
    }

    public static void main(String[] args) {
    	ApplyPower applyPower = new ApplyPower();
        Jeu jeu = new Jeu(applyPower);
        jeu.startGame();
    }
}
