import java.util.ArrayList;

class Player {
	
	private ArrayList<Room> rooms;
	private Room currentRoom;
	
	Player(ArrayList<Room> rooms) {
		
		this.rooms = rooms;
		currentRoom = rooms.getFirst();
		
	}

	public void observe() {
		
		System.out.println("You take a look around the room. There are some items here :");
		currentRoom.printItems();
		
	}
	
}
