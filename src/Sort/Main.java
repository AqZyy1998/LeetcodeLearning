package Sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        String method = scanner.next();
        int[] result = new int[len];
        switch (method) {
            case "bubble" -> result = bubbleSort.sort(nums);
            case "select" -> result = selectSort.sort(nums);
            case "insert" -> result = insertSort.sort(nums);
            case "shell" -> result = shellSort.sort(nums);
            case "merge" -> {
                mergeSort.sort(nums, 0, len - 1, new int[len]);
                result = nums;
            }
            case "quick" -> result = quickSort.sort(nums, 0, len - 1);
            case "heap" -> result = heapSort.sort(nums);
            default -> {
                Exception e = new Exception("Wrong Input of method");
                e.printStackTrace();
            }
        }
        for (int num : result) System.out.println(num);
    }
}
