import java.util.ArrayList;

class Room {


	private ArrayList<Item> items = new ArrayList<>();
	private String name;

	public Room(String name, Item item1) {
	
		this.name = name;
		this.items.add(item1);
	
	} 

	public Room(String name, Item item1, Item item2) {

		this.name = name;
		this.items.add(item1);
		this.items.add(item2);	

	}

   	public Room(String name, Item item1, Item item2, Item item3) {
		
		this.name = name;
		this.items.add(item1);
		this.items.add(item2);
		this.items.add(item3);

	}

	public Room(String name, Item item1, Item item2, Item item3, Item item4) {
		
		this.name = name;
		this.items.add(item1);
		this.items.add(item2);
		this.items.add(item3);
		this.items.add(item4);

	}

	public String getName() {

		return name;

	}

	public void printItems() {

		for (Item item : items)
			System.out.println(item.getName());

	}
}
