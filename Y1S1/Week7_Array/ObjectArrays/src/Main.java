import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	final Scanner scanner;
	final List<Item> itemList;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		scanner = new Scanner(System.in);
		itemList = new ArrayList<Item>();

		while(true) {
			System.out.print("Enter item name or \"stop\": ");
			final String userInput = scanner.nextLine();

			if(userInput.equalsIgnoreCase("stop"))
				break;

			final String itemName = userInput;

			System.out.print("Enter number of item: ");
			final int itemCount = Integer.parseInt(scanner.nextLine());

			System.out.print("Enter the price of the item: ");
			final double itemPrice = Double.parseDouble(scanner.nextLine());

			itemList.add(new Item(itemName, itemCount, itemPrice));
		}

		for(final Item item : itemList) {
			System.out.println(item);
		}

		scanner.close();
	}

}
