package Case;

import Game.*;
import Joueur.Pion;

public class WinBox extends Box{

	public WinBox(int position) {
		super(position,Color.YELLOW);
	}
	
	@Override
	void action(Pion pion) {
	}

}
