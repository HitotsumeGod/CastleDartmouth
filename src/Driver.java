import java.io.Console;

public class Driver {

	public static void main(String[] args) throws Exception {
		
		Castle castle = new Castle(Module.Simple);
		Player me = new Player(castle.getCAS().getHall(), castle.getCAS().getRooms());
		Console c = System.console();
		if (c.readLine().equals("Look"))
			me.observe();
		if (c.readLine().equals("Go"))
			me.move(me.getHall());
		Thread.sleep(2000);
		me.observe();
		
	}

}
