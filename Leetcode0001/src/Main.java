public class Main {

    public Main() {
        System.out.println(test(9, 2, 7, 11, 15));
        System.out.println(test(6, 3, 2, 4));
        System.out.println(test(6, 3, 3));
    }

    public int[] twoSum(int[] nums, int target) {

        return null;
    }

    public String test(int target, int... nums) {
        int[] output = twoSum(nums, target);

        if(output == null)
            return "-1";

        return "[" + output[0] + ", " + output[1] + "]";
    }

    public static void main(String[] args) {
        new Main();
    }
}