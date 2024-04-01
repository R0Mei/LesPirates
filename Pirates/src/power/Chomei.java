package power;

import joueur.Pion;
import tools.Affichage;

public class Chomei extends Power{

	public Chomei(Affichage affichage) {
		super("Nanabi", Element.Foudre,affichage);
	}

	@Override
	public int pv() {
		return 0;
	}

	@Override
	public int degat() {
		return 0;
	}

	@Override
	public int resistance() {
		return 0;
	}

	@Override
	public int vitesse() {
		return 2;
	}

	@Override
	public int chakra() {
		return -30;
	}
	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Chomei libère un bourdonnement puissant et désagréable qui perturbe les sens des ennemis,\n les rendant désorientés et vulnérables.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Chomei crée un cyclone tourbillonnant composé de notes musicales harmonieuses,\n qui ensorcellent les ennemis et les immobilisent dans une transe hypnotique.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Chomei concentre son chakra dans l'air,\n créant une gigantesque tornade de notes musicales qui déchire tout sur son passage,\n détruisant les structures et désintégrant les adversaires avec une force harmonique dévastatrice.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Bourdonnement Irritant            Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Cyclone Chantant                  Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Tornade Harmonique                Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
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