package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 257. Binary Tree Paths
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * A leaf is a node with no children.
 */
// TAG: BTree, Path
public class QL257 {

    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return list;
        Stack<Integer> stack = new Stack<>();
        traverse(root, stack);
        return list;
    }
    private void traverse(TreeNode node, Stack<Integer> stack) {
        if (node == null) return;
        // JOT 1: Before 
        stack.push(node.val);
        // JOT 2: Critical Logic
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : stack) {
                sb.append(i);
                sb.append("->");
            }
            list.add(sb.substring(0, sb.length() - 2));
        }
        // JOT 3: Traverse
        traverse(node.left, stack);
        traverse(node.right, stack);
        // JOT 4: After
        stack.pop();
    }


    public static void main(String[] args) {
        TreeNode root = BuildTree1.buildTree(new Integer[]{1, 2, 3, null, 5});
        QL257 q = new QL257();
        List l = q.binaryTreePaths(root);
        System.out.println(Arrays.toString(l.toArray()));
    }
}
