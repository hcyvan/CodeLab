package BST;

class BSTNode<T>{
    BSTNode left;
    BSTNode right;
    T data;
    BSTNode(T key){
        this.left=null;
        this.right=null;
        this.data=key;
    }
}
public class BSTree<T extends Comparable>{
    BSTNode root;
    public BSTree(){
        root=null;
    }

    static <T extends Comparable> BSTNode<T> addNote(BSTNode<T> root,T key) {
        if (root==null) {
            root=new BSTNode<T>(key);
        } else {
            if (key.compareTo(root.data) < 0) {
                if (root.left!=null){
                    addNote(root.left, key);
                } else {
                    root.left=new BSTNode<T>(key);
                }
            } else {
                if (root.right!=null) {
                    addNote(root.right, key);
                } else {
                    root.right=new BSTNode<T>(key);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        BSTree<Integer> r = new BSTree<Integer>();
        BSTNode<Integer> root= r.addNote(null, 5);
        r.addNote(root, 2);
        r.addNote(root, 7);
        r.addNote(root, 1);
        r.addNote(root, 3);
    }
}
