package tools;

import java.util.List;
import joueur.Pion;
import box.*;

public class Affichage implements IAffichage {
    public Affichage() {
        // Ce constructeur est laissé vide car la classe ne possède aucun attribut à initialiser.
    }

    @Override
    public void affichageGetPower(String name) {
        System.out.println("Bienvenue Chuunins, tu es ici pour recevoir un pouvoir tres special !.\nTu as l'honneur de te lier avec "+name+".");
    }

    @Override
    public void affichageBombBox(String name, int subit) {
        System.out.println("Ho non "+name+" tu viens de marcher sur un parchemin explosif ! Tu perds alors "+subit+" pv.\n");
    }

    @Override
    public void displayMessage(String text) {
        System.out.println(text);
    }

    @Override
    public void afficherRecapitulatif(Pion pion1, Pion pion2, Affichage affichage) {
        affichage.displayMessage("\nRécapitulatif des statistiques :");
        affichage.displayMessage("Joueur " + pion1.getName() + " (" + pion1.getColor() + ")");
        affichage.displayMessage("  PV : " + pion1.getPV());
        affichage.displayMessage("  Dégâts : " + pion1.getDegat());
        affichage.displayMessage("  Résistance : " + pion1.getResistance());
        affichage.displayMessage("  Chakra : " + pion1.getChakra()+"   ("+pion1.getChakraMAX()+" MAX)");
        affichage.displayMessage("  Vitesse : " + pion1.getVitesse());
        affichage.displayMessage("---------------------------------");
        affichage.displayMessage("Joueur " + pion2.getName() + " (" + pion2.getColor() + ")");
        affichage.displayMessage("  PV : " + pion2.getPV());
        affichage.displayMessage("  Dégâts : " + pion2.getDegat());
        affichage.displayMessage("  Résistance : " + pion2.getResistance());
        affichage.displayMessage("  Chakra : " + pion2.getChakra()+"   ("+pion2.getChakraMAX()+" MAX)");
        affichage.displayMessage("  Vitesse : " + pion2.getVitesse()+"\n");
    }

    @Override
    public void displayGameState(List<Box> map, Pion player1, Pion player2) {
        displayMessage("\n\n\n\n\n\n\n\n\n\n\nÉtat du jeu :");
        for (int i = 0; i < map.size(); i++) {
            Box currentBox = map.get(i);
            String boxInfo = "";
            if (currentBox instanceof StartBox) {
                boxInfo = i+".DEPART                 ";
            } else if (currentBox instanceof WinBox) {
                boxInfo = i+".ARRIVEE                ";
            } else {
                boxInfo = i+".Case " + currentBox.getName();
            }
            if (player1.getPosition() == i && player2.getPosition() == i) {
                boxInfo += " : "+player1.getName()+" et "+player2.getName();
            } else if (player1.getPosition() == i) {
                boxInfo += " : "+player1.getName();
            } else if (player2.getPosition() == i) {
                boxInfo += " : "+player2.getName();
            }
            displayMessage(boxInfo);
        }
    }
}
