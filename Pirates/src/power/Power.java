package power;

import joueur.Pion;
import tools.Affichage;
public abstract class Power {
	protected String name;
	protected Element element;
	protected Affichage affichage;
	protected Power(String name, Element element,Affichage affichage) {
		this.name = name;
		this.element = element;
		this.affichage = affichage;
	}
	public String getName() {
		return name;
	}
	public void pouvoir(Pion pion) {
		pion.addPV(pv());
		pion.addDegat(degat());
        pion.setResistance(resistance());
        pion.setMaxChakra(chakra());
        pion.addChakra(chakra());
        pion.setVitesse(vitesse());
	}
	public abstract int pv();
	public abstract int degat();
	public abstract int resistance();
	public abstract int vitesse();
	public abstract int chakra();
	public abstract void ability1(Pion pion, Pion otherPlayer);
	public abstract void ability2(Pion pion, Pion otherPlayer);
	public abstract void ability3(Pion pion, Pion otherPlayer);
	public abstract String getNameAb1(Pion pion);
	public abstract String getNameAb2(Pion pion);
	public abstract String getNameAb3(Pion pion);
	public abstract int getCostAbility1();
	public abstract int getCostAbility2();
	public abstract int getCostAbility3();
	public abstract int getDamageAbility1(Pion pion);
	public abstract int getDamageAbility2(Pion pion);
	public abstract int getDamageAbility3(Pion pion);
}