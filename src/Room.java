import java.util.ArrayList;

class Room extends Location {


	private ArrayList<Item> items = new ArrayList<>();
	private String name = null;
	private Hall connector = null;
	private Room connected = null;

	private Room(RoomBuilder builder) {
	
		this.items = builder.items;
		this.name = builder.name;
		this.connector = builder.connector;
		this.connected = builder.connected;

	}

	public String getName() {

		return name;

	}

	public void printItems() {

		for (Item item : items)
			System.out.println(item.getName());

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

		public RoomBuilder(String name, Location location) {

			this.name = name;
			//brute-force location function; fix soon
			try {
				this.connector = location;
			} catch (Exception e) {
				this.connector = connected;
			}

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
