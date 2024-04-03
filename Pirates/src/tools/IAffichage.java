package tools;

import java.util.List;
import joueur.Pion;
import box.*;

public interface IAffichage {
    void affichageGetPower(String name);
    void affichageBombBox(String name, int subit);
    void displayMessage(String text);
    void afficherRecapitulatif(Pion pion1, Pion pion2, Affichage affichage);
    void displayGameState(List<Box> map, Pion player1, Pion player2);
    void affichageIntro();
}
