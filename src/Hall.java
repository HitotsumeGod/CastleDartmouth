import java.util.ArrayList;

class Hall extends Location {

	private ArrayList<Room> rooms = new ArrayList<>();
	private Hall altHall = null;

	private Hall(HallBuilder builder) {
	
		this.rooms = builder.rooms;
	
	}

	public ArrayList<Room> getConnectedRooms() {

		return rooms;

	}

	public Hall getConnectedHall() {

		return altHall;

	}

	public static class HallBuilder {

		private ArrayList<Room> rooms = new ArrayList<>();

		public HallBuilder(Room room) {

			rooms.add(room);

		} 

		public HallBuilder addRoom(Room room) {

			rooms.add(room);
			return this;

		}

		public Hall build() {

			return new Hall(this);

		}

	}	

}
