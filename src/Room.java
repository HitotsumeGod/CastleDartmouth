import java.util.ArrayList;

class Room {


	private ArrayList<Item> items;
	private String name;

	private Room(RoomBuilder rb) {
	
		this.items = rb.items;
		this.name = rb.name;
	
	}

	public String getName() {

		return name;

	}

	public void printItems() {

		for (Item item : items)
			System.out.println(item.getName());

	}

	public static class RoomBuilder {
		
		private ArrayList<Item> items = new ArrayList<>();
		private String name;
		
		public RoomBuilder(String name) {


			this.name = name;

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
