package main;
import java.util.Random;

class Castle {
	
	private ItemLib il;
	private HallScheme[] schemes;
	private static HallScheme currentActiveScheme;
	private Random rand;
	int max;
	int min;

	public Castle(int i) {

		rand = new Random();
		il = ItemLib.getInstance();
		construct(i);
		currentActiveScheme = schemes[0];             //(rand.nextInt((max - min) + 1) + min);

	} 

	private void construct(int num) {

		switch(num) {

		case 4:
			schemes = new HallScheme[num];
			HallScheme[] tempSchemes = schemes;
			Hall[] tempHalls = new Hall[num];
			for (int i = 0; i < num; i++) {
				
				//for each hallscheme in the array, generates a room array (size randomized)
				max = 5;
				min = 1;
				int numRooms = rand.nextInt((max - min) + 1) + min;
				Room[] tempRooms = new Room[numRooms];
				for (int i2 = 0; i2 < numRooms; i2++) {
				
					//for each room in the scheme, generates an item array of random items from itemlib, and iteratively adds them to the newly generated room 
					int numItems = rand.nextInt(4);
					Item[] tempItems = new Item[numItems];
					for (int i3 = 0; i3 < numItems; i3++) 
						tempItems[i3] = il.get(rand.nextInt(il.size() - 1));
					tempRooms[i2] = new Room(null, null, null);
					for (Item it : tempItems)
						tempRooms[i2].addItem(it);
				
				}
				//at this point, tempRooms is an array of numRooms size filled with fully functional rooms
				tempHalls[i] = new Hall(null);
				try {
				tempSchemes[i] = new HallScheme(tempHalls[i], tempHalls[i + 1], tempRooms);
				} catch (ArrayIndexOutOfBoundsException e) {
					tempSchemes[i] = new HallScheme(tempHalls[i], tempHalls[0], tempRooms);
				}
			
			}
			schemes = tempSchemes;
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