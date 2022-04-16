package leetcode;

/**
 * 230. Kth Smallest Element in a BST
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
//TAG: Tree, BSTree
public class QL230 {

    int i = 1;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    int result = 0;
    boolean flag = true;

    private void traverse(TreeNode node, int k) {
        if (flag) {
            if (node == null) return;
            traverse(node.left, k);
            if (i == k) {
                result = node.val;
                // JOT: Use this flag, when finding the kth smallest num, quicken the return process
                flag = false;
                i++;
                return;
            } else i++;
            traverse(node.right, k);
        } else {
            return;
        }
    }


    public static void main(String[] args) {
        int[] tArr = {3, 1, 4, -1, 2};
        TreeNode root = BuildTree.construct_binary_tree(tArr);
        QL230 q = new QL230();
        int res = q.kthSmallest(root, 1);
        System.out.println(res);
    }
}
