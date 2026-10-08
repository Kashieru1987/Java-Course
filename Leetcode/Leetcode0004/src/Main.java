public class Main {
    public Main() {

        System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int totalLength = nums1.length + nums2.length;
        final boolean isInbetweenValues = totalLength % 2 == 0;

        int median = -1;

        int midPointer = totalLength/2 + 1;
        int totalPointer = 0;
        int pointer1 = 0;
        int pointer2 = 0;

        double previousValue = 0;
        double currentValue = 0;
        while(true) {
            if(nums1[pointer1] > nums2[pointer2]) {
                currentValue = nums1[pointer1];
                if(totalPointer >= midPointer) {
                    return isInbetweenValues ? (currentValue + previousValue)/2: currentValue;
                }
                totalPointer++;
                pointer1++;
                previousValue = currentValue;
            } else {
                currentValue = nums2[pointer2];
                if(totalPointer >= midPointer) {
                    return isInbetweenValues ? (currentValue + previousValue)/2: currentValue;
                }
                totalPointer++;
                pointer2++;
                previousValue = currentValue;
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
