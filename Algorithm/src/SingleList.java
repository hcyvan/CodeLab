class Node{
	public int value;
	public Node next;
	public Node(int data) {
		value = data;
		next = null;
	}
}

public class SingleList{
	static Node initSingleList(int[] array){
		int len=array.length;
		if(len==0)
			return null;
		Node head=new Node(array[0]);
		Node p=head;
		for(int i=1;i<len;i++){
			Node tmp=new Node(array[i]);
			p.next=tmp;
			tmp.next=null;	
			p=p.next;
		}
		return head;
	}
	static Node initCircleList(int[] array) {
		Node head=initSingleList(array);
		if (head==null ||head.next==null){
			return head;
		}
		Node p=head;
		while (p.next!=null) {
			p=p.next;
		}
		p.next=head;
		return head;
	}
	static Node reverseSingleList(Node head){
		Node pre=null;
		while(head!=null){
			Node next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}
	static boolean isCircleList(Node head) {
		if (head==null||head.next==null){
			return false;
		}
		Node p1=head, p2=head.next;
		while (p1!=p2) {
			if(p2==null||p2.next==null){
				return false;
			}
			p2=p2.next.next;
			p1=p1.next;
		}
		return true;
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
		System.out.println("1. Init single List");
		Node head=initSingleList(a);
		printList(head);
		System.out.println("2. Reverse single List");
		Node head_rev=reverseSingleList(head);
		printList(head_rev);
		System.out.println("3. Init circle List");
		Node head_circle=initCircleList(a);
		System.out.println("4. Judge circle List");
		System.out.println(isCircleList(head_circle));
		System.out.println(isCircleList(head));
	}
}
