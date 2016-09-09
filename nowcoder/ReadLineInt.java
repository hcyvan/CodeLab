import java.util.*;
public class ReadLineInt{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		//ArrayList<Integer> array=new ArrayList<Integer>();
		String str=scan.nextLine();
		String[] strs=str.replaceAll(" +"," ").split(" ");
		int[] ints=new int[strs.length];
		for(int i=0, len=strs.length;i<len;i++)
			ints[i]=Integer.parseInt(strs[i]);
		int sum=0;
		for(int i: ints)
			sum+=i;
		System.out.println(sum);
	}
}
		
