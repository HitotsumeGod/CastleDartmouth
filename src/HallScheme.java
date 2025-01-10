import java.util.ArrayList;
import java.util.Random;

class HallScheme {
	
	private Hall hall;
	private Hall nextHall;
	private ArrayList<Room> rooms;
	private Room accessRoom;
	
	private HallScheme(SchemeBuilder builder) {
		
		this.hall = builder.hall;
		this.nextHall = builder.nextHall;
		this.rooms = builder.rooms;
		this.accessRoom = accessAssigner();
		
	}
	
	private Room accessAssigner() {
		
		Random rand = new Random();
		int max = rooms.size();
		int min = 0;
		return rooms.get(rand.nextInt((max - min) + 1) + min);
		
	}
	
	public String getRoomType(Room room) {
		
		if (room.equals(accessRoom))
			return "ACCESS";
		return "BASIC";
		
	}
	
	
	
	public static class SchemeBuilder {
		
		private Hall hall;
		private Hall nextHall;
		private ArrayList<Room> rooms;
		
		public SchemeBuilder(Hall hall, Hall nextHall, Room room) {
			
			this.hall = hall;
			this.nextHall = nextHall;
			this.rooms.add(room);
			
		}
		
		public SchemeBuilder addRoom(Room room) {
			
			this.rooms.add(room);
			return this;
			
		}
		
		public HallScheme build() {
			
			return new HallScheme(this);
			
		}

	}

}
