package Sort;

public class exam {
    public static int[] sort(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums;
        for (int gap = (len / 2); gap > 0; gap /= 2)
            for (int i = gap; i < len; i++)
                for (int j = i - gap; j >= 0; j -= gap)
                    if (nums[j] > nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
        return nums;
    }

    public static int[] sort(int[] nums, int left, int right) {
        if (left > right) return nums;
        int i = left, j = right, pivot = nums[left];
        while (i < j) {
            if (i < j && nums[j] >= pivot) j--;
            if (i < j && nums[i] <= pivot) i++;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
        return nums;
    }

    public static void sort(int[] nums, int left, int right, int[] copyNums) {
        if (left > right) return;
        int mid = (left + right) / 2;
        sort(nums, left, mid, copyNums);
        sort(nums, mid + 1, right, copyNums);
        merge(nums, left, right, mid, copyNums);

    }

    public static void merge(int[] nums, int left, int right, int mid, int[] copyNums) {
        if (left > right) return;
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) copyNums[index ++] = (nums[i] <= nums[j]) ? nums[i ++] : nums[j ++];
        while (i <= mid) copyNums[index ++] = nums[i ++];
        while (j <= right) copyNums[index ++] = nums[j ++];
        index = 0;
        int tempLeft = left;
        while (tempLeft <= right) nums[tempLeft ++] = copyNums[index ++];
    }
}
