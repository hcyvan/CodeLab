public class SingleList{
	class Node{
		public int value;
		public Node next;
		public Node(int data){
			this.value=data;
		}
	}
	
	static Node initSingleList(int[] array){
		int len=array.length;
		if(len==0)
			return null;
		SingleList s=new SingleList();
		Node head=s.new Node(array[0]);
		Node p=head;
		for(int i=1;i<len;i++){
			Node tmp=s.new Node(array[i]);
			p.next=tmp;
			tmp.next=null;	
			p=p.next;
		}
		return head;
	}
	static Node reverseSingleList(Node head){
		Node pre=null;
		Node next=null;
		while(head!=null){
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}
	static void printList(Node head){
		Node p=head;
		while(p!=null){
			System.out.print(p.value+" ");
			p=p.next;
		}
		System.out.println();
	}
			
	public static void main(String[] args){
		int[]a={1,2,3,4};
		Node head=initSingleList(a);
		head=reverseSingleList(head);
		printList(head);
	}
}
