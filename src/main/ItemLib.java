package main;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

class ItemLib extends ArrayList<Item> {

	private static final ItemLib instance = new ItemLib();
	private int numberofItems = 0;

	private ItemLib() {
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File("items")));
			while (reader.readLine() != null) numberofItems++;
			reader = new BufferedReader(new FileReader(new File("items")));
			for (int i = 0; i < (numberofItems / 3); i++) 
				this.add(new Item(reader.readLine(), reader.readLine(), reader.readLine()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static ItemLib getInstance() {

		return instance;

	}

}
