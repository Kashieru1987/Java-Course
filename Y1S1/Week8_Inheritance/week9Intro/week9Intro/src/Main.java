public class Main {

	public static void main(String[] args) { //program starts here
		new Main();
	}

	public Main() {
		final Student student = new Student("Stu",10,"Computing","Cyber");
		student.display();

		final Academic ali = new Academic("Ali",99,"Programming");
		ali.display();
	}

}