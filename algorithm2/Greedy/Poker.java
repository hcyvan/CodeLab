import java.util.*;
public class Poker{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		ArrayList<Integer> array=new ArrayList<Integer>();
		int total=0;
		for(int i=0;i<N;i++){
			int tmp=scan.nextInt();
			array.add(tmp);
			total+=tmp;
		}
		int arg=total/N;
		int s=0;
		for(int i=0;i<N-1;i++){
			int mtr=array.get(i)-arg;
			if(mtr!=0)
				s++;
			array.set(i+1, array.get(i+1)+mtr);
		}
		System.out.println(s);
	}
}
			
			
		
