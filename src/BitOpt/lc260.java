package BitOpt;

public class lc260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        int mask = xor & (-xor);
        int[] result = new int[2];
        for (int num : nums)
            if ((mask & num) == 0) result[0] ^= num;
            else result[1] ^= num;
        return result;
    }
}

// Solution 2 - HashSet
//        int[] result = new int[2];
//        if (nums.length <= 2) return nums;
//                HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//        if (set.contains(nums[i])) set.remove(nums[i]);
//        else set.add(nums[i]);
//        }
//        int temp = 0;
//        for (int i : set) {
//        result[temp ++] = i;
//        }
//        return result;
