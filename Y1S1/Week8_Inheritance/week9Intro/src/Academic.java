public class Academic extends Person {
	public final String subject;

	public Academic(String name, int id, String subject) {
		super(name, id);
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Academic{" +
				"name='" + name + '\'' +
				", id=" + id +
				", subject='" + subject + '\'' +
				'}';
	}
}
