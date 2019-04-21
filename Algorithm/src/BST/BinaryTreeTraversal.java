package BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) {
            return new ArrayList<>();
        }
        List<Integer> l=inorderTraversal(root.left);
        List<Integer> r=inorderTraversal(root.right);
        l.add(root.val);
        l.addAll(r);
        return l;
    }
    public List<Integer> inorderTraversalIterating(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode curr=root;
        while (curr!=null || !stack.isEmpty()) {
            while (curr!=null) {
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            ret.add(curr.val);
            curr=curr.right;
        }
        return ret;
    }
}
