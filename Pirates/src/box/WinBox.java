package box;

import game.*;
import joueur.Pion;
import tools.Affichage;

public class WinBox extends Box{

	public WinBox(int position) {
		super(position,Color.YELLOW);
	}

	@Override
	public void action(Pion pion, Affichage affichage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {

		return "";
	}
	
}