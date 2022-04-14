package leetcode;

/**
 * 700. Search in a Binary Search Tree
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 * <p>
 * Example 1:
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * Example 2:
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
 */
//TAG: BTree, BST
public class Question700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else if (val < root.val) root = searchBST(root.left, val); // LEFT: val < root.val
        else root = searchBST(root.right, val); // RIGHT: val > root.val
        return root;
    }

    public static void main(String[] args) {
        Question700 q = new Question700();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        //TreeNode t6 = new TreeNode(9);
        t2.left = t4;
        t2.right = t5;
        //t2.right = t6;
        TreeNode a = q.searchBST(t1, 3);
        System.out.println();
    }

}
