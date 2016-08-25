import static java.lang.System.out;
public class BinaryTree{
	Node root;
	
	public BinaryTree(){
		root=null;
	}
	
	private class Node{
		Node left;
		Node right;
		int data;
		
		Node(int num){
			this.left=null;
			this.right=null;
			this.data=num;
		}
	}
			
	void addNode(Node node, int data){
		if(root==null){
			root=new Node(data);
		}else{
			if(data < node.data){
				if(node.left!=null){
					addNode(node.left, data);
				}else{
					node.left=new Node(data);
				}
			}else{
				if(node.right!=null){
					addNode(node.right, data);
				}else{
					node.right=new Node(data);
				}
			}
		}
	}
	
	public static void preOrderRecur(Node root){
		if(root==null){
			return;
		}
		out.print(root.data+" ");
		preOrderRecur(root.left);
		preOrderRecur(root.right);
	}
	public static void inOrderRecur(Node root){
		if(root==null){
			return;
		}
		inOrderRecur(root.left);
		out.print(root.data+" ");
		inOrderRecur(root.right);
	}
	public static void posOrderRecur(Node root){
		if(root==null){
			return;
		}
		posOrderRecur(root.left);
		posOrderRecur(root.right);
		out.print(root.data+" ");
	}
		
			
	public static void main(String[] args){
		int[] a={12,4,11,13,45,21,6};	
		BinaryTree bTree=new BinaryTree();
		for(int i=0,len=a.length;i<len;i++){
			bTree.addNode(bTree.root,a[i]);
		}
		out.print("preOrder: ");
		preOrderRecur(bTree.root);	
		out.println();
		out.print("inOrder: ");
		inOrderRecur(bTree.root);	
		out.println();
		out.print("posOrder: ");
		posOrderRecur(bTree.root);	
		out.println();
	}
}
