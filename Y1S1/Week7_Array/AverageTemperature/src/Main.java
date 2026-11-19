import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	final Scanner scanner;

	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		scanner = new Scanner(System.in);

		final List<Double> temperatures = new ArrayList<Double>();
		while(true) {
			System.out.print("Enter temperature or \"-99\" to stop: ");
			final double userInputDouble = Double.parseDouble(scanner.nextLine());

			if(userInputDouble == -99)
				break;

			temperatures.add(userInputDouble);
		}

		System.out.println("Average: " + getAverage(temperatures));

		scanner.close();
	}

	public double getAverage(List<Double> nums) {
		double total = 0;
		for(Double num : nums) {
			total += num;
		}
		return total/nums.size();
	}

}