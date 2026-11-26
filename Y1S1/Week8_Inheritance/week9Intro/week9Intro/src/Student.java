public class Student {
	public final String name;
	public final int id;
	public final String department, degree;

	public Student(String name, int id, String department, String degree) {
		this.name = name;
		this.id = id;
		this.department = department;
		this.degree = degree;
	}

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("id:"+id);
		System.out.println("Department : " + department);
		System.out.println("Degree : " + degree);
	}
}