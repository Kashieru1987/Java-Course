public class Student extends Person {
	public final String department;
	public final String degree;

	public Student(String name, int id, String department, String degree) {
		super(name, id);
		this.department = department;
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", id=" + id +
				", degree='" + degree + '\'' +
				", department='" + department + '\'' +
				'}';
	}
}