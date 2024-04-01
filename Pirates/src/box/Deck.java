package box;

import java.util.ArrayList;
import java.util.List;

import joueur.Pion;
import tools.Random;

public class Deck {
    private List<String> cards;
    private List<String> cardsPile;

    public Deck() {
        this.cards = new ArrayList<>();
        this.cardsPile = new ArrayList<>();
        initializeDeck();
        putBackCards();
    }

    private void initializeDeck() {
        cards.add("+5 pv");
        cards.add("+10 pv");
        cards.add("+15 pv");
        cards.add("+20 chakra");
        cards.add("+40 chakra");
        cards.add("+5 degats");
        cards.add("+5 chakra MAX");
        cards.add("+10 chakra MAX");
        cards.add("+20 chakra MAX");
        cards.add("+1 vitesse");
        cards.add("-5 pv");
        cards.add("-10 pv");
        cards.add("-15 pv");
        cards.add("-20 chakra");
        cards.add("-40 chakra");
        cards.add("-5 degats");
        cards.add("-5 chakra MAX");
        cards.add("-10 chakra MAX");
        cards.add("-20 chakra MAX");
        cards.add("-1 vitesse");
    }

    private void putBackCards() {
        cardsPile.clear();
        cardsPile.addAll(cards);
    }

    public List<String> tirageCards() {
        List<String> drawnCards = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int index = random.getRandom(cardsPile.size());
            drawnCards.add(cardsPile.get(index));
            cardsPile.remove(index);
        }
        putBackCards();
        return drawnCards;
    }

    public void applyCardEffect(String card, Pion pion) {
        switch (card) {
            case "+5 pv":
                pion.addPV(5);
                break;
            case "+10 pv":
                pion.addPV(10);
                break;
            case "+15 pv":
                pion.addPV(15);
                break;
            case "+20 chakra":
                pion.addChakra(20);
                break;
            case "+40 chakra":
                pion.addChakra(40);
                break;
            case "+5 degats":
                pion.addDegat(5);
                break;
            case "+5 chakra MAX":
                pion.setMaxChakra(5);
                break;
            case "+10 chakra MAX":
                pion.setMaxChakra(10);
                break;
            case "+20 chakra MAX":
                pion.setMaxChakra(20);
                break;
            case "+1 vitesse":
                pion.setVitesse(1);
                break;
            case "-5 pv":
                pion.removePV(5);
                break;
            case "-10 pv":
                pion.removePV(10);
                break;
            case "-15 pv":
                pion.removePV(15);
                break;
            case "-20 chakra":
                pion.removeChakra(20);
                break;
            case "-40 chakra":
                pion.removeChakra(40);
                break;
            case "-5 degats":
                pion.addDegat(-5);
                break;
            case "-5 chakra MAX":
                pion.setMaxChakra(-5);
                break;
            case "-10 chakra MAX":
                pion.setMaxChakra(-10);
                break;
            case "-20 chakra MAX":
                pion.setMaxChakra(-20);
                break;
            case "-1 vitesse":
                pion.setVitesse(-1);
                break;
            default:
                System.out.println("Carte non reconnue : " + card);
        }
    }
}
