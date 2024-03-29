package joueur;

import box.Color;
import power.Power;

public class Pion {
	public int position;
	public Color color;
	public int ptVie;
	public int resistance;
	public Power power;
	
	public Pion(Color color) {
		this.position = 0;
		this.color = color;
		this.ptVie = 100;
		this.resistance = 0;
	}
	public void setPositionFromTheActualOne(int numberOfCase) {
		this.position += numberOfCase;
	}
	public Color getColor() {
		return color;
	}
	public int position() {
		return position;
	}
	public int pv() {
		return ptVie;
	}
	public void removePV(int toSet) {
		if(toSet>resistance) {
			ptVie -= toSet-resistance;
		}
	}
	public void setPower(Power power) {
		this.power = power;
	}
}
