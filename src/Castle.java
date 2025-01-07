class Castle {
	
	private RoomTemplate template;
	private ItemLib il;

	public Castle(Module module) {

		il = ItemLib.getInstance();
		construct(module);

	} 

	public RoomTemplate getRoomTemplate() {

		return template;

	}

	private void construct(Module module) {

		switch(module) {

		case Simple:
			template = new RoomTemplate.TemplateBuilder().addRoom(new Room.RoomBuilder("thisroom", null).addItem(il.get(0)).addItem(il.get(2)).build()).addRoom(new Room.RoomBuilder("myroom", null).build()).build();
			break;
		case Understandable:
			break;
		case Complex:
			break;

		}

	}

}

enum Module {Simple, Understandable, Complex}
