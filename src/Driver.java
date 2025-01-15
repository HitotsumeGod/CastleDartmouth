import java.util.Scanner;

public class Driver {
	
	private static final Driver driver = new Driver();
	private static Castle castle;
	private static Player me;
	private static Scanner scan;
	private static Item actionCheck;
	private static String sans;
	private static char ans;
	private static int err;
	
	public Driver() {
		
		castle = new Castle(Module.Simple);
		me = new Player(castle.getCAS().getHall(), castle.getCAS().getRooms());
		scan = new Scanner(System.in);
		actionCheck = null;
		
	}
	
	private static byte itemCycle() {
		
		while (true) {
			
			System.out.println("Which object would you like to pick up? (Enter full name and press ENTER)");
			sans = scan.nextLine();
			for (Item i : me.getCurrentRoom().getItems()) {
				if (sans.equals(i.getName())) {
				
					me.pickUp(i);
					actionCheck = i;
					System.out.println("You picked up " + i.getName() + "!");
					return 1;
				
				} else {
				
					System.out.println("Item is not present in room. Please make sure you spelled the name correctly, and try again.");
					me.observe();
				
				}
				
			}

		}
		
	}
	
	private static byte roomCycle() {
		

		while (true) {
			err = 1;
			if (me.getCurrentRoom().getConnectedHall() != null)
				System.out.println("This room has a tall, archlike doorway. Press H to move through it.");
			if (me.getCurrentRoom().getConnectedRoom() != null)
				System.out.println("This room also has a shorter, stubbier doorway. Press D to move through it.");
			ans = scan.nextLine().charAt(0);
			switch (ans) {
			
			case 'H':
				err = 2;
				me.move(me.getCurrentRoom().getConnectedHall());
				return 0;
			case 'D':
				err = 2;
				me.move(me.getCurrentRoom().getConnectedRoom());
				return 0;
			default:
				System.out.println("Incorrect input. Please refer to the input prompts.");
		
			}
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		System.out.println("Game start.");
		Thread.sleep(2000);
		me.observe();
		do {
			
			err = 0;
			me.printActions(actionCheck);
			ans = scan.nextLine().charAt(0);
			switch (ans) {
			
			case 'P':
				err = 1;
				driver.itemCycle();
				break;
			case 'O':
				err = 1;
				me.observe();
				break;
			case 'M':
				driver.roomCycle();
				err = 1;
				break;
			default:
				System.out.println("Incorrect input. Please refer to the table of available actions.");
				Thread.sleep(800);
				
			}
		} while (err == 0);
		
		scan.close();
	}

}
