package box;

import joueur.Pion;
import tools.Affichage;

public class StartBox extends Box{

	public StartBox(int position) {
		super(position,Color.GREEN);
	}

	@Override
	public void action(Pion pion, Affichage affichage) {		
	}

	@Override
	public String getName() {

		return "";
	}
	

}