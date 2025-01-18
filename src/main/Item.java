package main;
class Item implements Actionable {

	private final String name;
	private final String u;
	private final String o;
	
	Item(String name, String use, String observe) {
	
		this.name = name;
		this.u = use;
		this.o = observe;

	}

	public String getName() {

		return name;

	}

	public void Use() {

		System.out.println(u);

	}

	public void Observe() {

		System.out.println(o);

	}

}
