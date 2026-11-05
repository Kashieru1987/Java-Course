public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		int[] nums = new int[] {1, 3, 5, 6};
		System.out.println("ans: " + searchInsert(nums, 5));
		System.out.println("ans: " + searchInsert(nums, 2));
		System.out.println("ans: " + searchInsert(nums, 7));
	}

	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while(left <= right) {
			final int middle = (left + right) / 2;
//			System.out.println(left + " " + right + " " + middle + " " + nums[middle]);
			if(nums[middle] == target)
				return middle;
			if(nums[middle] < target) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		right = Math.max(right, 0);
		left = Math.min(nums.length - 1, left);


		return nums[left] < target ? left + 1 : left;
	}

}