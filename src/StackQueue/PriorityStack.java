package StackQueue;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class PriorityStack {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 <= 0 || len2 <= 0) return null;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = len2 - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums2[i]) stack.pop();
            if (stack.empty()) map.put(nums2[i], -1);
            else map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }
        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) result[i] = map.get(nums2[i]);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input length of nums1: ");
        int len1 = scanner.nextInt();
        System.out.print("Please input nums1 elements: ");
        int[] nums1 = new int[len1];
        for (int i = 0; i < len1; i++) nums1[i] = scanner.nextInt();
        System.out.print("Please input length of nums2: ");
        int len2 = scanner.nextInt();
        System.out.print("Please input nums2 elements: ");
        int[] nums2 = new int[len2];
        for (int i = 0; i < len2; i++) nums2[i] = scanner.nextInt();
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.print("Output: ");
        try{
            for (int i : result) System.out.println(i);
        } catch (Exception e) {
            System.out.print("null");
        }
    }
}
