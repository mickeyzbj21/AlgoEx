package leetcode;

/**
 * 114. Flatten Binary Tree to Linked List
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
// TAG: TreeTraverse, Recursion
public class Question114 {

    // Method 1: Traverse in Pre-Order (Create and Link these Nodes)
    // but the problem want you to flatten the root itself
    private TreeNode result;

    public void flatten1(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        ;
        result = dummy;
        traverse1(root);
        root = dummy.right;
    }

    private void traverse1(TreeNode node) {
        if (node == null) return;
        result.right = new TreeNode(node.val);
        result = result.right;
        traverse1(node.left);
        traverse1(node.right);
    }

    // Method 2: Recur the Definination of it
    public void flatten2(TreeNode root) {
        if (root == null) return;
        flatten2(root.left);
        flatten2(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        // JOT: X TreeNode t = root.right;
        TreeNode t = root;
        while (t.right != null) t = t.right;
        t.right = right;
    }

    public static void main(String[] args) {
        Question114 q = new Question114();
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        root.left = t1;
        TreeNode t2 = new TreeNode(5);
        root.right = t2;
        TreeNode t3 = new TreeNode(3);
        t1.left = t3;
        TreeNode t4 = new TreeNode(4);
        t1.right = t4;
        TreeNode t5 = new TreeNode(6);
        t2.right = t5;
        q.flatten2(root);
    }
}
