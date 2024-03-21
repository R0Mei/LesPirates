package box;

import joueur.Pion;

public class BombBox extends Box{
	
	public BombBox(int position) {
		super(position,Color.ORANGE);
	}
	@Override
	void action(Pion pion) {
		pion.removePV(10);
	}
}
