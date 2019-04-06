import java.util.Random;
public class FindKthNumber{
	int[] arr;
	int len;
	public FindKthNumber(int[] array){
		len=array.length;
		arr=new int[len];
		System.arraycopy(array,0,arr,0,len);
	}
	//----------------- nlogk ----------------------
	public int kthHeap(int k){
		int[] kh=new int[k];
		// construct Big Heap
		for(int i=0; i<k; i++){
			kh[i]=arr[i];
			siftup(kh, i);
		}
		for(int i=k; i<len; i++){
			if(kh[0]>arr[i]){
				kh[0]=arr[i];
				siftdown(kh, 0);
			}
		}
		return kh[0];
	}
	public void siftup(int[] array, int i){
		int child=i,parent=(i-1)/2;
		int key=array[child];
		while(child>0){
			if(key>array[parent]){
				array[child]=array[parent];
				child=parent;
				parent=(child-1)/2;
			}else{
				break;
			}
		}
		array[child]=key;
	}
	public void siftdown(int[] array, int i){
		int parent=i, child=i*2+1, len=array.length;
		int key=array[parent];
		while(child<len){
			if(child+1<len && array[child+1]>array[child])
				child++;
			if(array[child]>key){
				array[parent]=array[child];
				parent=child;
				child=parent*2+1;
			}else{
				break;
			}
		}
		array[parent]=key;
	}
	//----------------- n ~ n*n ----------------------
	public int kthQuickSort(int kth, int l, int r){
		int k=kth-1;
		if(l==r) return arr[l];
		int m=partition_random(l, r);
		if(k==m) return arr[m];
		else if(k<m) return kthQuickSort(kth, l, m-1);
		else return kthQuickSort(kth, m+1, r);			
		
	}
	public int partition_random(int l, int r){
		Random ra=new Random();
		int m=ra.nextInt(r-l+1)+l;
		return partition(l, r, m);
	}	
	//------------- partition ---------------------
	public int partition(int l, int r, int m){
		int key=arr[m];
		arr[m]=arr[l];
		while(l<r){
			while(l<r && arr[r]>=key){
				r--;
		}
			arr[l]=arr[r];
			while(l<r && arr[l]<key){
				l++;
			}			
			arr[r]=arr[l];
		}
		arr[r]=key;
		return r;
	}
	//----------------- n ----------------------
	public int bfprt(int kth, int l, int r){
		int k=kth-1;
		int m=findMid(l,r);
		m=partition(l, r, m);
		if(k==m) return arr[m];
		else if(k<m) return kthQuickSort(kth, l, m-1);
		else return kthQuickSort(kth, m+1, r);			
				
	}
	public int findMid(int l, int r){
		if(r-l<5){
			insertSort(l,r);
			return (l+r)>>1;
		}
		int s=l;
		int t=l-1;
		for(;s<=r;s+=5){
			int e=s+4<=r?s+4:r;
			insertSort(s,e);
			int m=(s+e)>>1;
			t++;
			arr[t]=arr[t]^arr[m];
			arr[m]=arr[t]^arr[m];	
			arr[t]=arr[t]^arr[m];	
		}
		return findMid(l, t);
	}
	public void insertSort(int l, int r){
		for(int s=l+1;s<=r;s++){
			int key=arr[s];
			for(int j=s;j-1>=l;j--){
				if(arr[j]<arr[j-1]){
					arr[j]=arr[j]^arr[j-1];
					arr[j-1]=arr[j]^arr[j-1];
					arr[j]=arr[j]^arr[j-1];
				}else{
					arr[j]=key;
					break;
				}
			}
		}
	}
	//------------------------------------------
	public static void insertSortS(int[] arr){
		int r=arr.length-1;
		for(int s=1;s<=r;s++){
			int key=arr[s];
			for(int j=s;j-1>=0;j--){
				if(arr[j]<arr[j-1]){
					arr[j]=arr[j]^arr[j-1];
					arr[j-1]=arr[j]^arr[j-1];
					arr[j]=arr[j]^arr[j-1];
				}else{
					arr[j]=key;
					break;
				}
			}
		}
	}
	public static int[] initRandomArray(int n){
		return initRandomArray(n, 100);
	}
	public static int[] initRandomArray(int n, int max){
		Random r=new Random();
		int[]re=new int[n];
		for(int i=0;i<n;i++)	
			re[i]=r.nextInt(max);	
		return re;
	}
	public static void printArray(int[] arr){
		for(int i=0, l=arr.length;i<l;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void main(String[] args){
		int[] array=initRandomArray(100);
		printArray(array);
		FindKthNumber f=new FindKthNumber(array);

		int kth=50;
		System.out.println(f.kthHeap(kth));
		System.out.println(f.kthQuickSort(kth,0,array.length-1));
		System.out.println(f.bfprt(kth,0,array.length-1)+" ");
	}
}
