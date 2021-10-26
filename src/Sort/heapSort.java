package Sort;

public class heapSort {
    public static int[] sort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums;
        buildMaxHeap(nums, len);
        for (int i = len - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            len --;
            sink(nums, 0, len);
        }
        return nums;
    }

    public static void buildMaxHeap(int[] nums, int len) {
        for (int i = (len / 2); i >= 0; i--) {
            sink(nums, i, len);
        }
    }

    public static void sink(int[] nums, int index, int len) {
        int max = index, left = 2 * index + 1, right = 2 * index + 2;
        if (left < len && nums[left] > nums[max]) max = left;
        if (right < len && nums[right] > nums[max]) max = right;
        if (max != index) {
            int temp = nums[max];
            nums[max] = nums[index];
            nums[index] = temp;
            sink(nums, max, len);
        }
    }
}
