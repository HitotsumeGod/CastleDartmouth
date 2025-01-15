import java.util.ArrayList;

class Room {


	private ArrayList<Item> items = new ArrayList<>();
	private String name = null;
	private Hall connector = null;
	private Room connected = null;

	private Room(RoomBuilder builder) {
	
		this.items = builder.items;
		this.name = builder.name;
		if (builder.connector != null) {
			this.connector = builder.connector;
			
		} else if (builder.connected != null) {
			this.connected = builder.connected;
		}

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

	public static class RoomBuilder {

		private ArrayList<Item> items = new ArrayList<>();
		private String name = null;
		private Hall connector = null;
		private Room connected = null;

		public RoomBuilder(String name, Hall location) {

			this.name = name;
			this.connector = location;

		}
		
		public RoomBuilder(String name, Room location) {
			
			this.name = name;
			this.connected = location;
			
		}

		public RoomBuilder addItem(Item item) {

			this.items.add(item);
			return this;

		} 

		public Room build() {

			return new Room(this);

		}
	

	}

	
}
