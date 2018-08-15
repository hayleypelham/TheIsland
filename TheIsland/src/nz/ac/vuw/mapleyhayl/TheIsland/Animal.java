package nz.ac.vuw.mapleyhayl.TheIsland;

public class Animal extends IslandEntity {

	private String species;
	private char gender;
	private int perception;
	private int health;
	private int hunger;
	private int thirst;
	private int speed;
	private String size;
	
	public Animal(int x, int y) {
		super(x, y);
		this.gender = getRandomGender();
	}

	public char getRandomGender() {
		int gender = (int) Math.floor(Math.random()*2);
		if (gender == 0) {
			return 'M';
		} 
		return 'F';
	}
	
	public String toString() {
		return "\n["+this.getID()+"] " + "Species: " + this.getSpecies() + "\nGender: " + this.getGender() + "\nPerception: " +
				this.getPerception() + "\nHealth: " + this.getHealth() + "\nSpeed: " + this.getSpeed() + 
				"\n" + this.getX() + " " + this.getY();
				
	}
	
	//accessor methods
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}

	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getPerception() {
		return perception;
	}
	public void setPerception(int perception) {
		this.perception = perception;
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public int getThirst() {
		return thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
}
