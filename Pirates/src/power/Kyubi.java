package power;

import joueur.Pion;
import tools.Affichage;

public class Kyubi extends Power{

	public Kyubi(Affichage affichage) {
		super("Kyubi", Element.Feu,affichage);
	}

	@Override
	public int pv(){
		return 30;
	}

	@Override
	public int degat() {
		return 20;
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
		return 100;
	}
	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Kyubi attaque avec ses griffes enflammées,\n déchirant tout sur son passage avec des flammes brûlantes et destructrices.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Kyubi concentre une immense quantité de chakra dans sa patte,\n créant un Rasengan géant imprégné de puissance démoniaque, capable de déchirer la réalité elle-même.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Kyubi libère un rugissement assourdissant,\n déclenchant une explosion de chakra dévastatrice qui détruit tout dans un vaste rayon,\n laissant un paysage dévasté et enflammé dans son sillage.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Griffes Flamboyantes              Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Rasengan Bestial                  Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Apocalypse Furieuse               Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
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
		return 5+(pion.getDegat());
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