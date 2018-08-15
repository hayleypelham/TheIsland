package nz.ac.vuw.mapleyhayl.TheIsland;

public class Grass extends Plant {

	public Grass(int x, int y) {
		super(x, y);
		this.setGrowth(3);
		this.setMaxGrowth(5);
		this.setSymbol('*');
	}

}
