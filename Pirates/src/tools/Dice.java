package tools;
public class Dice {
	private int face;
	private Random random;
	
	public Dice(int face) {
		this.face = face;
		this.random = new Random();
	}
	public int getDice() {
		return random.getRandom(face)+1;
	}
}