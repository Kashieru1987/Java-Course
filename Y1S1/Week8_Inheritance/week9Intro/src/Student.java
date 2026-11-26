public class Student extends Person {
	public final String department;
	public final String degree;

	public Student(String name, int id, String department, String degree) {
		super(name, id);
		this.department = department;
		this.degree = degree;
	}

	@Override
	public void display() {
		System.out.println("Name : " + name);
		System.out.println("id:"+id);
		System.out.println("Department : " + department);
		System.out.println("Degree : " + degree);
	}
}