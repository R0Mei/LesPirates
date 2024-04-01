package power;

import joueur.Pion;

public class ApplyPower {
	public ApplyPower() {
	}
    public void applyStatistics(Pion pion, Power power) {
        pion.addPV(power.pv());
        pion.addDegat(power.degat());
        pion.setResistance(power.resistance());
        pion.setMaxChakra(power.chakra());
        pion.addChakra(power.chakra());
        pion.setVitesse(power.vitesse());
    }
}