package leetcode;

import java.util.*;

/**
 * 515. Find Largest Value in Each Tree Row
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 * <p>
 * Example 1:
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 * <p>
 * Input: root = [1,2,3]
 * Output: [1,3]
 * <p>
 * Constraints:
 * The number of nodes in the tree will be in the range [0, 104].
 * -231 <= Node.val <= 231 - 1
 */
// TAG: BST
public class Question515 {

    // Method : to Use BST to find the max in each level
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sz = queue.size();
        while (!queue.isEmpty()) {
            int max = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (i == 0) max = node.val; // TIP: the val might be negative
                max = Math.max(node.val, max);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(max);
            sz = queue.size();
        }
        return result;
    }

    public static void main(String[] args) {
        Question515 q = new Question515();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t3;
        t1.right = t2;
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(9);
        t3.left = t4;
        t3.right = t5;
        t2.right = t6;
        List a = q.largestValues(t1);
        System.out.println(Arrays.toString(a.toArray()));
    }


}
