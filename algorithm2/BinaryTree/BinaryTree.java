import static java.lang.System.out;
import java.lang.Math;
import java.util.Stack;
import java.util.Random;
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
	public static void preOrderUnRecur(Node root){
		if(root==null){
			return;
		}
		Stack<Node> stack=new Stack<Node>();
		stack.push(root);
		while(!stack.empty()){
			Node node=stack.pop();
			out.print(node.data+" ");
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
	}
	public static void inOrderRecur(Node root){
		if(root==null){
			return;
		}
		inOrderRecur(root.left);
		out.print(root.data+" ");
		inOrderRecur(root.right);
	}
	public static void inOrderUnRecur(Node root){
		if(root==null){
			return;
		}
		Stack<Node> stack=new Stack<Node>();
		while(!stack.empty() ||	root!=null){
			if(root!=null){
				stack.push(root); 
				root=root.left;	
			}else{
				root=stack.pop();
				out.print(root.data+" ");
				root=root.right;
			}	
		}
	}
	public static void posOrderRecur(Node root){
		if(root==null){
			return;
		}
		posOrderRecur(root.left);
		posOrderRecur(root.right);
		out.print(root.data+" ");
	}
	public static void posOrderUnRecur(Node root){
		if(root==null){
			return;
		}
		Stack<Node> stack=new Stack<Node>();
		stack.push(root);
		Node poped=root;
		Node top=null;
		while(!stack.empty()){
			top=stack.peek();
			if(top.left!=null && poped!=top.left && poped!=top.right){
				stack.push(top.left);
			}else if(top.right!=null && poped!=top.right){
				stack.push(top.right);
			}else{
				out.print(top.data+" ");
				stack.pop();
				poped=top;	
			}
		}
	}
	public static int depth(Node node){
		if(node==null)
			return 0;
		//int ldepth=depth(node.left);
		//int rdepth=depth(node.right);
		//return (ldepth>rdepth)?(ldepth+1):(rdepth+1);
		return Math.max(depth(node.left)+1, depth(node.right)+1);
	}
	//------------------------ Print Edge Node -------------------------------
	public static void setEdgeMap(Node root, Node[][] edgeMap, int l){
		if(root==null)
			return;
		edgeMap[l][0]=edgeMap[l][0]==null?root:edgeMap[l][0];
		edgeMap[l][1]=root;
		setEdgeMap(root.left, edgeMap, l+1);
		setEdgeMap(root.right, edgeMap, l+1);
	}
	public static void printLeafNotInMap(Node root, Node[][] edgeMap, int l){
		if(root==null)
			return;
		if(root.left==null && root.right==null && root!=edgeMap[l][0] && root!=edgeMap[l][1])
			out.print(root.data+" ");
		printLeafNotInMap(root.left, edgeMap, l+1);
		printLeafNotInMap(root.right, edgeMap, l+1);
	}
	public static void printEdge1(Node root){
		if(root==null)
			return;
		int d=depth(root);
		Node[][] edgeMap=new Node[d][2];
		setEdgeMap(root, edgeMap, 0);			
		for(int i=0;i<d;i++)
			out.print(edgeMap[i][0].data+" ");	
		printLeafNotInMap(root, edgeMap, 0);	
		for(int i=d-1;i>=0;i--)
			out.print(edgeMap[i][1].data+" ");	
		
	}
	//---------------------------- PrintInOrder ------------------------------	
	public static void printInOrder(Node root, String to, int node_len, int height){
		if(root==null)
			return;
		printInOrder(root.right, "v", node_len, height+1);
		
		String node_pre=to+root.data+to;
		int l=node_pre.length();
		int l1=(node_len-l)/2;
		int l2=node_len-l-l1;
		String node=getSpace(l1)+node_pre+getSpace(l2);
		out.println(getSpace(height*node_len)+node);
		printInOrder(root.left, "^", node_len, height+1);
	}
	public static String getSpace(int len){
		StringBuffer space=new StringBuffer(" ");
		StringBuffer buf=new StringBuffer("");
		for(int i=0;i<len;i++)
			buf.append(space);
		return buf.toString();
	}
	//------------------------------------------------------------------------	
	public static void main(String[] args){
		//int[] a={12,4,11,13,45,21,6};	
		BinaryTree bTree=new BinaryTree();
		Random r=new Random();
		for(int i=0,len=20;i<len;i++){
			int tmp=r.nextInt(100);
			out.print(tmp+" ");
			bTree.addNode(bTree.root, tmp);
		}
		out.println();
		//out.print("preOrder: ");
		//preOrderRecur(bTree.root);	
		//out.println();
		//out.print("preOrder UnRecur: ");
		//preOrderUnRecur(bTree.root);	
		//out.println();
		//out.print("inOrder: ");
		//inOrderRecur(bTree.root);	
		//out.println();
		//out.print("inOrder UnRecur: ");
		//inOrderUnRecur(bTree.root);	
		//out.println();
		//out.print("posOrder: ");
		//posOrderRecur(bTree.root);	
		//out.println();
		//out.print("posOrder UnRecur: ");
		//posOrderUnRecur(bTree.root);	
		//out.println();
		//out.println(depth(bTree.root));
		printEdge1(bTree.root);
		out.println();
		printInOrder(bTree.root,"H",7,0);
		out.println();
	}
}
