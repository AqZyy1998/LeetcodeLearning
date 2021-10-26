package Sort;

public class mergeSort {
    public static void sort(int[] nums, int left, int right, int[] copyNums) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, copyNums);
            sort(nums, mid + 1, right, copyNums);
            merge(nums, left, right, mid, copyNums);
        }
    }

    public static void merge(int[] nums, int left, int right, int mid, int[] copyNums) {
        if (left > right) return;
        int i = left, j = mid + 1, index = 0; // i 左边起始点 j 右边起始点
        // 下面三个while用于按序合并两个数组
        while (i <= mid && j <= right)
            if (nums[i] <= nums[j]) copyNums[index ++] = nums[i ++];
            else copyNums[index ++] = nums[j ++];
        while (i <= mid) copyNums[index ++] = nums[i ++];
        while (j <= right) copyNums[index ++] = nums[j ++];
        index = 0;
        int tempLeft = left;
        // 把排序过的放到输出结果里
        while (tempLeft <= right) nums[tempLeft ++] = copyNums[index ++];
    }
}
