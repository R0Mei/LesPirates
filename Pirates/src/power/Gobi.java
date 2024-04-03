package power;
import tools.Affichage;
import joueur.Pion;

public class Gobi extends Power{

	public Gobi(Affichage affichage) {
		super("Gobi", Element.Vent,affichage);
	}

	@Override
	public int pv() {
		return 20;
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
		return 1;
	}

	@Override
	public int chakra() {
		return 50;
	}
	@Override
	public void ability1(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Gobi charge avec une vitesse éclair, enveloppé dans un halo électrique,\n percutant les ennemis avec une force foudroyante et les électrocutant au passage.\n");
		otherPlayer.removePV(getDamageAbility1(pion));
		pion.removeChakra(getCostAbility1());
	}

	@Override
	public void ability2(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Gobi génère un orage massif chargé d'éclairs noirs,\n qui s'abat sur la zone et inflige des dégâts dévastateurs à tous ceux qui se trouvent à portée.\n");
		otherPlayer.removePV(getDamageAbility2(pion));
		pion.removeChakra(getCostAbility2());
	}

	@Override
	public void ability3(Pion pion, Pion otherPlayer) {
		affichage.displayMessage("\n"+pion.getName()+" avec l'aide de Gobi concentre une énorme quantité de chakra électrique dans le ciel,\n provoquant une décharge électrique gigantesque qui frappe le sol avec une force apocalyptique,\n détruisant tout sur son passage dans un éclair aveuglant.\n");
		otherPlayer.removePV(getDamageAbility3(pion));
		pion.removeChakra(getCostAbility3());
	}

	@Override
	public String getNameAb1(Pion pion) {
		return "Charge Foudroyante                Coût en chakra : "+getCostAbility1()+"     Degats infligés : "+getDamageAbility1(pion);
	}

	@Override
	public String getNameAb2(Pion pion) {
		return "Orage Infernal                    Coût en chakra : "+getCostAbility2()+"     Degats infligés : "+getDamageAbility2(pion);
	}

	@Override
	public String getNameAb3(Pion pion) {
		return "Apocalypse Foudroyante            Coût en chakra : "+getCostAbility3()+"     Degats infligés : "+getDamageAbility3(pion);
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