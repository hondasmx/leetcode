public class SymmetricTree_101 {
    public static void main(String[] args) {


    }

    public boolean isSymmetric(TreeNode root) {
        var left = root.left;
        var right = root.right;
        return isSymmetric(left, right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
