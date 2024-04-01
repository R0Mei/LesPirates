package box;

import joueur.Pion;
import tools.Affichage;

public abstract class Box {
    protected int position;
    protected Color color;
    
    protected Box(int position,Color color) {
    	this.position = position;
    	this.color = color;
    }
    
	public abstract void action(Pion pion, Affichage affichage);
	
	public abstract String getName();
}