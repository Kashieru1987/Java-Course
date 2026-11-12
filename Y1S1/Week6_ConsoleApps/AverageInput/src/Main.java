import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	final Scanner scanner;

	public static void main(String[] args) {
		new Main();
	}

	private Main() {
		scanner = new Scanner(System.in);

		final List<Double> userInput = getInputDoubles();
		final double average = average(userInput);

		System.out.println("Average: " + average);

		scanner.close();
	}

	private List<Double> getInputDoubles() {
		final List<Double> output = new ArrayList<Double>();

		String userInput = "";
		while(true) {
			System.out.print("Number: ");
			userInput = scanner.nextLine();
			if(userInput.equalsIgnoreCase("end"))
				break;

			addIfDouble(output, userInput);
		}
		return output;
	}

	private void addIfDouble(List<Double> output, String userInput) {
		try {
			final Double input = Double.parseDouble(userInput);
			output.add(input);
		} catch (NumberFormatException nfe) {
			throw new RuntimeException(nfe);
		}
	}

	private double average(List<Double> nums) {
		double result = 0;
		for(double num: nums) {
			result += num;
		}
		return result/nums.size();
	}

}