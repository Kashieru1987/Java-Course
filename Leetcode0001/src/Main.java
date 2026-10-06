import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

    public Main() {
        System.out.println(test(9, 2, 7, 11, 15));
        System.out.println(test(6, 3, 2, 4));
        System.out.println(test(6, 3, 3));
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> dupeMap = new HashMap<Integer, Integer>(); //any more dupes are irrelevant, since only adding two values

        // add all nums
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (currentNum < target)
                continue;
            if(numMap.containsKey(currentNum))
                dupeMap.put(currentNum, i);
            numMap.putIfAbsent(currentNum, i);
        }

        List<Integer> numList = new ArrayList<Integer>(numMap.keySet());
        List<Integer> dupeList = new ArrayList<Integer>(dupeMap.keySet());
        for(int i = 0; i < numList.size(); i++) {
            int currentValue = numList.get(i);
            int wantedValue = target - currentValue;

            List<Integer> searchList = numList;
            if(currentValue == wantedValue)
                if(dupeMap.containsKey(currentValue))
                    return new int[] {numMap.get(currentValue), dupeMap.get(currentValue)};

            if(numMap.containsKey(wantedValue)) {
                return new int[] {numMap.get(currentValue), numMap.get(wantedValue)};
            }

        }

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