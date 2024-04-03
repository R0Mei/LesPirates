package box;

import game.Jeu;
import joueur.Pion;
import tools.Affichage;
import tools.OtherPlayer;

public class BombBox extends Box{
	private OtherPlayer otherPlayerHelper;
	
	public BombBox(int position, Jeu jeu) {
		super(position,Color.BLACK);
		this.otherPlayerHelper = new OtherPlayer(jeu);
	}
	@Override
	public void action(Pion pion, Affichage affichage) {
		int subit = 20;
		Pion otherPlayer = otherPlayerHelper.getOtherPlayer(pion);
		pion.removePV(subit);
		affichage.affichageBombBox(pion.getName(),subit);
		affichage.afficherRecapitulatif(pion, otherPlayer, affichage);
	}
	@Override
	public String getName() {
		return "PARCHEMIN EXPLOSIF";
	}

}