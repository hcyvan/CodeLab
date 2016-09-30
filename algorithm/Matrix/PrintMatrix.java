public class PrintMatrix{
	int[][] matrix;
	public PrintMatrix(int i, int j){
		matrix=new int[i][j];
		int x=0,y=0,m=0;
		while(y!=i){
			matrix[y][x++]=m++;
			if(x==j){
				x=0;
				y++;
			}
		}
	}	
	public void printByLine(){
		int r=matrix.length;
		int c=r!=0?matrix[0].length:0;
		int x=0, y=0;
		while(y!=r){
			System.out.print(matrix[y][x++]+"\t");
			if(x==c){
				x=0;
				y++;
				System.out.println();
			}
		}
	}
	public void printByZ(){
		int r=matrix.length;
		int c=r!=0?matrix[0].length:0;
		int x=0, y=0;
		int s=0, e=r*c;
		while(s++!=e){
			System.out.print(matrix[y][x]+" ");
			if((x+y)%2==0){
				x++;
				y--;
				if(x==c){
					x--;
					y+=2;
				}
				if(y<0)
					y=0;
			}else{
				x--;
				y++;
				if(y==r){
					y--;
					x+=2;
				}
				if(x<0)
					x=0;
			}	
		}	
		System.out.println();
	}
	
	public static void main(String args[]){
		PrintMatrix m=new PrintMatrix(5,7);
		m.printByLine();
		m.printByZ();
		PrintMatrix m1=new PrintMatrix(7,5);
		m1.printByLine();
		m1.printByZ();
	}
}
