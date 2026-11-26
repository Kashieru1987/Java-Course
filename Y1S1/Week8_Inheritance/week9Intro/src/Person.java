public class Person {
	public final String name;
	public final int id;

	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", id=" + id +
				'}';
	}
}

