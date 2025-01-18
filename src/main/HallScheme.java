package main;
import java.util.ArrayList;
import java.util.Random;

class HallScheme {
	
	private Hall hall;
	private Hall nextHall;
	private ArrayList<Room> rooms;
	private Room accessRoom;
	
	public HallScheme(Hall hall, Hall nextHall, ArrayList<Room> rooms, Room accessRoom) {
		
		this.hall = hall;
		this.nextHall = nextHall;
		this.rooms = rooms;
		this.accessRoom = accessAssigner();
		
	}
	
	private Room accessAssigner() {
		
		Random rand = new Random();
		int max = rooms.size() - 1;
		int min = 0;
		return rooms.get(rand.nextInt((max - min) + 1) + min);
		
	}
	
	public String getRoomType(Room room) {
		
		if (room.equals(accessRoom))
			return "ACCESS";
		return "BASIC";
		
	}
	
	public ArrayList<Room> getRooms() {
		
		return rooms;
		
	}
	
	public Hall getHall() {
		
		return hall;
		
	}
	
	public Hall getNextHall() {
		
		return nextHall;
		
	}

}
