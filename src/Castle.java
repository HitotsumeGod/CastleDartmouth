class Castle {
	
	private RoomTemplate template;
	private ItemLib il;

	public Castle(Module module) {

		il = ItemLib.getInstance();
		construct(module);

	}

	private void construct(Module module) {

		switch(module) {

		case Simple:
			template = new RoomTemplate.TemplateBuilder().addRoom(new Room("thisroom", il.getItem(0), il.getItem(2))).addRoom(new Room("secondroom", il.getItem(0), il.getItem(1), il.getItem(2))).build();
			template.get(0).printItems();
			break;
		case Understandable:
			break;
		case Complex:
			break;

		}

	}

}

enum Module {Simple, Understandable, Complex}
