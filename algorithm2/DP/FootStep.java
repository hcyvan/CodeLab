import java.util.*;
public class FootStep{
  	public static void main(String[] args){
     	Scanner scan=new Scanner(System.in);
      	int N=scan.nextInt();
      	for(int i=0;i<N;i++){
          	int m=scan.nextInt();
          	int num=getNum(m);
          	System.out.println(num);
        }
    }
  	public static int getNum(int n){
	int[] f=new int[n];
      	if(n>=1)
          	f[0]=0;
      	if(n>=2)
          	f[1]=1;
      	if(n>=3)
          	f[2]=2;
      	for(int i=3;i<n;i++)
			f[i]=f[i-1]+f[i-2];
      	return f[n-1];
    }
}
