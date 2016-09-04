import java.lang.System;
import java.io.*;
import java.util.Scanner;
public class InputOutput{
	public static void main(String[] args){
		int b;
		/*
		try{
			System.out.println("please Input:");
			while((b=System.in.read())!=-1)
				System.out.print((char)b);
		}catch(IOException e){
			System.out.println(e.toString());
		}
		*/
		System.out.println("--------------------------------------");
		System.out.println("This is java.uitl.Scanner :");
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()){
			/*
			System.out.println("next():");
			String str1=scan.next();
			System.out.println(str1);
			*/
			/*
			System.out.println("nextLine():");
			String str2=scan.nextLine();
			System.out.println(str2);
			*/
			System.out.println("nextInt():");
			int i=scan.nextInt();
			System.out.println(i);
				
			System.out.println("nextFloat():");
			float f=scan.nextFloat();
			System.out.println(f);
	
			System.out.println("nextDouble():");
			double d=scan.nextDouble();
			System.out.println(d);
		}	
	}
}
