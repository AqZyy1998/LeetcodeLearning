package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class lc869 {
    List<Integer> result = new ArrayList<>();
    boolean[] visit;
    public boolean reorderedPowerOf2(int n) {
        if (n <= 0) return false;
        char[] cs = String.valueOf(n).toCharArray();
        Arrays.sort(cs);
        visit = new boolean[cs.length];
        return dfs(cs, 0, 0);
    }

    public boolean dfs(char[] cs, int index, int num) {
        if (index == cs.length) return isPowerOf2(num);
        for (int i = 0; i < cs.length; i++) {
            if ((num == 0 && cs[i] == '0') || visit[i] || (i > 0 && !visit[i - 1] && cs[i] == cs[i - 1])) continue;
            visit[i] = true;
            if (dfs(cs, index + 1, num * 10 + cs[i] - '0')) return true;
            visit[i] = false;
        }
        return false;
    }

    public boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }
}
