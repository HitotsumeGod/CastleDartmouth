package main;
import java.util.Random;

class HallScheme {
	
	private Hall hall;
	private Hall nextHall;
	private Room[] rooms;
	private Room accessRoom;
	
	public HallScheme(Hall hall, Hall nextHall, Room[] rooms) {
		
		this.hall = hall;
		this.nextHall = nextHall;
		this.rooms = rooms;
		this.accessRoom = accessAssigner();
		
	}
	
	private Room accessAssigner() {
		
		Random rand = new Random();
		int max = rooms.length - 1;
		int min = 0;
		return rooms[rand.nextInt((max - min) + 1) + min];
		
	}
	
	public String getRoomType(Room room) {
		
		if (room.equals(accessRoom))
			return "ACCESS";
		return "BASIC";
		
	}
	
	public Room[] getRooms() {
		
		return rooms;
		
	}
	
	public Hall getHall() {
		
		return hall;
		
	}
	
	public Hall getNextHall() {
		
		return nextHall;
		
	}

}
