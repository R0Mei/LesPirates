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
		case 1:
			return new Nibi();
		case 2:
			return new Sanbi();
		case 3:
			return new Yonbi();
		case 4:
			return new Gobi();
		case 5:
			return new Rokubi();
		case 6:
			return new Nanabi();
		case 7:
			return new Hachibi();
		case 8:
			return new Kyubi();
		}
		return null;
	}

	@Override
	void action(Pion pion, Affichage affichage) {
		do {
			rand = Random.getRandom(9);
		}while(rand == alreadyUse);
		 Power pouvoir = creerPouvoir(rand);
		 pion.setPower(pouvoir);
		 Affichage.affichageGetPower(pouvoir.getName());
		 
		
		
	}

	@Override
	void action(Pion pion) {
		// TODO Auto-generated method stub
		
	}

}
