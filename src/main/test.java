package main;

public class test {

	public static void main(String[] args) {
	
		Room tycoon = new Room(null, null, null);
		Room jerome = new Room(null, null, tycoon);
		if (jerome.getConnectedRoom() != null)
			System.out.print(false);

	}

}
