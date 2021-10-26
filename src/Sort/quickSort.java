package Sort;

public class quickSort {
    public static int[] sort(int[] nums, int left, int right) {
        if (left > right) return nums;
        int i = left, j = right, pivot = nums[left];
        while (i < j) {
            while (i < j && pivot <= nums[j]) j--;
            while (i < j && pivot >= nums[i]) i++;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (i != left) {
            nums[left] = nums[i];
            nums[i] = pivot;
        }
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
        return nums;
    }
}
