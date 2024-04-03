package power;

import joueur.Pion;
import tools.Affichage;

public class Chuunins extends Power{
	public Chuunins(Affichage affichage) {
		super("Chuunins", Element.Neutral,affichage);

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
		return 0;
	}

	@Override
	public int chakra() {
		return 0;
	}

	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" lance une série de shurikens imbriqués avec une grande vitesse et précision.\n Les shurikens tournent autour de lui en formant un tourbillon de métal tranchant,\n capable de dévier les attaques ennemies et d'infliger des dommages multiples.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" canalise son chakra dans ses poings, puis charge rapidement vers l'ennemi avec une vitesse éclair.\n Il délivre un puissant coup de poing chargé de chakra, créant une déflagration électrique au moment de l'impact,\n électrocutant l'ennemi et le projetant violemment en arrière.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" concentre son chakra dans son corps, puis saute en l'air en effectuant une série de mudras rapides.\n Il crée ensuite une pluie de lames de chakra rouge écarlate qui tombent du ciel,\n déchirant tout sur leur passage avec une vitesse et une précision incroyables, créant une zone d'attaque mortelle autour de lui.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Shuriken Tourbillon               Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Frappe du Tigre Éclair            Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Tempête de lames écarlates        Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
	}

	@Override
	public int getCostAbility1() {
		return 10;
	}

	@Override
	public int getCostAbility2() {
		return 20;
	}

	@Override
	public int getCostAbility3() {
		return 30;
	}

	@Override
	public int getDamageAbility1(Pion pion) {
		return 5+pion.getDegat();
	}

	@Override
	public int getDamageAbility2(Pion pion) {
		return 10+(pion.getDegat()*2);
	}

	@Override
	public int getDamageAbility3(Pion pion) {
		return 15+(pion.getDegat()*3);
	}

}
