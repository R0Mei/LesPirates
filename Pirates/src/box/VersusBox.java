package box;

import joueur.Pion;
import tools.Affichage;
import tools.Entrer;
import tools.OtherPlayer;
import game.Jeu;

import java.util.Scanner;

public class VersusBox extends Box {

    private OtherPlayer otherPlayerHelper;

    public VersusBox(int position, Jeu jeu) {
        super(position, Color.ORANGE);
        this.otherPlayerHelper = new OtherPlayer(jeu);
    }

    @Override
    public void action(Pion pion, Affichage affichage) {

    	Pion otherPlayer = otherPlayerHelper.getOtherPlayer(pion);
        affichage.displayMessage("Un combat se déclenche !\n");
        affichage.afficherRecapitulatif(pion, otherPlayer, affichage);
        combat(pion,otherPlayer,affichage);
        if (otherPlayer.getPV() <= 0) {
            affichage.displayMessage("Le joueur " + pion.getName() + " remporte le combat !");
        } else {
        	combat(otherPlayer,pion,affichage);
        }
        affichage.afficherRecapitulatif(pion, otherPlayer, affichage);
    }
    
    public void combat(Pion pion,Pion otherPlayer, Affichage affichage) {
    	Scanner scanner = new Scanner(System.in);
        Entrer entrer = new Entrer();
        String notEnought = "Pas assez de chakra pour utiliser cette capacité !";
        affichage.displayMessage("Tour du joueur " + pion.getColor() + " (" + pion.getName() + ")");
        int choice;
        while (true) {
            	
            affichage.displayMessage("1. Attaquer               Coût en chakra : 0     Degats infligés : "+pion.getDegat());
            affichage.displayMessage("2. "+pion.getPower().getNameAb1(pion));
            affichage.displayMessage("3. "+pion.getPower().getNameAb2(pion));
            affichage.displayMessage("4. "+pion.getPower().getNameAb3(pion));

            choice = entrer.entrer1234();
            int damageDealt;
            switch (choice) {
                case 1:
                    damageDealt = pion.getDegat();
                    affichage.displayMessage(pion.getName() + " attaque et inflige " + damageDealt + " dégâts !");
                    otherPlayer.removePV(damageDealt);
                    break;
                case 2:
                    if (pion.getChakra() >= pion.getPower().getCostAbility1()) {
                        pion.getPower().ability1(pion, otherPlayer);
                    } else {
                        affichage.displayMessage(notEnought);
                        continue;
                    }
                    break;
                case 3:
                    if (pion.getChakra() >= pion.getPower().getCostAbility2()) {
                        pion.getPower().ability2(pion, otherPlayer);
                    } else {
                        affichage.displayMessage(notEnought);
                        continue;
                    }
                    break;
                case 4:
                    if (pion.getChakra() >= pion.getPower().getCostAbility3()) {
                        pion.getPower().ability3(pion, otherPlayer);
                    } else {
                        affichage.displayMessage(notEnought);
                        continue;
                    }
                    break;
                default:
                    affichage.displayMessage("Choix invalide. Veuillez entrer un nombre entre 1 et 4.");
                    continue;
            }
            break;
        }
    }
    @Override
	public String getName() {

		return "COMBAT            ";
	}
}
