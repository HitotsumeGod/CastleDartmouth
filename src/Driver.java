public class Driver {

	private static Location location = null;

	public static void main(String[] args) {
		
		Castle castle = new Castle(Module.Simple);
		location = castle.getRoomTemplate().get(0);
	       	//System.out.println(location.getConnectedHall());	

	}

}
