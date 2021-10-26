package Sort;

public class bubbleSort {
    public static int[] sort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums;
        for (int i = 0; i < len - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < len - 1 - i; j++)
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            if (flag) break; // 表明本轮已经排序正确，提前结束排序
        }
        return nums;
    }
}
