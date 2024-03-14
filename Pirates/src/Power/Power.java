package Power;

public abstract class Power {
	protected String name;
	protected Element element;
	
	public Power(String name, Element element) {
		this.name = name;
		this.element = element;
	}
	abstract void pouvoir();
}
