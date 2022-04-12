package leetcode;

import java.util.HashMap;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 * Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
 * If there exist multiple answers, you can return any of them.
 * <p>
 * Example 1:
 * Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * <p>
 * Example 2:
 * Input: preorder = [1], postorder = [1]
 * Output: [1]
 * <p>
 * Constraints:
 * 1 <= preorder.length <= 30
 * 1 <= preorder[i] <= preorder.length
 * All the values of preorder are unique.
 * postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length
 * All the values of postorder are unique.
 * It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.
 */

public class Question889 {


    private HashMap<Integer, Integer> hppr;
    private HashMap<Integer, Integer> hppo;

    public TreeNode constructFromPrePost1(int[] preorder, int[] postorder) {
        hppr = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            hppr.put(preorder[i], i);
        }
        hppo = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            hppo.put(postorder[i], i);
        }
        return buildTree1(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree1(int[] pre, int preS, int preE, int[] post, int postS, int postE) {
        // TIP: Neglect preE<preS, 默认有左子树
        if (postE == postS) return new TreeNode(post[postE]);
        if (postE < postS) return null;
        // TIP: Neglect postE<postS, 默认有右子树
        // if(preE==preS)  return new TreeNode(pre[preS]);
        // if(preE<preS) return null;
        TreeNode root = new TreeNode(pre[preS]);
        int index1 = hppo.get(pre[preS + 1]);
        int index2 = hppr.get(post[postE - 1]);
        root.left = buildTree1(pre, preS + 1, index2 - 1, post, postS, index1);
        root.right = buildTree1(pre, index2, preE, post, index1 + 1, postE - 1);
        return root;
    }

    public TreeNode constructFromPrePost2(int[] preorder, int[] postorder) {
        hppo = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            hppo.put(postorder[i], i);
        }
        return buildTree2(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree2(int[] pre, int preS, int preE, int[] post, int postS, int postE) {
        if (preE < preS) return null; // 为空
        if (preE == preS) return new TreeNode(pre[preS]); // 为唯1
        int rootVal = pre[preS];
        TreeNode root = new TreeNode(rootVal);
        // JOT 0: IMPORTANT: 默认左子树存在，通过此节点计算(距离)划分左右子树
        int nodeVal = pre[preS + 1]; // TIP: 默认有左子树
        int index = hppo.get(nodeVal);
        int LF = index - postS + 1; // TIP: LF= leftsize(count) NOT index 如0,1,2 size=3 Max(index)=2
        // JOT 1: the leftTree exists
        root.left = buildTree2(pre, preS + 1, preS + LF,
                post, postS, index);
        root.right = buildTree2(pre, preS + LF + 1, preE,
                post, index + 1, postE - 1);
        // XWRONG JOT 2: the leftTree X exists, start with rightTree
        // 2方法不确定，Root可能没有左子树，但又子树的每个节点同样也都有2种可能
//        root.left = buildTree2(pre, preS + LF + 1, preE,
//                post, index + 1, postE - 1);
//        root.right = buildTree2(pre, preS + 1, preS + LF,
//                post, postS, index);
        return root;
    }

    // TODO: X
    public TreeNode constructFromPrePost3(int[] preorder, int[] postorder) {
        hppr = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            hppr.put(preorder[i], i);
        }
        return buildTree3(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree3(int[] pre, int preS, int preE, int[] post, int postS, int postE) {
        if (postE < postS) return null; // 为空
        if (postE == postS) return new TreeNode(post[postE]); // 为唯1
        int rootVal = post[postE];
        TreeNode root = new TreeNode(rootVal);
        int nodeVal = post[postE - 1]; // 默认没有左子树/默认开始右子树
        int index = hppr.get(nodeVal);
        int LF = index - preS;
        root.left = buildTree3(pre, preS + 1, index - 1,
                post, postS, postS + LF - 1);
        root.right = buildTree3(pre, index + 1, preE,
                post, postS + LF, postE - 1);
        return root;
    }


    public static void main(String[] args) {
        Question889 q = new Question889();
//        int[] pre = {1,2,4,5,3,6,7};
//        int[] post = {4,5,2,6,7,3,1};
//        int[] pre = {1,2,4,5,8,9,3,6,7};
//        int[] post = {4,8,9,5,2,6,7,3,1};
        int[] pre = {2, 1, 3};
        int[] post = {3, 1, 2};
        TreeNode root = q.constructFromPrePost3(pre, post);
        System.out.println();
    }
}
