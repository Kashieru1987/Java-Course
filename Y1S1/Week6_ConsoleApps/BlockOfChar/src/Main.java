public class Main {
	final int width = 7;
	final int height = 4;
	final char character = '*';

	public static void main(String[] args) {
		new Main();
	}

	private Main() {
		printBlockOfChar(width, height, character);
	}

	private void printBlockOfChar(int width, int height, char character) {
		for(int i = 0; i < height; i++) {
			printRowOfChar(width, character);
		}
	}

	private void printRowOfChar(int width, char character) {
		for(int i = 0; i < width; i++) {
			System.out.print(character);
		}
		System.out.println();
	}

}