import java.util.ArrayList;

class RoomTemplate extends ArrayList<Room> {

	RoomTemplate(TemplateBuilder tb) {

		for (Room room : tb.getList())
			this.add(room);		

	} 

	public Room getRoom(int i) {

		return this.get(i);

	} 

	public static class TemplateBuilder {

		private ArrayList<Room> list = new ArrayList<>();

		public TemplateBuilder addRoom(Room room) {

			list.add(room);
			return this;

		}

		public RoomTemplate build() {

			return new RoomTemplate(this);
			
		}

		public ArrayList<Room> getList() {

			return list;

		}

	}

}
