import java.util.ArrayList;

class ItemLib extends ArrayList<Item> {

	private final String[] names = new String[] {"Dragon Skull", "Ruby Medallion", "Pharoah Crown", "Finger of the Lost Expedition"};
	private final String[] uses = new String[] {"The skull begins to heat beneath your fingers.", "The medallion takes on a lusty sheen.", "You hear a wet, choking rasp.", "The thing begins to twitch in your hand."};
	private final String[] observations = new String[] {"It is the dusty skull of a young dragon.", "It is a medallion with a crimson coloration.", "It is the cobwebbed crown of a former pharoah.", "It is a relic of that old, long-lost expedition."};

	private static final ItemLib instance = new ItemLib();
	private int length = 0;

	private ItemLib() {
		
		for (String s : names)
			length++;
		for (int i = 0; i < length; i++)
			this.add(new Item(names[i], uses[i], observations[i]));

	}

	public Item getItem(String name) {

		for (Item item : this)
			if (item.getName().equals(name))
				return item;		
		return null;

	} 

	public static ItemLib getInstance() {

		return instance;

	}

}
