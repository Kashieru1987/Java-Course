import java.util.List;

public class Main {

	final String fileName = "Y1S1/Week7_Array/FileParsing/grades.csv";

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		final List<Student> students = Student.parseStudents(fileName);
		System.out.println("Mean grade: " + Student.meanGrade(students));
		System.out.println("Failed students: " + Student.countFailedStudents(students, 40));
		System.out.println("Highest grade: " + Student.getHighestGrade(students));
	}

}