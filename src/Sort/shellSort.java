package Sort;

public class shellSort {
    public static int[] sort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums;
        for (int gap = len / 2; gap > 0; gap /= 2)
            for (int i = gap; i < len; i++)
                for (int j = i - gap; j >= 0; j -= gap)
                    if (nums[j] > nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
        return nums;
    }
}
