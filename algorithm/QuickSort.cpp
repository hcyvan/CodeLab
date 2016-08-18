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

void quick_sort(int *list, int first, int last)
{
	int key=list[first];
	while(first < last){
		while(first < last && key <= list[last])
			last--;
		list[first]=list[last];
		while(first < last && list[first] < key)
			first++;
		list[last]=list[first];
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
