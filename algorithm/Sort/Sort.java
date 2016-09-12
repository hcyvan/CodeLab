import java.util.*;
public class Sort{
	static void printArray(int[] array){
		for(int i:array)
			System.out.print(i+" ");
		System.out.println();
	}
	static void insertSort(int[] a){
		// 稳定 O(n*n)
		int len=a.length;
		for(int i=1; i<len;i++){
			if(a[i]<a[i-1]){
				int tmp=a[i];
				int j=i-1;
				while(j>=0 && tmp<a[j]){
					a[j+1]=a[j];
					j--;
				}
				a[j+1]=tmp;
			}
		}
	}
	static void selectSort(int[] a){
		// 不稳定 O(n*n)
		int len=a.length;
		for(int i=0;i<len;i++){
			int min=a[i];
			int jm=i;
			for(int j=i+1;j<len;j++){
				if(min>a[j]){
					min=a[j];
					jm=j;
				}
			}
			a[jm]=a[i];
			a[i]=min;
		}
	}
	//-------------------- Heap Sort ---------------------
	static void heapSort(int[] a){
		int len=a.length;
		// Create Heap
		for(int i=len/2-1;i>=0;i--)
			siftDown(a, i, len-1);
		// Select
		for(int i=len-1;i>=0;i--){
			int tmp=a[i];
			a[i]=a[0];
			a[0]=tmp;
			siftDown(a, 0, i-1);
		}
	}
	static void siftDown(int[] a, int start, int end){
		int key=a[start];
		int child=start*2+1;   // left child
		while(child<=end){
			if(child+1<=end && a[child]<a[child+1])
				child++;
			if(a[start]<a[child]){
				a[start]=a[child];
				start=child;
				child=start*2+1;
			}else
				break;
		}
		a[start]=key;
	}
	//----------------------------------------------------
	static void bubbleSort(int[] a){
		// 稳定 O(n*n)
		int len=a.length;
		for(int i=0;i<len;i++){
			for(int j=len-1;j>=i+1;j--){
				if(a[j]<a[j-1]){
					int tmp=a[j];
					a[j]=a[j-1];
					a[j-1]=tmp;
				}
			}
		}
	}
	static void quickSort(int[] a, int start, int end){
		// 不稳定 O(nlogn)
		int s=start;
		int e=end;
		if(start>=end)
			return;
		int key=a[start];
		while(s<e){
			while(s<e && key<=a[e]) 
				e--;	
			a[s]=a[e];
			while(s<e && key>a[s])
				s++;
			a[e]=a[s];
		}	
		a[s]=key;
		quickSort(a, start, s-1);
		quickSort(a, s+1, end);
	}
	//-------------------- Merge Sort --------------------
	static void mergeSort(int[] a, int left, int right){
		if(left<right){
			int mid=(left+right)/2;
			mergeSort(a, left, mid);
			mergeSort(a, mid+1, right);
			merge(a,left,mid,right);
		}
	}
	static void merge(int[] a, int left, int mid, int right){
		int len=right-left+1;
		int[] tmp=new int[len];		
		int ll=left;
		int lr=mid+1;
		for(int i=0;i<len;i++){
			if(lr>right || (ll<=mid && lr<=right && a[ll]<=a[lr]))
				tmp[i]=a[ll++];
			else if(ll>mid || (ll<=mid && lr<=right && a[ll]>a[lr]))
				tmp[i]=a[lr++];
		}
		printArray(tmp);
		System.arraycopy(tmp, 0, a, left, len);
	}	
	//---------------------------------------------------
	public static void main(String[] args){
		int[] array=ReadLine.read();
		//printArray(array);	
		//insertSort(array);
		//selectSort(array);
		//bubbleSort(array);
		//quickSort(array, 0, array.length-1);
		//mergeSort(array, 0, array.length-1);
		heapSort(array);
		printArray(array);
	}
}
