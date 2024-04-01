package tools;

public class Random {
	private static java.util.Random rand;
	
	public Random() {
		rand = new java.util.Random();
	}
	public int getRandom(int max) {
		return rand.nextInt(max);
	}
}