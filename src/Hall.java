import java.util.ArrayList;

class Hall {

	private ArrayList<Room> rooms = new ArrayList<>();
	private Hall altHall = null;
	private final String name;

	Hall(String name) {
		
		this.name = name;
	
	}

	public ArrayList<Room> getConnectedRooms() {

		return rooms;

	}

	public Hall getConnectedHall() {

		return altHall;

	}
	
	public String getName() {
		
		return name;
		
	}
	
	public Hall getInstance() {
		
		return this;
		
	}

}
