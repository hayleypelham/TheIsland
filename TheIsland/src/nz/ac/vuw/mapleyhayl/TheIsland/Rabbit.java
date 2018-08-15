package nz.ac.vuw.mapleyhayl.TheIsland;

public class Rabbit extends Mammal {

	public Rabbit(int x, int y) {
		super(x, y);
		this.setSymbol('r');
		this.setSize("small");
		this.setSpecies("Rabbit");
		this.setPerception(5);
		this.setHealth(100);
		this.setHunger(50);
		this.setThirst(10);
		this.setSpeed(3);
	}
}
