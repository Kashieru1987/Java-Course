import java.util.HashSet;
import java.util.Set;

public class Main {

    public Main() {
        System.out.println(test("abcabcbb"));
        System.out.println(test("bbbbb"));
        System.out.println(test("pwwkew"));
        System.out.println(test("1R1T7"));
    }

    public String test(String input) {
        int output = lengthOfLongestSubstring(input);
        return "Input: " + input + " Output: " + output;
    }

    // This is gonna use a sliding window
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) //edge case that'll probably show up
            return s.length();

        int longestLength = 0;

        Set<Character> seenCharacters = new HashSet<Character>();
        int left = 0;
        int right = 1;

        seenCharacters.add(s.charAt(left));

        while(right < s.length()) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);


            while(seenCharacters.contains(rightChar)) {
                System.out.println(seenCharacters);
                System.out.println(rightChar + " seen in seenCharacters!");
                System.out.println("removed " + leftChar);
                seenCharacters.remove(leftChar);
                left++;
                leftChar = s.charAt(left);
            }

            seenCharacters.add(rightChar);
            right++;
            int currentLength = right - left;
            longestLength = Math.max(currentLength, longestLength);
            System.out.println(longestLength + " " + leftChar + " " + rightChar);
        }

        return longestLength;
    }

    public static void main(String[] args) {
        new Main();
    }

}
