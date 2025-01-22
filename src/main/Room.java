package main;
import java.util.ArrayList;

class Room {

	private ArrayList<Item> items = new ArrayList<>();
	private String name = null;
	private Hall connector = null;
	private Room connected = null;

	public Room(String name, Hall connector, Room connected) {
	
		this.name = name;
		if (connector != null) {
			this.connector = connector;
			
		} else if (connected != null) {
			this.connected = connected;
		}

	}
	
	public void addItem (Item item) {
		
		items.add(item);
		
	}
	
	public void removeItem(Item item) {
		
		items.remove(item);
		
	}

	public String getName() {

		return name;

	}

	public ArrayList<Item> getItems() {

		return items;

	} 

	public void connectHall(Hall hall) {

		connector = hall;

	} 

	public void connectRoom(Room room) {

		connected = room;

	}

	public Hall getConnectedHall() {

		return connector;

	}

	public Room getConnectedRoom() {

		return connected;

	} 
	
}
