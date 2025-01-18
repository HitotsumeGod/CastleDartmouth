import java.util.ArrayList;
import java.util.Random;

class Castle {
	
	private ItemLib il;
	private ArrayList<HallScheme> schemes;
	private static HallScheme currentActiveScheme;

	public Castle(Module module) {

		il = ItemLib.getInstance();
		schemes = new ArrayList<>();
		construct(module);
		Random rand = new Random();
		int max = schemes.size() - 1;
		int min = 0;
		currentActiveScheme = schemes.getFirst();              //(rand.nextInt((max - min) + 1) + min);

	} 

	private void construct(Module module) {

		switch(module) {

		case Simple:
			Hall hall = new Hall("hall");
			Hall altHall = new Hall("like kys fella");
			Room r1 = new Room.RoomBuilder(null, hall).addItem(il.get(0)).addItem(il.get(1)).addItem(il.get(2)).build();
			Room r2 = new Room.RoomBuilder(null, hall).addItem(il.get(2)).addItem(il.get(1)).build();
			Room r3 = new Room.RoomBuilder(null, hall).addItem(il.get(0)).addItem(il.get(1)).build();
			schemes.add(new HallScheme.SchemeBuilder(hall, altHall, r1).addRoom(r2).addRoom(r3).build());
			hall = altHall.getInstance();
			altHall = new Hall("Thissa hall");
			r1 = new Room.RoomBuilder(null, hall).build();
			r2 = new Room.RoomBuilder(null, hall).addItem(il.get(1)).build();
			schemes.add(new HallScheme.SchemeBuilder(hall, altHall, r1).addRoom(r2).build());
			
			break;
		case Understandable:
			break;
		case Complex:
			break;

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

enum Module {Simple, Understandable, Complex}
