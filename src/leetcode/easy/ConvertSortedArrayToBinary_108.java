package leetcode.easy;

import leetcode.TreeNode;

public class ConvertSortedArrayToBinary_108 {

    public static void main(String[] args) {


    }

    //находим средний элемент массива
    //если нет среднего - находим +-1
    //рекурсивно идем дальше
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBst(nums, 0, nums.length - 1);
    }

    private TreeNode createBst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        var mid = (left + right) / 2;
        var root = new TreeNode(nums[mid]);
        root.left = createBst(nums, left, mid - 1);
        root.right = createBst(nums, mid + 1, right);
        return root;
    }

    private TreeNode CreateBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = CreateBST(nums, l, mid - 1);
        root.right = CreateBST(nums, mid + 1, r);
        return root;
    }
}
