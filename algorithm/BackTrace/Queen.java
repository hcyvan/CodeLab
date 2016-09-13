import java.util.*;
public class Queen{
	private int N;
	private int T;
	private int [] queen;
	public Queen(int N){
		this.N=N;
		this.T=0;
		this.queen=new int[N];
	}
	public int solve(){
		findNextPosition(0);	
		return this.T;
	} 
	public void findNextPosition(int i){	
		if(i==N){
			this.T++;
			return;
		}

		for(int j=0;j<N;j++){
			if(isValidPosition(i,j)){
				queen[i]=j;
				findNextPosition(i+1);
			}
		}
	}
	public boolean isValidPosition(int i,int j){
		for(int k=0;k<i;k++)
			if(queen[k]==j || Math.abs(j-queen[k])==Math.abs(i-k))
				return false;
		return true;	
	}
	public static void main(String[] args){
		Queen queen=new Queen(8);
		int n=queen.solve();
		System.out.println(n);
	}
}
