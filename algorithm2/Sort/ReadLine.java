import java.util.Scanner;
public class ReadLine{
	public static int[] read(){
		Scanner scan=new Scanner(System.in);
		String[] strs=scan.nextLine().replaceAll(" +"," ").split(" ");
		int[] ints=new int[strs.length];
		for(int i=0;i<strs.length;i++)
			ints[i]=Integer.parseInt(strs[i]);
		return ints;
	}
}
			
		
