package BST;


import java.util.ArrayList;
import java.util.List;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> ascending=inorderTraversal(root);
        for(int i=0;i<ascending.size()-1;i++){
            if (ascending.get(i)>=ascending.get(i+1)){
                return false;
            }
        }
        return true;
    }
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
}
