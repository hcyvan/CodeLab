import java.util.*;
import java.lang.System;
public class WashPoker{
	static int[] parseLine(String line){
		String[] split=line.split(" ");
		int len=split.length;
		int[] nums=new int[len];
		for(int i=0;i<len;i++){
			nums[i]=Integer.parseInt(split[i]);
			//System.out.print(nums[i]+ " ");
		}
		//System.out.println();
		return nums;
	}

	static void washPoker(int[] poker, int[] nk){
		int l=nk[0];
		int k=nk[1];
		for(int i=0; i<k; i++){
			int [] tmp=new int[l*2];
			for(int j=0;j<l;j++){
				tmp[2*j]=poker[j];
				tmp[2*j+1]=poker[j+l];
			}
			poker=tmp;
		}
		for(int i=0; i<2*l;i++){
			System.out.print(poker[i]);
			if(i!=2*l-1){
				System.out.print(" ");
			}
		}
		System.out.println();
	}
		
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int team=scan.nextInt();
		scan.nextLine();
		int[][] array=new int[team][];
		int[][] nk=new int[team][];
		//System.out.println("team: "+ team);
		for(int i=0;i<team;i++){
			nk[i]=parseLine(scan.nextLine());
			array[i]=parseLine(scan.nextLine());
			if(nk[i][0]*2!=array[i].length){
				System.err.println("The number of poker is not 2n");
				System.exit(1);
			}
		}
		for(int i=0;i<team;i++){
			washPoker(array[i], nk[i]);
		}
	}
}

		
	
