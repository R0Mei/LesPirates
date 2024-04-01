package box;

import joueur.Pion;
import tools.Affichage;
import tools.Entrer;
import tools.OtherPlayer;

import java.util.List;

import game.Jeu;

public class CardBox extends Box {
    private Deck deck;
    private Affichage affichage;
    private Entrer entrer123;
    private OtherPlayer otherPlayerHelper;


    public CardBox(int position, Deck deck,Jeu jeu) {
        super(position, Color.YELLOW);
        this.deck = deck;
        this.affichage = new Affichage();
        this.entrer123 = new Entrer();
        this.otherPlayerHelper = new OtherPlayer(jeu);
    }

    @Override
    public void action(Pion pion, Affichage affichage) {
        affichage.displayMessage("Le pion est sur une case carte !\n");
        
        List<String> drawnCards = deck.tirageCards();

        affichage.displayMessage("Cartes tirées : ");
        for (int i = 0; i < drawnCards.size(); i++) {
            affichage.displayMessage((i + 1) + ". " + drawnCards.get(i));
        }

        int choice = entrer123.entrer123();
        if (choice >= 1 && choice <= 3) {
            String selectedCard = drawnCards.get(choice - 1);
            affichage.displayMessage("Carte choisie : " + selectedCard);
            deck.applyCardEffect(selectedCard, pion);
        } else {
            affichage.displayMessage("Choix invalide.");
        }
        Pion otherPlayer = otherPlayerHelper.getOtherPlayer(pion);
        affichage.afficherRecapitulatif(pion,otherPlayer,affichage);
    }

	@Override
	public String getName() {

		return "PIOCHE            ";
	}

}
