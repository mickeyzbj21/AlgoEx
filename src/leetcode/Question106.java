package leetcode;

import java.util.HashMap;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */

public class Question106 {

    // Method 1: (Decrease and Conquer) Decompose into small problem: Tree Root = Left+ Right
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length - 1,
                postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree1(int[] in, int inS, int inE, int[] post, int poS, int poE) {
        if (inS > inE) return null;
        int rootVal = post[poE];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for (int a : in) {
            if (a == rootVal) break;
            index++;
        }
        int leftsize = index - inS;
        root.left = buildTree1(in, inS, index - 1,
                post, poS, poS + leftsize - 1); //TIP: The InOrder start is based on index
        root.right = buildTree1(in, index + 1, inE,
                post, poS + leftsize, poE - 1);
        return root;
    }


    // Method 2: (Decrease and Conquer WITH HASHMAP) Decompose into small problem: Tree Root = Left+ Right
    private HashMap<Integer, Integer> hm;

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            // find the index quickly(don't need to find every time in the recursion)
            hm.put(inorder[i], i);
        }
        return buildTree2(inorder, 0, inorder.length - 1,
                postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree2(int[] in, int inS, int inE, int[] post, int poS, int poE) {
        if (inS > inE) return null;
        int rootVal = post[poE];
        TreeNode root = new TreeNode(rootVal);
        // find the index quickly(don't need to find every time in the recursion)
        int index = hm.get(rootVal);
        int leftsize = index - inS;
        root.left = buildTree2(in, inS, index - 1,
                post, poS, poS + leftsize - 1); //TIP: The InOrder start is based on index
        root.right = buildTree2(in, index + 1, inE,
                post, poS + leftsize, poE - 1);
        return root;
    }


    public static void main(String[] args) {
        Question106 q = new Question106();
        int[] in = {5, 2, 6, 4, 7, 1, 8, 3, 9};
        int[] post = {5, 6, 7, 4, 2, 8, 9, 3, 1};
//        int[] in = {9,3,15,20,7};
//        int[] post = {9,15,7,20,3};
        TreeNode root = q.buildTree2(in, post);
        System.out.println();
    }
}
