package power;

import joueur.Pion;
import tools.Affichage;

public class Yonbi extends Power{

	public Yonbi(Affichage affichage) {
		super("Yonbi", Element.Terre,affichage);
	}

	@Override
	public int pv() {
		return 0;
	}

	@Override
	public int degat() {
		return 150;
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
		return 0;
	}
	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Yonbi frappe le sol de ses pattes massives,\n déclenchant une onde de choc sismique qui fissure le sol et projette les ennemis dans les airs.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Yonbi concentre son chakra dans le sol,\n provoquant l'éruption soudaine d'un volcan géant qui crache des flammes et de la lave en fusion,\n engloutissant tout sur son passage.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Yonbi libère une quantité massive de chakra,\n déclenchant une explosion titanesque qui transforme la zone environnante en un paysage lunaire,\n ravageant tout sur son passage avec une force cataclysmique.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Frappe Sismique                   Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Explosion Volcanique              Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Éruption Géante                   Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
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