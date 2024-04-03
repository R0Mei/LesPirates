package power;

import joueur.Pion;
import tools.Affichage;

public class Sanbi extends Power{

	public Sanbi(Affichage affichage) {
		super("Sanbi", Element.Eau,affichage);
	}

	@Override
	public int pv() {
		return 30;
	}

	@Override
	public int degat() {
		return 0;
	}

	@Override
	public int resistance() {
		return 30;
	}

	@Override
	public int vitesse() {
		return -1;
	}

	@Override
	public int chakra() {
		return 0;
	}
	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Sanbi manipule l'eau pour créer une vague massive qui se précipite sur les ennemis,\n les submergeant et les emportant dans un tourbillon aquatique.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Sanbi invoque un tourbillon d'eau tournoyante qui aspire tout sur son passage,\n piégeant les adversaires dans ses remous et les entraînant vers le fond de l'océan.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Sanbi libère une immense quantité de chakra dans l'eau environnante,\n créant un raz-de-marée dévastateur qui déferle sur la terre ferme,\n submergeant tout sur son passage dans une vague colossale.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Vague Aquatique                   Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Tourbillon Abyssal                Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Tempête Océanique                 Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
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
		return 15+(pion.getDegat()*2);
	}

	@Override
	public int getDamageAbility3(Pion pion) {
		return 40+(pion.getDegat()*3);
	}

}