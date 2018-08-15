package nz.ac.vuw.mapleyhayl.TheIsland;

public class Plant extends IslandEntity {

	private int growth;
	private int maxGrowth;
	private char symbol;
	
	public Plant(int x, int y) {
		super(x, y);
	}
	
	public String toString() {
		return "\n["+this.getID()+"] " + "Symbol: " + symbol + "\nGrowth: " + growth +
				"\n" + this.getX() + " " + this.getY();
	}

	public int getGrowth() {
		return growth;
	}
	public void setGrowth(int growth) {
		this.growth = growth;
	}

	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getMaxGrowth() {
		return maxGrowth;
	}

	public void setMaxGrowth(int maxGrowth) {
		this.maxGrowth = maxGrowth;
	}
}
