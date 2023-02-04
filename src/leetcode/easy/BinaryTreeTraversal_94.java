package leetcode.easy;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal_94 {
    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        travel(root, result);
        return result;
    }

    private static void travel(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        travel(root.left, result);
        result.add(root.val);
        travel(root.right, result);
    }
//    public static List<Integer> postTraversal(leetcode.TreeNode root) {
//        var result = new ArrayList<Integer>();
//        if (root == null) {
//            return result;
//        }
//        travel(root, result);
//        return result;
//    }



    //postOrder(???)
//    public static void travel(leetcode.TreeNode root, List<Integer> result) {
//        result.add(root.val);
//        if (root.left != null) {
//            root = root.left;
//        } else if (root.right != null) {
//            root = root.right;
//        } else {
//            return;
//        }
//
//        travel(root, result);
//    }
}
