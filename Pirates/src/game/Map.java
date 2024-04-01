package game;

import box.*;
import power.ApplyPower;
import tools.Random;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private static final int NUM_CASES = 30;
    private static final int START_POSITION = 1;
    static final int WIN_POSITION = NUM_CASES;

    private static final int BOMB_BOX_PERCENTAGE = 15;
    private static final int CARD_BOX_PERCENTAGE = 20;
    private static final int GET_POWER_PERCENTAGE = 20;
    private static final int NO_EFFECT_BOX_PERCENTAGE = 15;
    private static final int VERSUS_BOX_PERCENTAGE = 20;

    private Jeu jeu;
    private ApplyPower applyPower;
    private List<Box> map;

    public Map(Jeu jeu, ApplyPower applyPower) {
        this.jeu = jeu;
        this.applyPower = applyPower;
    }

    public List<Box> createMap() {
        map = new ArrayList<>();
        Random random = new Random();
        map.add(new StartBox(START_POSITION));
        for (int i = 2; i < WIN_POSITION; i++) {
            Box box = createRandomBox(i, random);
            map.add(box);
        }
        map.add(new WinBox(WIN_POSITION));

        return map;
    }

    private Box createRandomBox(int position, tools.Random random) {
        int randomNumber = random.getRandom(100);

        if (randomNumber < BOMB_BOX_PERCENTAGE) {
            return new BombBox(position, jeu);
        } else if (randomNumber < BOMB_BOX_PERCENTAGE + CARD_BOX_PERCENTAGE) {
            return new CardBox(position, new Deck(), jeu);
        } else if (randomNumber < BOMB_BOX_PERCENTAGE + CARD_BOX_PERCENTAGE + GET_POWER_PERCENTAGE) {
            return new GetPower(position, applyPower, jeu);
        } else if (randomNumber < BOMB_BOX_PERCENTAGE + CARD_BOX_PERCENTAGE + GET_POWER_PERCENTAGE + NO_EFFECT_BOX_PERCENTAGE) {
            return new NoEffectBox(position);
        } else {
            return new VersusBox(position, jeu);
        }
    }
    public int getSize() {
    	return map.size();
    }
}

