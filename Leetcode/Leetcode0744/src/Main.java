public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		char[] letters1 = new char[] {'c', 'f', 'j'};
		char[] letters2 = new char[] {'x', 'x', 'y', 'y'};

		System.out.println("ans: " + nextGreatestLetter(letters1, 'a'));
		System.out.println("ans: " + nextGreatestLetter(letters1, 'c'));
		System.out.println("ans: " + nextGreatestLetter(letters2, 'z'));
	}

	public char nextGreatestLetter(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;

		return 'a';
	}

}