package box;

import joueur.Pion;
import tools.Affichage;

public class NoEffectBox extends Box {
	
	public NoEffectBox(int position) {
		super(position,Color.WHITE);
	}
	@Override
	public void action(Pion pion, Affichage affichage) {
	}

	@Override
	public String getName() {

		return "                  ";
	}

}