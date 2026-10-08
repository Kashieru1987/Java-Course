public class Main {

    public Main() {
        System.out.println(test("abcabcbb"));
        System.out.println(test("bbbbb"));
        System.out.println(test("pwwkew"));
    }

    public String test(String input) {
        int output = lengthOfLongestSubstring(input);
        return "Input: " + input + " Output: " + output;
    }

    // This is gonna use a sliding window
    public int lengthOfLongestSubstring(String s) {



        return -1;
    }

    public static void main(String[] args) {
        new Main();
    }

}
