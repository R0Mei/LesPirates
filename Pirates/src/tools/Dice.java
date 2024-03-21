package tools;
public class Dice {
	private int face;
	
	public Dice(int face) {
		this.face = face;
	}
	public int getDice() {
		return Random.getRandom(face);
	}
}
