package leetcode;

/**
 * 617. Merge Two Binary Trees
 * You are given two binary trees root1 and root2.
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 */
// TAG: BTree
public class QL617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return root1;
        else if (root1 == null) return root2;
        else if (root2 == null) return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = BuildTree.construct_binary_tree(new int[]{1, 3, 2, 5});
        TreeNode root2 = BuildTree.construct_binary_tree(new int[]{2, 1, 3, -1, 4, -1, 7});
        QL617 q = new QL617();
        TreeNode res = q.mergeTrees(root1, root2);
    }
}
