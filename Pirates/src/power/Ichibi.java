package power;

import joueur.Pion;
import tools.Affichage;

public class Ichibi extends Power{
	public Ichibi(Affichage affichage) {
		super("Ichibi", Element.Desert,affichage);
	}

	@Override
	public int pv() {
		return 10;
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
		return 0;
	}

	@Override
	public int chakra() {
		return 0;
	}
	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Ichibi lance une série de shurikens imbriqués avec une grande vitesse et précision.\n Les shurikens tournent autour de lui en formant un tourbillon de métal tranchant,\n capable de dévier les attaques ennemies et d'infliger des dommages multiples.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Ichibi invoque une tempête de sable tourbillonnante,\n obscurcissant le ciel et générant des vents violents qui balayent tout sur leur passage,\n infligeant des dégâts continus aux ennemis pris dans la tempête.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Ichibi concentre son chakra dans le sol,\n déclenchant une série de secousses sismiques qui font émerger des pics de sable géants,\n transperçant le terrain et les ennemis avec une force dévastatrice.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Sablonneux Ventilateur            Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Tempête Désertique                Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Éruption Sismique                 Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
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