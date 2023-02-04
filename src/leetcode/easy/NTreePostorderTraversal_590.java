package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */

public class NTreePostorderTraversal_590 {

    public List<Integer> postorder(Node root) {
        var result = new ArrayList<Integer>();
        travel(result, root);
        return result;
    }

    private static void travel(List<Integer> result, Node node) {
        if (node == null) return;
        for (Node child : node.children) {
            travel(result, child);
        }
        result.add(node.val);
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
