import java.util.Stack;
import java.util.Random;
import static java.lang.System.out;

public class StackGetMin{
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public StackGetMin(){
		this.stackData=new Stack<Integer>();
		this.stackMin=new Stack<Integer>();
	}
	
	public void push(int num){
		if(this.stackMin.empty() || num<=this.stackMin.peek())
			this.stackMin.push(num);
		this.stackData.push(num);
	}
	public int pop(){
		if(this.stackData.empty()){
			throw new RuntimeException("Your stack is empty.");
		}
		int top=this.stackData.pop();
		if(top==this.stackMin.peek())
			this.stackMin.pop();	
		return top;
	}
	public int getMin(){
		if(this.stackData.empty()){
			throw new RuntimeException("Your stack is empty.");
		}
		return this.stackMin.peek();
	}
	
	//---------------------------------------------------------------
	public static void main(String[] args){
		StackGetMin s=new StackGetMin();
		Random r=new Random();
		for(int i=0;i<10;i++){
			int tmp=r.nextInt(100);
			s.push(tmp);	
			out.print(tmp+" ");
		}
		out.println();
		out.println(s.getMin());
	}
}
			
	
