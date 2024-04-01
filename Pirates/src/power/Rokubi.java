package power;

import joueur.Pion;
import tools.Affichage;

public class Rokubi extends Power{

	public Rokubi(Affichage affichage) {
		super("Rokubi", Element.Eau,affichage);
	}

	@Override
	public int pv() {
		return 30;
	}

	@Override
	public int degat() {
		return -50;
	}

	@Override
	public int resistance() {
		return 10;
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
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Rokubi crache des bulles acides qui éclatent à l'impact,\n libérant un nuage de vapeurs toxiques qui brûlent et dissolvent tout ce qu'ils touchent.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Rokubi invoque une vague de liquide corrosif qui submerge la zone,\n transformant le sol en un océan de poison dévastateur.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Rokubi libère une pluie de liquide toxique du ciel,\n créant une atmosphère empoisonnée qui corrode tout ce qu'elle touche,\n transformant la terre en un paysage stérile et inhospitalier.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Bulle Corrosive                   Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Marée Toxique                     Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Déluge Miasmatique                Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
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