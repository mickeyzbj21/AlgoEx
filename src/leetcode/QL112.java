package leetcode;

/**
 * 112. Path Sum
 * - Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals targetSum.
 */
// TAG: BTree, Path
public class QL112 {

    int sum = 0;
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return flag;
    }

    private void traverse(TreeNode node, int targetSum) {
        if (node == null) return;
        // Touch the Node (Before Traverse)
        sum += node.val;

        // JOT: IF left,right ==null, it means the NODE is a LEAF
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                flag = true;
            }
        }
        // Traversing
        traverse(node.left, targetSum);
        traverse(node.right, targetSum);
        // Leave the Node (After Traverse)
        sum -= node.val;

    }

    public static void main(String[] args) {
        //TreeNode root1 = BuildTree1.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        //TreeNode root1 = BuildTree1.buildTree(new Integer[]{1, 2});
        TreeNode root1 = BuildTree1.buildTree(new Integer[]{1, 2, null, 3, null, 4, null, 5, null, null});
        QL112 q = new QL112();
        boolean res = q.hasPathSum(root1, 6);
        System.out.println(res);
    }
}
