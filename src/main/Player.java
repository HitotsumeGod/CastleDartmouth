package main;

import java.util.Random;

class Player {
	
	private Hall hall;
	private Hall nextHall;
	private Room[] rooms;
	private Room currentRoom;
	private Item currentItem;
	private Random rand = new Random();
	
	Player(Hall hall, Hall nextHall, Room[] rooms) {
		
		this.hall = hall;
		this.nextHall = nextHall;
		this.rooms = rooms;
		currentRoom = rooms[rand.nextInt(rooms.length)];
		
	}
	
	private boolean hasAdjacentRoom() {
		
		if (currentRoom.getConnectedRoom() != null)
			return true;
		return false;
		
	}
	
	private boolean hasAdjacentHall() {
		
		if (currentRoom.getConnectedHall() != null)
			return true;
		return false;
		
	}

	public void observe() {
		
		if (currentRoom != null) {
		
			System.out.println("You take a look around the room. There are some items here :");
			System.out.println();
			for (Item i : getCurrentRoom().getItems())
				System.out.println(i.getName());
			System.out.println();
			if (hasAdjacentHall())
				System.out.println("There is a tall door to your right.");
			if (hasAdjacentRoom())
				System.out.println("There is a short, stout door at the opposite end of the room.");
		
		} else {
			
			System.out.println("You take a look around the hallway. It's just as drab as all the rooms, and there are " + (rooms.length - 1) + " doors that you can see.");
			System.out.println("At the far end of the hall, you can just barely make out another tall, arching doorway.");
			
		}
	}
	
	public void move(Hall hall) {
		
		currentRoom = null;
		System.out.println("You step through the tall doorway and find yourself in another long hall.");
		
	}
	
	public void move(Room room) {
		
		currentRoom = room;
		System.out.println("You step through the short door and find yourself in another barren room.");
		
	}
	
	public void pickUp(Item item) {
		
		currentRoom.removeItem(item);
		currentItem = item;
		System.out.println("You picked up " + item.getName() + "!");
		
	}
	
	public void drop(Player me) {
		
		System.out.println("You dropped the " + me.getCurrentItem().getName() + ".");
		currentRoom.addItem(currentItem);
		currentItem = null;
		
	}
	
	public Item getCurrentItem() {
		
		return currentItem;
		
	}
	
	public Room getCurrentRoom() {
		
		return currentRoom;
		
	}
	
	public Hall getHall() {
		
		return hall;
		
	}
	
	public Hall getNextHall() {
		
		return nextHall;
		
	}
	
	public void printActions(Item item) {
		
		if (item == null) {
			
			System.out.println("-----------   -----------   --------");
			System.out.println("(P) PICK UP   (O) OBSERVE   (M) MOVE");
			System.out.println("-----------   -----------   --------");
			
		} else {
			
			System.out.println("-------   --------");
			System.out.println("(U) USE   (D) DROP");
			System.out.println("-------   --------");
			
			
		}
		
	}
	
}
