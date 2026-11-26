public class Person {
	public final String name;
	public final int id;

	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("id: " + id);
	}

}

