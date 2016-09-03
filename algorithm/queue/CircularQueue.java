import static java.lang.System.out;
public class CircularQueue{
	private int [] cqueue;
	private int front;
	private int rear;
	private int maxsize;
	
	public CircularQueue(int maxsize){
		this.cqueue=new int[maxsize];
		this.maxsize=maxsize;
		this.front=0;
		this.rear=0;
	}
	
	public void traverseQueue(){
		int i=this.front;
		while(i%this.maxsize!=this.rear){
			out.print(cqueue[i]+" ");
			i++;	
		}
		out.println();
	}
	private boolean isFull(){
		return (this.front==(this.rear+1)%this.maxsize)?true:false;
	}
	private boolean isEmpty(){
		return (this.front==this.rear)?true:false;
	}
	public boolean enQueue(int val){
		if(isFull())
			return false;
		this.cqueue[this.rear]=val;
		this.rear=(this.rear+1)%this.maxsize;
		return true;
	}	
	public Object deQueue(){  //----------------------???????????????? 为什么 Object 可以返回null; 而 int 不能返回 null
		int i=this.front;
		if(isEmpty())
			//throw new IndexOutOfBoundsException("空队列异常");
			return null;
		this.front=(this.front+1)%this.maxsize;
		return	this.cqueue[i]; 
	}
	public int size(){
		return (rear-front+maxsize)%maxsize;
	}
		
	public static void main(String[] args){
		CircularQueue queue=new CircularQueue(5);
		queue.deQueue();
		queue.traverseQueue();
		for(int i=0;i<10;i++)
			if(!queue.enQueue(i))
				break;
		queue.traverseQueue();

		out.println("dequeue: "+queue.deQueue());
		queue.traverseQueue();
		
		out.println("There are "+queue.size()+" numbers is this loop queue.");
	}
}
