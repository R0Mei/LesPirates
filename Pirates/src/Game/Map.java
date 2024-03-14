package Game;

import Case.*;

public class Map {
	public int tourJoueur;
	public int isWin;
	private Box[] plateau;
	private int Random;
	public Map() {
		this.tourJoueur = 1;
		this.isWin = 0;
		this.plateau = new Box[30];
	}
	public void initMap() {
		plateau[0] = new StartBox(0);
		for (int i = 1; i<plateau.length-2;i++) {
			 Random = (int)(Math.random() * 100);
			 if(0<=Random && Random>60) {
				 plateau[i] = new NoEffectBox(i);
			 }
			 else if(60<=Random && Random>80) {
				 plateau[i] = new VersusBox(i);
			 }
			 else if(80<=Random && Random>100) {
				 plateau[i] = new BombBox(i);
			 }
		}
		plateau[29] = new WinBox(29);
	}
	public void showMap() {
		for(int i = 0;i<plateau.length;i++) {
			System.out.print("La case est : ");
			Box box = plateau[i];
			if(box instanceof NoEffectBox) {
				System.out.println(" Sans effet");
			}
			else if(box instanceof VersusBox) {
				System.out.println(" Versus");
			}
			else if(box instanceof NoEffectBox) {
				System.out.println(" Bomb");
			}
		}

	}
}
