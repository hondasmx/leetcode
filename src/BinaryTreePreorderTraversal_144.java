import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */

public class BinaryTreePreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        travel(result, root);
        return result;
    }

    private static void travel(List<Integer> result, TreeNode node) {
        if (node == null) return;

        result.add(node.val);
        var right = node.right;
        var left = node.left;
        travel(result, left);
        travel(result, right);
    }
}
