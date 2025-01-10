import java.io.Console;

public class Driver {

	public static void main(String[] args) {
		
		Castle castle = new Castle(Module.Simple);
		Player me = new Player(castle.getCAS().getRooms());
		Console c = System.console();
		if (c.readLine().equals("Look"))
			me.observe();
		
	}

}
