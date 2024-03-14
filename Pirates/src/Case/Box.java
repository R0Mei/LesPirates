package Case;

import Joueur.Pion;

public abstract class Box {
    protected int position;
    protected Color color;
    
    protected Box(int position,Color color) {
    	this.position = position;
    	this.color = color;
    }
    
	abstract void action(Pion pion);
}
