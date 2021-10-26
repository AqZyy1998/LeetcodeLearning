package Sort;

public class selectSort {
    public static int[] sort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums;
        for (int i = 0; i < len - 1; i++) {
            int index = i;
            for (int j = i + 1; j < len; j++)
                if (nums[j] < nums[index]) index = j;
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
