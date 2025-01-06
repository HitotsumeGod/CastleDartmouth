import java.util.ArrayList;

class ItemLib extends ArrayList<Item> {

	private final String[] names = new String[] {"Dragon Skull", "Ruby Medallion", "Pharoah Crown"};
	private final String[] uses = new String[] {"The skull begins to heat beneath your fingers.", "The medallion takes on a lusty sheen.", "You hear a wet, choking rasp."};
	private final String[] observations = new String[] {"It is the dusty skull of a young dragon.", "It is a medallion with a crimson coloration.", "It is the cobwebbed crown of a former pharoah."};

	private static final ItemLib instance = new ItemLib();
	private final int length;

	private ItemLib() {
		
		length = 0;
		for (String s : names)
			length++;
		for (int i = 0; i < length; i++)
			this.add(new Item(names[i], uses[i], observations[i]));

	}

	public Item getItem(int i) {

		return this.get(i);

	}

	public Item getItem(String name) {

		for (Item item : this)
			if (item.getName().equals(name))
				return item;		

	} 

	public ItemLib getInstance() {

		return instance;

	}

}
