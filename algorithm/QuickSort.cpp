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
int* copy_list(int* a, int n)
{
	int* new_a=new int[n];
	for(int i=0;i<n;i++)
		new_a[i]=a[i];
	return new_a;
}

void quick_sort(int *list, int first, int last)
{
	int key=list[first];
	int start=first;
	int end=last;

	if(first >= last)
		return;

	while(first < last){
		while(first < last && key <= list[last])
			last--;
		list[first]=list[last];
		while(first < last && list[first] < key)
			first++;
		list[last]=list[first];
	}
	list[first]=key;
	quick_sort(list, start, first-1);
	quick_sort(list, first+1, end);
}
void bubble_sort(int *list,int len)
{
	int i,j,tmp;
	for(i=len-1;i>=0;i--){
		for(j=0;j<i;j++){
			if(list[j]>list[j+1]){
				tmp=list[j];
				list[j]=list[j+1];
				list[j+1]=tmp;
			}		
		}
	}
}
void insert_sort(int *list, int len)
{
	int i,j,tmp;
	for(i=1; i<len; i++){
		tmp=list[i];
		for(j=i-1;j>=0;j--){
			if(list[j]<tmp)
				break;
			list[j+1]=list[j];
		}
		list[j+1]=tmp;
	}
}
/*********************************** Heap Sort ***********************************/
void sift_down(int* list, int i, int length)
{
	int child=2*i+1;
	int tmp=list[i];
	while(child<length){
		if(child+1<length && list[child]<list[child+1])
			child++;
		if(list[i]<list[child]){
			list[i]=list[child];
			i=child;
			child=2*i+1;
		}else{
			break;
		}
		list[i]=tmp;
	}
}
void CreateHeap(int* list, int length)
{
	for(int i=(length-2)/2; i >=0; i--)
		sift_down(list, i, length);
}
void heap_sort(int *list, int length)
{
	int tmp;
	CreateHeap(list, length);
	for(int i=length-1;i>=0;i--){
		tmp=list[i];
		list[i]=list[0];
		list[0]=tmp;
		sift_down(list, 0, i);
	}
}
/*****************************************************************************/
void select_sort(int *list, int len)
{
	int i,j,index;	
	int min,tmp;
	for(i=0;i<len;i++){
		min=list[i];
		index=i;
		for(j=i+1;j<len;j++){
			if(min > list[j]){
				min=list[j];
				index=j;
			}
		}
		tmp=list[i];
		list[i]=min;
		list[index]=tmp;
	}
}
void print(int *list, int len)
{
	for(int i=0; i<len;i++)
		cout<<list[i]<<" ";
	cout << endl;
}
	
int main()
{
	int *a,*ori;
	ori=generate_list(20);
	
	a=copy_list(ori, 20);
	cout<<"Ori: ";
	print(a,20);

	a=copy_list(ori, 20);
	quick_sort(a, 0, 19);
	cout<<"Quick Sort: ";
	print(a,20);

	a=copy_list(ori, 20);
	bubble_sort(a, 20);
	cout<<"Bubble Sort: ";
	print(a,20);
	
	a=copy_list(ori, 20);
	insert_sort(a, 20);
	cout<<"Insert Sort: ";
	print(a,20);

	a=copy_list(ori, 20);
	select_sort(a, 20);
	cout<<"Select Sort: ";
	print(a,20);

	a=copy_list(ori, 20);
	heap_sort(a, 20);
	cout<<"Heap Sort: ";
	print(a,20);
	return 0;
}
