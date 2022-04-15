package leetcode;

import java.util.LinkedList;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
//TAG: BTree
public class QL297 {
    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        String left = serialize(root.left);
        String right = serialize(root.right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s : str) {
            list.add(s);
        }
        TreeNode res = traverse(list);
        return res;
    }

    private TreeNode traverse(LinkedList<String> list) {
        if (list.isEmpty()) return null;
        TreeNode root = null;
        if (list.peekFirst().equals("#")) {
            list.removeFirst();
            return null;
        } else root = new TreeNode(Integer.parseInt(list.removeFirst()));
        root.left = traverse(list);
        root.right = traverse(list);
        return root;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, -1, -1, 4, 5};
        TreeNode t = BuildTree.construct_binary_tree(test);
        System.out.println();
        QL297 q = new QL297();
        String res = q.serialize(t);
        System.out.println(res);
        TreeNode result = q.deserialize(res);
        System.out.println();

    }
}
