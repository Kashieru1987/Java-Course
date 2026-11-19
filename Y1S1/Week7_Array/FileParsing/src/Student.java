import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	public final String name;
	public final double grade;

	public Student(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}

	public static double meanGrade(List<Student> students) {
		double total = 0;

		for(Student student : students) {
			total += student.grade;
		}

		return total/students.size();
	}

	public static int countFailedStudents(List<Student> students, int failThreshold) {
		int total = 0;

		for(Student student : students) {
			double grade = student.grade;
			if(grade < failThreshold)
				total++;
		}

		return total;
	}

	public static double getHighestGrade(List<Student> students) {
		double highest = -1;

		for(Student student : students) {
			highest = Math.max(highest, student.grade);
		}

		return highest;
	}

	public static List<Student> parseStudents(String fileName) {
		final List<Student> studentList = new ArrayList<Student>();
		final Scanner scanner;

		try {
			scanner = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		scanner.nextLine(); // kill header line

		while(scanner.hasNextLine()) {
			String[] elements = scanner.nextLine().split(",");
			final String studentName = elements[0];
			final double studentGrade = Double.parseDouble(elements[1]);
			studentList.add(new Student(studentName, studentGrade));
		}

		return studentList;
	}


	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", grade=" + grade +
				'}';
	}
}
