package power;

import joueur.Pion;
import tools.Affichage;

public class Hachibi extends Power {

	public Hachibi(Affichage affichage) {
		super("Hachibi", Element.Foudre,affichage);
	}

	@Override
	public int pv() {
		return 10;
	}

	@Override
	public int degat() {
		return 100;
	}

	@Override
	public int resistance() {
		return 0;
	}

	@Override
	public int vitesse() {
		return 0;
	}

	@Override
	public int chakra() {
		return 20;
	}
	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Hachibi utilise ses tentacules pour frapper les ennemis avec une force brute,\n les repoussant violemment et les blessant avec des coups puissants.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Hachibi crée un vortex tourbillonnant avec ses tentacules,\n aspirant les ennemis dans un tourbillon chaotique où ils sont violemment secoués et désorientés.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Hachibi libère tous ses tentacules dans une explosion de mouvement,\n frappant tout ce qui se trouve à portée dans une furie tourbillonnante,\n déchirant et écrasant tout sur son passage.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Frappe Tentaculaire               Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Vortex Dévastateur                Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Furie Tentaculaire                Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
	}

	@Override
	public int getCostAbility1() {
		return 15;
	}

	@Override
	public int getCostAbility2() {
		return 30;
	}

	@Override
	public int getCostAbility3() {
		return 60;
	}

	@Override
	public int getDamageAbility1(Pion pion) {
		return 5+pion.getDegat();
	}

	@Override
	public int getDamageAbility2(Pion pion) {
		return 15+pion.getDegat();
	}

	@Override
	public int getDamageAbility3(Pion pion) {
		return 40+pion.getDegat();
	}

}
