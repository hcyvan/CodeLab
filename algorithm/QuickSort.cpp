#include <stdlib.h>
#include <iostream>
using namespace std;
int* generate_list(int n)
{
	int* list=new int[n];
	for(int i=0;i<n;i++){
		list[i]=rand()%100;
	}
	return list;
}
	
int main()
{
	int *a;
	a=generate_list(20);
	for(int i=0;i<20;i++)
		cout<<a[i]<<" ";
	cout <<endl;
	
	return 0;
}
