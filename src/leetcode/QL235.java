package leetcode;

/*
235. Lowest Common Ancestor of a Binary Search Tree
*/
public class QL235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // IF p,q is on the left of root → root.left
        // IF p,q is on the right of root → root.right
        // IF p,q is  q/p<=root<=p/q root is LCA
        if (root == null) return null;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }

    public static void main(String[] args) {

    }
}
