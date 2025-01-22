package main;
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
		
		scan = new Scanner(System.in);
		castle = new Castle(scan.nextInt());
		scan = new Scanner(System.in); //unless this is here, the above line will break the scanner
		me = new Player(castle.getCAS().getHall(), castle.getCAS().getNextHall(), castle.getCAS().getRooms());
		actionCheck = null;
		
	}
	
	private static byte actionCycle() throws InterruptedException {
		
		while (true) {
			
			ans = scan.nextLine().charAt(0);
			switch (ans) {
			
			case 'U':
				Thread.sleep(1000);
				me.getCurrentItem().Use();
				Thread.sleep(500);
				return 1;
				
			case 'D':
				System.out.println("You dropped the " + me.getCurrentItem().getName());
				me.drop();
				return 1;
			default:
				System.out.println("Improper input selection. Please refer to the action table and try again.");
				Thread.sleep(1000);
				me.printActions(actionCheck);
			
			}
			
		}
		
	}
	
	private static byte itemCycle() throws InterruptedException {
		
		while (true) {
			
			System.out.println("Which object would you like to pick up? (Enter full name and press ENTER)");
			sans = scan.nextLine();
			for (Item i : me.getCurrentRoom().getItems()) {
				
				if (sans.equals(i.getName())) {
				
					me.pickUp(i);
					actionCheck = i;
					System.out.println("You picked up " + i.getName() + "!");
					return 1;
				
				} 
				
			}
			System.out.println("Item is not present in room. Please make sure you spelled the name correctly, and try again.");
			Thread.sleep(1000);
			me.observe();

		}
		
	}
	
	private static byte moveCycle() throws InterruptedException {
		

		while (true) {
			err = 1;
			if (me.getCurrentRoom() == null) {
				System.out.println("There is a fearsome door at the far end of the hall. Press M to move through it.");
			} else {
			if (me.getCurrentRoom().getConnectedHall() != null)
				System.out.println("This room has a tall, archlike doorway. Press H to move through it.");
			if (me.getCurrentRoom().getConnectedRoom() != null)
				System.out.println("This room also has a shorter, stubbier doorway. Press D to move through it.");
			}
			ans = scan.nextLine().charAt(0);
			switch (ans) {
			
			case 'M':
				err = 2;
				castle.swapScheme(me.getNextHall());
				me = new Player(castle.getCAS().getHall(), castle.getCAS().getNextHall(), castle.getCAS().getRooms());
				return 0;
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
		while (true) {
		Thread.sleep(2000);
		if (err != 3)
			me.observe();
		do {
			
			err = 0;
			actionCheck = null;
			me.printActions(actionCheck);
			ans = scan.nextLine().charAt(0);
			switch (ans) {
			
			case 'P':
				err = 1;
				driver.itemCycle();
				Thread.sleep(1000);
				me.printActions(actionCheck);
				if (actionCheck != null) 
					driver.actionCycle();
				break;
			case 'O':
				err = 3;
				me.observe();
				break;
			case 'M':
				driver.moveCycle();
				err = 1;
				break;
			default:
				System.out.println("Incorrect input. Please refer to the table of available actions.");
				Thread.sleep(800);
				
			}
		} while (err == 0);
		
		}
		//scan.close();
	}

}
