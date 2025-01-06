import java.util.ArrayList;

class Room {

	private ArrayList<Item> items;

	private Room(RoomBuilder rb) {
	
		this.items = rb.items;
	
	}

	public void printItems() {

		for (Item item : items)
			System.out.println(item.getName());

	}

	public static class RoomBuilder {
		
		private ArrayList<Item> items = new ArrayList<>();

		public RoomBuilder addItem(Item item) {

			this.items.add(item);
			return this;

		}
		
		public Room build() {

			return new Room(this);

		}	

	} 


}
