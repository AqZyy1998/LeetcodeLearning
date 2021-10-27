package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc301 {
    int s_len, max, result_len;
    String s_;
    HashSet<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        s_len = s.length();
        s_ = s;
        int left = 0, right = 0;
        for (char c : s.toCharArray())
            if (c == '(') left ++;
            else if (c == ')') right ++;
        max = Math.min(left, right);
        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    public void dfs(int index, String curr, int score) {
        if (score < 0 || score > max) return;
        if (index == s_len) {
            if (score == 0 && curr.length() >= result_len) set.clear();
            result_len = curr.length();
            set.add(curr);
            return;
        }
        char c = s_.charAt(index);
        if (c == '(') {
            dfs(index + 1, curr + index, score + 1);
            dfs(index + 1, curr, score);
        }
        else if (c == ')') {
            dfs(index + 1, curr + index, score + 1);
            dfs(index + 1, curr, score);
        }
        else dfs(index + 1, curr + index, score);
    }
}
