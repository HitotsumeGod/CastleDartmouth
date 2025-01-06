import java.util.ArrayList;

class RoomLib extends ArrayList<Room> {

	RoomLib() {
		
		ItemLib il = ItemLib.getInstance();
		this.add(new Room.RoomBuilder("yourroom").addItem(il.getItem(0)).addItem(il.getItem(1)).build());

	} 

	public Room getRoom(int i) {

		return this.get(i);

	}

}
