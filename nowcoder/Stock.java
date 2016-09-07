import java.util.Scanner;
import java.lang.System;
public class Stock{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n;
		while(in.hasNextInt()){
			int price=0;
			n=in.nextInt();
			int i=3;
			int j=3;
			for(int m=1;m<=n;m++){
				if(m==i){
					price--;
					i=i+j;
					j++;
				}else{
					price++;
				}
			}
		System.out.println(price);
		}
	}
}
