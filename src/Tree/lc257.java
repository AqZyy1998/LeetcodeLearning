package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯+前序遍历
 * 妙处在于String.join()就不用考虑->在头尾是否存在的问题 直接把每个元素用->连起来了
 */

public class lc257 {
    List<String> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return result;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) result.add(String.join("->", path));
        traverse(root.left);
        traverse(root.right);
        path.removeLast();
    }
}
