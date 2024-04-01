package power;

import joueur.Pion;
import tools.Affichage;

public class Nibi extends Power{

	public Nibi(Affichage affichage) {
		super("Nibi", Element.Feu,affichage);
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
		return -10;
	}

	@Override
	public int vitesse() {
		return 1;
	}

	@Override
	public int chakra() {
		return 0;
	}
	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Nibi crache des flammes bleues de ses pattes,\n incinérant tout ce qui se trouve sur leur chemin avec une chaleur intense et persistante.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Nibi libère un rugissement puissant qui crée\n des ondes de choc bleutées capables de briser les défenses ennemies et de déclencher\n des explosions de flammes dans un large rayon.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Nibi concentre son chakra dans l'air,\n créant une sphère d'énergie bleue en forme de croissant de lune qui explose avec une force titanesque,\n détruisant tout sur son passage dans un éclat de lumière éblouissante.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Flamme Féline                     Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Rugissement Astral                Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Nova Lunaire                      Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
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