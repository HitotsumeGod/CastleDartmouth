import java.util.ArrayList;

class RoomLib extends ArrayList<Room> {

	RoomLib() {

		this.add(new Room().RoomBuilder().addItem(ItemLib.getInstance().getItem(0)).build());

	} 

	public Room getRoom(int i) {

		return this.get(i);

	}

}
