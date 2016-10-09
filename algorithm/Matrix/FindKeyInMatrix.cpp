#include <iostream>
using namespace std;

bool isInMatrix(int** ma, int n, int m, int key)
{
	int l=n*m;	
	int i=0,j=0,e=0;
	while(e++<l){
		if(i==n||j==m)
			break;
		if(ma[i][j]==key)
			return true;
		else if(ma[i][j]>key)
			i++;
		else
			j++;
	}
	return false;
}
int main()
{
	int** mtest;
	mtest=new int*[4];
	for(int i=0;i<4;i++){
		mtest[i]=new int[4];
		for(int j=0;j<4;j++)
			mtest[i][j]=12-4*i+j;
	}	
	if(isInMatrix(mtest,4,4, 8))
		cout<<"8 in m"<<endl;
	else 
		cout<<"8 not in m"<<endl;
		
	if(isInMatrix(mtest,4,4, 18))
		cout<<"18 in m"<<endl;
	else 
		cout<<"18 not in m"<<endl;
	return 0;
}
