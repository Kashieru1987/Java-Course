import java.util.Scanner;

public class ArrayEvenNumbers {

	final Scanner scanner;

	public static void main(String[] args) {
		new ArrayEvenNumbers();
	}

	public ArrayEvenNumbers() {
		scanner = new Scanner(System.in);

		// get numbers
		System.out.print("Enter amount of numbers: ");
		final int numCount = Integer.parseInt(scanner.nextLine());

		// init array
		final int[] nums = new int[numCount];
		for (int i = 0; i < nums.length; i++) {
			System.out.print("Enter number " + i + ": ");
			nums[i] = Integer.parseInt(scanner.nextLine());
		}

		// output even numbers in array
		System.out.println();
		for(int num : nums) {
			if(num % 2 == 1)
				continue;
			System.out.println(num);
		}

		scanner.close();
	}
}
