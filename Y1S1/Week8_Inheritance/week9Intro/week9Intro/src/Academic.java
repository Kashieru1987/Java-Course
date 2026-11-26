public class Academic {
	public final String name;
	public final int id;
	public final String subject;

	public Academic(String name, int id, String subject) {
		this.name = name;
		this.id = id;
		this.subject = subject;
	}

	public void display() {
		System.out.println(name + " " + id + " " + subject);
	}
}
