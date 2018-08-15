package nz.ac.vuw.mapleyhayl.TheIsland;

public class IslandEntity {

	private int x;
	private int y;
	private char symbol;
	private int ID;
	private static int count;

	public IslandEntity(int x, int y) {
		this.x = x;
		this.y = y;
		this.ID = count;
		count++;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		IslandEntity.count = count;
	}


	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
