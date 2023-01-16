public class MaximumDepthOfBinaryTree_104 {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return java.lang.Math.max(left, right) + 1;
        }
    }
}
