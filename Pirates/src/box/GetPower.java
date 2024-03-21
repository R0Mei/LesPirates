package box;

import tools.*;
import joueur.Pion;
import power.*;

public class GetPower extends Box{
	private int rand;
	private int alreadyUse;
	public GetPower(int position, Color color) {
		super(position, color);
		alreadyUse = 10;
		
	}
	
	private Power creerPouvoir(int pouvoir) {
		switch(pouvoir) {
		case 0:
			return new Ichibi();
		}
	}

	@Override
	void action(Pion pion,Affichage affichage) {
		do {
			rand = Random.getRandom(9);
		}while(rand == alreadyUse);
		 Power pouvoir = creerPouvoir(rand);
		 pion.setPower(pouvoir);
		 affichage.affichageGetPower(pouvoir.getName());
		
		
		
		
		switch(rand) {
		case 0 :
			Affichage.affichageGetPower(Ichibi.getName());
		}
		
		
	}

}
