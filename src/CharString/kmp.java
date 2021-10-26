package CharString;

import java.util.Scanner;

public class kmp {
    /**
     *
     * @param pat 模式串
     * @return next索引数组
     */
    public static int[] getNext(String pat) {
        int len = pat.length();
        int[] next = new int[len];
        if (pat.length() <= 1) return next;
        int left = 0, right = 1;
        while (right < len)
            if (pat.charAt(left) == pat.charAt(right)) next[right ++] = ++ left;
            else if (pat.charAt(left) != pat.charAt(right) && left != 0) left = next[left - 1];
            else next[right ++] = left;
        return next;
    }

    /**
     *
     * @param str 主串
     * @param pat 模式串
     * @return 如果主串中找到对应的模式串 则返回索引 若没找到对应的 则返回-1
     */
    public static int search(String str, String pat) {
        int[] next = getNext(pat);
        int str_index = 0, pat_index = 0;
        int str_len = str.length(), pat_len = pat.length();
        while (str_index < str_len) {
            if (pat.charAt(pat_index) == str.charAt(str_index)) {
                str_index ++;
                pat_index ++;
            }
            else if (pat.charAt(pat_index) != str.charAt(str_index) && pat_index != 0) pat_index = next[pat_index - 1];
            else str_index ++;

            if (pat_index == pat_len) return str_index - pat_index;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("主串：");
        String str = scanner.nextLine();
        System.out.print("模式串：");
        String pat = scanner.nextLine();
        int result = search(str, pat);
        System.out.println(result);
    }
}
