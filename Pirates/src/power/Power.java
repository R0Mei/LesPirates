package power;

public abstract class Power {
	protected static String name;
	protected Element element;
	
	protected Power(String name, Element element) {
		this.name = name;
		this.element = element;
	}
	public static String getName() {
		return name;
	}
	public abstract void pouvoir();
}
