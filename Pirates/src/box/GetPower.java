package box;

import tools.*;
import tools.Random;
import joueur.Pion;
import power.*;
import java.util.*;

import game.Jeu;

public class GetPower extends Box {
    private Set<String> powersObtained;
    private Random random;
    private ApplyPower applyPower;
    private OtherPlayer otherPlayerHelper;

    public GetPower(int position,ApplyPower applyPower,Jeu jeu) {
        super(position, Color.PURPLE);
        powersObtained = new HashSet<>();
        this.random = new Random();
        this.applyPower = applyPower;
        this.otherPlayerHelper = new OtherPlayer(jeu);
    }

    private Power creerPouvoir(int pouvoir, Affichage affichage) {
        switch (pouvoir) {
            case 0:
                return new Ichibi(affichage);
            case 1:
                return new Nibi(affichage);
            case 2:
                return new Sanbi(affichage);
            case 3:
                return new Yonbi(affichage);
            case 4:
                return new Gobi(affichage);
            case 5:
                return new Rokubi(affichage);
            case 6:
                return new Chomei(affichage);
            case 7:
                return new Hachibi(affichage);
            case 8:
                return new Kyubi(affichage);
            default:
                return new Chuunins(affichage);
        }
    }

    @Override
    public void action(Pion pion, Affichage affichage) {
        Pion otherPlayer = otherPlayerHelper.getOtherPlayer(pion);
    	if("Chuunins".equals(pion.getPower().getName())) {
	        int pouvoir;
	        do {
	            pouvoir = random.getRandom(10);
	        } while (powersObtained.contains(getPowerName(pouvoir)));
	
	        powersObtained.add(getPowerName(pouvoir));
	        Power pouvoirObtenu = creerPouvoir(pouvoir, affichage);
	        pion.setPower(pouvoirObtenu);
	        affichage.displayMessage("Le joueur " + pion.getName() + " a obtenu le pouvoir " + pouvoirObtenu.getName() + ".");
	        applyPower.applyStatistics(pion, pouvoirObtenu);
    	}
    	else {
    		pion.addPV(10);
    		affichage.displayMessage("Le joueur " + pion.getName() + " a récupéré 10 pv car il possède déjà le pouvoir de "+pion.getPower().getName()+".");
    	}
		affichage.afficherRecapitulatif(pion, otherPlayer, affichage);
    }

    private String getPowerName(int pouvoir) {
        switch (pouvoir) {
            case 0:
                return "Ichibi";
            case 1:
                return "Nibi";
            case 2:
                return "Sanbi";
            case 3:
                return "Yonbi";
            case 4:
                return "Gobi";
            case 5:
                return "Rokubi";
            case 6:
                return "Chomei";
            case 7:
                return "Hachibi";
            case 8:
                return "Kyubi";
            default:
                return "Chuunins";
        }
    }

    @Override
	public String getName() {

		return "POUVOIR           ";
	}
}

