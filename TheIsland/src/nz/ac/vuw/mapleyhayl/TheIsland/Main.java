package nz.ac.vuw.mapleyhayl.TheIsland;

import java.util.*;

public class Main {

	Scanner in = new Scanner(System.in);
	ArrayList<IslandEntity> allEntities = new ArrayList<IslandEntity>();
	ArrayList<Animal> allAnimals = new ArrayList<Animal>();
	ArrayList<Plant> allPlants = new ArrayList<Plant>();
	Island currentIsland = new Island(allEntities, allAnimals, allPlants);	

	public Main() {
		this.menu();
	}

	public void menu() {
		System.out.println("\n----- MENU -----\n");
		System.out.println("[1] Show island");
		System.out.println("[2] Add rabbit");
		System.out.println("[3] Add kiwi");
		System.out.println("[4] Add grass");
		System.out.println("[5] Run simulation");
		System.out.println("[6] Run double simulation");
		System.out.println("[7] Show object attributes\n:");
		int ans= in.nextInt();
		if (ans == 1) {
			this.showIsland();
		} else if (ans == 2) {
			this.addRabbit();
		} else if (ans == 3) {
			this.addKiwi();
		} else if (ans == 4) {
			this.addGrass();
		} else if (ans == 5) {
			currentIsland.randomlyMoveAnimals();
			currentIsland.showSurvivors();
			this.menu();
		} else if (ans == 6) {
			this.runDoubleSimulation();
		} else if (ans == 7) {
			this.showAttributes();
			this.menu();
		} else {
			System.out.println("Please enter a valid option: ");
			this.menu();
		}
	}

	public void showIsland() {
		currentIsland = new Island(allEntities, allAnimals, allPlants);
		currentIsland.drawIsland();
		this.menu();
	}

	public void addRabbit() {
		System.out.println("How many rabbits would you like to add?: ");
		int ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			Rabbit newRabbit = new Rabbit(getRandomCoord("x"), getRandomCoord("y"));
			allEntities.add(newRabbit);
			allAnimals.add(newRabbit);
		}
		this.showIsland();
		this.menu();
	}
	
	public void addKiwi() {
		System.out.println("How many kiwi would you like to add?: ");
		int ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			Kiwi newKiwi = new Kiwi(getRandomCoord("x"), getRandomCoord("y"));
			allEntities.add(newKiwi);
			allAnimals.add(newKiwi);
		}
		this.showIsland();
		this.menu();
	}
	
	public void addGrass() {
		System.out.println("How many grass patches would you like to add?: ");
		int ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			Grass newGrass = new Grass(getRandomCoord("x"), getRandomCoord("y"));
			allEntities.add(newGrass);
			allPlants.add(newGrass);
		}
		this.showIsland();
		this.menu();
	}
	
	public void runSimulation() {
		currentIsland.randomlyMoveAnimals();
		//ran out of time to get this to work - trying to increase plantgrowth
//		ArrayList<Plant> plants = currentIsland.getAllPlants();
//		for (int i=0; i<plants.size(); i++) {
//			Plant tempPlant = plants.get(i);
//			if (tempPlant.getGrowth()<tempPlant.getMaxGrowth()) {
//				tempPlant.setGrowth(tempPlant.getGrowth()+1);
//				plants.remove(i);
//				plants.add(tempPlant);
//			}
//		}
		this.menu();
	}

	public void runDoubleSimulation() {
		ArrayList<IslandEntity> entities1 = new ArrayList<IslandEntity>();
		ArrayList<Animal> animals1 = new ArrayList<Animal>();
		ArrayList<Plant> plants1 = new ArrayList<Plant>();
		ArrayList<IslandEntity> entities2 = new ArrayList<IslandEntity>();
		ArrayList<Animal> animals2 = new ArrayList<Animal>();
		ArrayList<Plant> plants2 = new ArrayList<Plant>();
		System.out.println("How many rabbits would you like to add to Island 1?");
		int ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			Rabbit newRabbit = new Rabbit(getRandomCoord("x"), getRandomCoord("y"));
			animals1.add(newRabbit);
			entities1.add(newRabbit);
		}
		System.out.println("How many grass patches would you like to add to Island 1?");
		ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			Plant newPlant = new Plant(getRandomCoord("x"), getRandomCoord("y"));
			plants1.add(newPlant);
			entities1.add(newPlant);
		}
		System.out.println("How many rabbits would you like to add to Island 2?");
		ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			Rabbit newRabbit = new Rabbit(getRandomCoord("x"), getRandomCoord("y"));
			animals2.add(newRabbit);
			entities2.add(newRabbit);
		}
		System.out.println("How many grass patches would you like to add to Island 2?");
		ans = in.nextInt();
		for (int i=0; i<ans; i++) {
			Plant newPlant = new Plant(getRandomCoord("x"), getRandomCoord("y"));
			plants2.add(newPlant);
			entities2.add(newPlant);
		}
		Island one = new Island(entities1, animals1, plants1);
		Island two = new Island(entities2, animals2, plants2, 30, 60);
		one.randomlyMoveAnimals();
		two.randomlyMoveAnimals();
		one.showSurvivors();
		two.showSurvivors();
	}

	public void showAttributes() {
		for (IslandEntity i : allEntities) {
			System.out.println(i.toString());
		}
	}

	//if input is 'x', return random x. Else, y.
	public int getRandomCoord(String input) {
		int min = 2;
		int max = 0;
		if (input.equals("x")) {
			max = currentIsland.getWidth()-1;
		} else if (input.equals("y")) {
			max = currentIsland.getHeight()-1;
		}
		int range = (max-min) + 1;
		return (int) (Math.random()*range) + min;
	}

	public static void main(String[] args) {
		new Main();
	}

}
