package joueur;

import java.util.List;

import box.Box;
import box.Color;
import power.Chuunins;
import power.Power;
import tools.Affichage;

public class Pion {
    private Color color;
    private String name;
    private Power power;
    private int position;
    private int ptVie;
    private int degat;
    private int resistance;
    private int chakra;
    private int maxChakra;
    private int vitesse;
    private List<Box> map;

    public Pion(Color color, String name, Affichage affichage, List<Box> map) {
        this.color = color;
        this.name = name;
        this.power = new Chuunins(affichage);
        this.position = 0;
        this.ptVie = 100;
        this.degat = 5;
        this.resistance = 0;
        this.maxChakra = 100;
        this.chakra = this.maxChakra;
        this.vitesse = 0;
        this.map = map;
    }
	public void setPosition(int numberOfCase) {
        int remainingCases = map.size() - 1 - this.position;
        if (numberOfCase+vitesse > remainingCases) {
        	numberOfCase = numberOfCase+vitesse - remainingCases;
            this.position = map.size() - 1 - numberOfCase;
        } else {
        	if(numberOfCase + vitesse<=0) {
        		this.position += 1;
        	}else {
                this.position += numberOfCase + vitesse;
        	}
        }
    }
	
	public void setPower(Power power) {
		this.power = power;
	}
	
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	public void setMaxChakra(int maxChakra) {
		this.maxChakra += maxChakra;
		if(this.maxChakra == this.chakra) {
			removeChakra(maxChakra);
		}else if(this.maxChakra-maxChakra < this.chakra){
			removeChakra(this.chakra-(this.maxChakra-maxChakra));
		}
	}
	
	public void addPV(int ptVie) {
		this.ptVie += ptVie;
	}
	public void removePV(int toSet) {
		double result = toSet * (1 - (double) resistance / 100);
	    this.ptVie -= (int) Math.round(result);
	}
	
	public void addDegat(int degat) {
	    double result = this.degat * (1 + (double) degat / 100);
	    this.degat = (int) Math.round(result);
	}
	public void removeDegat(int degat) {
		this.degat-=degat;
	}

	
	public void setResistance(int resistance) {
		this.resistance += resistance;
	}
	
	public void addChakra(int chakra) {
		if(this.chakra+chakra > this.maxChakra) {
			this.chakra = this.maxChakra;
		}
		else {
			this.chakra += chakra;
		}
	}
	public void removeChakra(int cost) {
	    if (this.chakra - cost < 0) {
	        this.chakra = 0;
	    } else {
	        this.chakra -= cost;
	    }
	}
	
	public Color getColor() {
		return color;
	}
	public String getName() {
		return name;
	}
	public Power getPower() {
		return power;
	}
	public int getPosition() {
		return position;
	}
	public int getPV() {
		return ptVie;
	}
	public int getDegat() {
		return degat;
	}
	public int getResistance() {
		return resistance;
	}
	public int getChakra() {
		return chakra;
	}
	public int getVitesse() {
		return vitesse;
	}
	public int getChakraMAX() {
		return maxChakra;
	}

}