import java.util.ArrayList;

class Hall {

	private ArrayList<Room> rooms = new ArrayList<>();
	private Hall altHall = null;

	Hall() {
	
	}

	public ArrayList<Room> getConnectedRooms() {

		return rooms;

	}

	public Hall getConnectedHall() {

		return altHall;

	}

}
