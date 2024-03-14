package Case;

import Joueur.Pion;

public class NoEffectBox extends Box {
	
	public NoEffectBox(int position) {
		super(position,Color.WHITE);
	}
	@Override
	void action(Pion pion) {
	}

}
