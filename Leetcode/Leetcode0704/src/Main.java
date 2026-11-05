public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		int[] nums = new int[] {-1, 0, 3, 5, 9, 12};
		System.out.println("ans: " + search(nums, 9));
		System.out.println("ans: " + search(nums, 2));
	}

	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int middle = (left + right) / 2;
//			System.out.println(left + " " + right + " " + middle + " " + nums[middle]);
			if(nums[middle] == target)
				return middle;
			if(nums[middle] < target) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}
}