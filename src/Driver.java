public class Driver {

	public static void main(String[] args) {
		
		ItemLib il = ItemLib.getInstance();
		Room r1 = new Room.RoomBuilder("room1").addItem(il.get(0)).build();
		Room r2 = new Room.RoomBuilder("room2").addItem(il.get(1)).build();
		RoomTemplate template = new RoomTemplate.TemplateBuilder().addRoom(r1).addRoom(r2).build();
		template.get(0).printItems();

	}

}
