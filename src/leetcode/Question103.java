package leetcode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
// TAG: BFS, Tree
public class Question103 {

    // Method 1: backward add
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int levelnum = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode node;
                node = queue.remove(sz - i - 1); // Backward pop
                level.add(node.val);
                if (levelnum % 2 == 0) { // Even Level: Forward add E.g. 2,3(but print 3,2)
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                } else { // Odd Level: Backward add E.g. 7,6,5,4 (but print 4,5,6,7)
                    if (node.right != null) queue.add(node.right);
                    if (node.left != null) queue.add(node.left);
                }
            }
            levelnum++;
            result.add(level);
        }
        return result;
    }

    // Method 2: Firstly, add in level order. (More Clearly)
    //  Then change the values order in each(1/2) level.
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int levelnum = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode node;
                node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (levelnum % 2 != 0) { // Backward Print
                for (int i = 0; i < temp.size() / 2; i++) {
                    int swap = temp.get(i);
                    temp.set(i, temp.get(temp.size() - 1 - i));
                    temp.set(temp.size() - 1 - i, swap);
                }
            }
            levelnum++;
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        Question103 q = new Question103();
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        root.left = t1;
        TreeNode t2 = new TreeNode(3);
        root.right = t2;
        TreeNode t3 = new TreeNode(4);
        t1.left = t3;
        TreeNode t4 = new TreeNode(5);
        t2.right = t4;
        q.zigzagLevelOrder2(root);
        System.out.println();
    }
}
