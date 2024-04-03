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
    
    public void affichageIntro() {
    	displayMessage("JEU : Course Ninja\n");
    	displayMessage("Course Ninja est un jeu de société pour deux joueurs où chacun incarne un ninja en quête de victoire.\nAffrontez-vous à travers le monde ninja dans une course palpitante pour atteindre la ligne d'arrivée\nou épuiser les points de vie de votre adversaire.\n\n");
    	displayMessage("But du jeu :\n\nSoit le premier joueur à atteindre la ligne d'arrivée,\nsoit réduisez les points de vie de votre adversaire à zéro.\n");
    	displayMessage("Déroulement du tour :\n\nÀ tour de rôle, chaque joueur lance un dé et avance son pion du nombre de cases indiqué par le dé,\nen tenant compte de sa vitesse.\n\n");
    	displayMessage("Cases spéciales :\n");
    	displayMessage("     Parchemin explosif : Si un joueur atterrit sur cette case, il perd 15 points de vie.\n     Pioche : Le joueur doit piocher trois cartes d'événements et en choisir une à appliquer immédiatement.\n     Pouvoir : Le joueur gagne les pouvoirs d'un bijuu, conférant des avantages spéciaux.\n     Combat : Si un joueur atterrit sur cette case, un combat est déclenché. Chaque joueur lance un dé pour déterminer ses dégâts infligés à son adversaire. Un seul round de combat est effectué.\n\n");
    	displayMessage("Statistiques des joueurs :\n");
    	displayMessage("     Points de vie : Chaque joueur commence avec 100 points de vie et perd des points en fonction des événements du jeu.\r\n"
    			+ "     Dégâts : Les dégâts déterminent la force des attaques du joueur.\r\n"
    			+ "     Résistance : Réduit les dégâts reçus.\r\n"
    			+ "     Chakra max : Limite maximale de chakra qu'un joueur peut avoir.\r\n"
    			+ "     Vitesse : Augmente le résultat des dés pour avancer sur le plateau.");
    }
}
