import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public Main() {
        ListNode t1 = createList(9, 9, 9, 9, 9, 9, 9);
        ListNode t2 = createList(9, 9, 9, 9);

//        System.out.println(toInt(t1) + " " + toInt(t2));

        ListNode output = addTwoNumbers(t1, t2);
        System.out.println(this.toInt(output));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();

        ListNode num1 = l1;
        ListNode num2 = l2;

        ListNode current = output;
        while(num1 != null || num2 != null) {
            int val1 = num1 != null ? num1.val : 0;
            int val2 = num2 != null ? num2.val : 0;

            current.val = val1 + val2;

            if(current.val >= 10) {
                current.val -= 10;
                if(num1.next == null) {
//                    System.out.println("num1.next was null");
                    num1 = new ListNode(0, new ListNode(0));
                }
                num1.next.val += 1;
            }
//            System.out.println("val1 + val2 = " + val1 + " " + val2);
//            System.out.println("current.val = " + current.val);

            current.next = new ListNode();
            current = current.next;

            if(num1 != null)
                num1 = num1.next;
            if(num2 != null)
                num2 = num2.next;
        }

        current = output;
        while(true) {
            if(current.next.next == null) {
                current.next = null;
                break;
            }
            current = current.next;
        }

        return output;
    }

    public ListNode createList(int... input){
        if(input.length == 0)
            return null;

        int[] nums = reverse(input);

        ListNode output = new ListNode(nums[0]);

        ListNode current = output;
        for(int i = 1; i < nums.length; i++){
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return output;
    }

    public int toInt(ListNode input) {
        if(input == null) {
            return -1;
        }

        List<Integer> outputList = new ArrayList<Integer>();

        ListNode current = input;
        while(current.next != null) {
            outputList.add(current.val);
            current = current.next;
        }
        outputList.add(current.val);

        Collections.reverse(outputList);

        String output = "";

        for(int i = 0; i < outputList.size(); i++) {
            output += outputList.get(i);
        }

        return Integer.parseInt(output);
    }

    public int[] reverse(int[] input) {
        int[] output = new int[input.length];
        int index = 0;
        for(int i = input.length -1; i >= 0; i--) {
            output[i] = input[index];
            index++;
        }
        return output;
    }

    public static void main(String[] args) {
        new Main();
    }
}