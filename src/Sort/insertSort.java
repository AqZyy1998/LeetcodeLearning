package Sort;

public class insertSort {
    public static int[] sort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums;
        for (int i = 0; i < len; i++) {
            int temp = nums[i]; // min
            int j = i;
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
