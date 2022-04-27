package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 113. Path Sum II
 * - Given the root of a binary tree and an integer targetSum, return all <u>root-to-leaf paths</u> where the sum of the node values in the path equals targetSum.
 * - A root-to-leaf path is a path starting from the root and ending at any leaf node.
 * - A leaf is a node with no children.
 * - Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * - Output:  [ [5,4,11,2] , [5,8,4,5] ]
 */
// TAG: BTree, Path
public class QL113 {
    int sum = 0;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Stack<Integer> list = new Stack<>();
        traverse(root, targetSum, list);
        return res;
    }

    private void traverse(TreeNode root, int targetSum, Stack stack) {
        if (root == null) return;
        // JOT 1: Before Traverse: TWO parameters to maintain
        sum += root.val;
        stack.push(root.val);

        // JOT 2: IF-Condition(The Logic)
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(stack);
                res.add(tmp);
            }
        }
        // JOT 3: Traverse
        traverse(root.left, targetSum, stack);
        traverse(root.right, targetSum, stack);

        // JOT 4: After Traverse: TWO parameters to maintain
        sum -= root.val;
        stack.pop();
    }

    public static void main(String[] args) {
        //TreeNode root1 = BuildTree1.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        //TreeNode root1 = BuildTree1.buildTree(new Integer[]{1, 2});
        //TreeNode root1 = BuildTree1.buildTree(new Integer[]{1,2,null,3,null,4,null,5,null,null});
        TreeNode root1 = BuildTree1.buildTree(new Integer[]{1, -2, -3, 1, 3, -2, null, -1});
        QL113 q = new QL113();
        List res = q.pathSum(root1, 2);
        System.out.println(Arrays.toString(res.toArray()));
    }

}
