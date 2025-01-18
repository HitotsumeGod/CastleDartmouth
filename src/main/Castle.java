package main;
import java.util.ArrayList;
import java.util.Random;

class Castle {
	
	private ItemLib il;
	private ArrayList<HallScheme> schemes;
	private static HallScheme currentActiveScheme;
	private Random rand;
	int max;
	int min;

	public Castle(int i) {

		il = ItemLib.getInstance();
		schemes = new ArrayList<>();
		construct(i);
		rand = new Random();
		max = schemes.size() - 1;
		min = 0;
		currentActiveScheme = schemes.getFirst();              //(rand.nextInt((max - min) + 1) + min);

	} 

	private void construct(int num) {

		switch(num) {

		case 4:
			max = 5;
			min = 1;
			int numRooms = rand.nextInt((max - min) + 1) + min;
			Room[] tempRooms = new Room[numRooms];
			for (int i = 0; i < numRooms; i++) {
			
				//for each room in the scheme, generates an item array of random items from itemlib, and iteratively adds them to the newly generated room 
				max = 4;
				max = 0;
				int numItems = rand.nextInt((max - min) + 1) + min;
				Item[] tempItems = new Item[numItems];
				for (int i2 = 0; i2 < numItems; i2++) 
					tempItems[i2] = il.get(rand.nextInt((il.size() - 0) + 1) + 0);
				tempRooms[0] = new Room(null, null, null);
				for (Item it : tempItems)
					tempRooms[i].addItem(it);
			
			}
			break;
		case 12:
			break;
		case 36:
			break;
		default:
			System.exit(0);

		}

	}
	
	public void swapScheme(Hall hall) {
		
		for (HallScheme hs : schemes) 
			if (hs.getHall().equals(hall))
				currentActiveScheme = hs;
		
	}
	
	public HallScheme getCAS() {
		
		return currentActiveScheme;
		
	}

}