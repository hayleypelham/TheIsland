package nz.ac.vuw.mapleyhayl.TheIsland;

public class Bird extends Animal {

	private int flySpeed;
	
	public Bird(int x, int y) {
		super(x, y);
		this.setSymbol('k');
		this.setSize("medium");
		this.setSpecies("Kiwi");
		this.setPerception(3);
		this.setHealth(10);
		this.setHunger(5);
		this.setThirst(0);
		this.setSpeed(1);
	}
	
	public int getFlySpeed() {
		return flySpeed;
	}
	public void setFlySpeed(int flySpeed) {
		this.flySpeed = flySpeed;
	}
}
