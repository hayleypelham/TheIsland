package nz.ac.vuw.mapleyhayl.TheIsland;

import java.util.*;

public class Island {
	
	private ArrayList<IslandEntity> allEntities = new ArrayList<IslandEntity>();
	private ArrayList<Animal> allAnimals = new ArrayList<Animal>();
	private ArrayList<Plant> allPlants = new ArrayList<Plant>();
	private int height = 20;
	private int width = 50;
	
	public Island(ArrayList<IslandEntity> allEntities, ArrayList<Animal> allAnimals, ArrayList<Plant> allPlants) {
		this.allEntities = allEntities;
		this.allAnimals = allAnimals;
		this.setAllPlants(allPlants);
	}
	
	public Island(ArrayList<IslandEntity> allEntities, ArrayList<Animal> allAnimals, ArrayList<Plant> allPlants, int height, int width) {
		this.allEntities = allEntities;
		this.allAnimals = allAnimals;
		
		this.height = height;
		this.width = width;
	}
	
	public void drawIsland() {
		for (int i=0; i<=height; i++) {
			System.out.print("|");
			for (int j=0; j<width; j++) {
				if (i==0 || i==height) {
					System.out.print("-");
				} else {
					System.out.print(checkForEntity(j+1, i+1));
				}
			}
			System.out.println("|");
		}
	}
	
	public void randomlyMoveAnimals() {
		for (int i=0; i<10; i++) {
			for (int j=0; j<allAnimals.size(); j++) {
				Animal movingEntity = allAnimals.get(j);
				int currentX = movingEntity.getX();
				int currentY = movingEntity.getY();
				int distance = 1;
				int direction = (int) Math.ceil(Math.random()*4); //1=N, 2=S, 3=E, 4=W
				//to do: check if rabbits can see food nearby, if so, change direction to that of food
				
				for (int k=0; k<movingEntity.getSpeed(); k++) {
					switch (direction) {
					case 1 : //north
						int newUpY = movingEntity.getY()-distance;
						if (newUpY > 1 && newUpY < this.getHeight() && !isAnimalPresent(currentX, newUpY)) {
							movingEntity.setY(newUpY);
						}
						break;
					case 2 : //south
						int newDownY = movingEntity.getY()+distance;
						if (newDownY > 1 && newDownY < this.getHeight() && !isAnimalPresent(currentX, newDownY)) {
							movingEntity.setY(newDownY);
						}
						break;
					case 3 : //east
						int newRightX = movingEntity.getX()+distance;
						if (newRightX > 1 && newRightX < this.getWidth() && !isAnimalPresent(newRightX, currentY)) {
							movingEntity.setX(newRightX);
						}
						break;
					case 4 : //west
						int newLeftX = movingEntity.getX()-distance;
						if (newLeftX > 1 && newLeftX < this.getWidth() && !isAnimalPresent(newLeftX, currentY)) {
							movingEntity.setX(newLeftX);
						}
						break;
					}
					this.drawIsland();
				}
				try {
					Thread.sleep(150);
				} catch (Exception e) {};
				int currentHunger = movingEntity.getHunger();
				movingEntity.setHunger(currentHunger-1);
				if (!(movingEntity instanceof Kiwi) && movingEntity.getHunger()<=0) {
					allEntities.remove(movingEntity);
					allAnimals.remove(movingEntity);
				}
			}
		}
	}
	
	public boolean isAnimalPresent(int x, int y) {
		for (Animal i : allAnimals) {
			if (i.getX()==x && i.getY()==y) {
				return true;
			}
		}
		return false;
	}
	
	//ran out of time, detects if there is a plant within perception of an animal
//	public boolean isPlantPresent(int x, int y) {
//		for (Plant p : allPlants) {
//		}
//	}
	
	public void showSurvivors() {
		System.out.println("There are " + allAnimals.size() + " animal(s) remaining.");
	}
	
	//returns " " if no entity is present, otherwise prints symbol of the entity
	public char checkForEntity(int x, int y) {
		for (IslandEntity i : allEntities) {
			if (i.getX()==x && i.getY()==y) {
				return i.getSymbol();
			}
		}
		return ' ';
	}

	
	//accessor methods
 	public ArrayList<IslandEntity> getAllEntities() {
		return allEntities;
	}
	public void setAllEntities(ArrayList<IslandEntity> allEntities) {
		this.allEntities = allEntities;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public ArrayList<Animal> getAllAnimals() {
		return allAnimals;
	}

	public void setAllAnimals(ArrayList<Animal> allAnimals) {
		this.allAnimals = allAnimals;
	}

	public ArrayList<Plant> getAllPlants() {
		return allPlants;
	}

	public void setAllPlants(ArrayList<Plant> allPlants) {
		this.allPlants = allPlants;
	}
	
}
