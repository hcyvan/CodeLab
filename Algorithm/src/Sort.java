public class Sort {
    static void printArray(int[] array){
        for(int i:array)
            System.out.print(i+" ");
        System.out.println();
    }
    static void bubbleSort(int[] arr) {
        int tmp=0;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i;j++) {
                if (arr[j] > arr [j+1]) {
                    tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        printArray(arr);
    }
    static void insertSort(int[] arr) {
        for (int i=1;i<arr.length-1;i++) {
            int j=i-1;
            while (j>=0 && arr[j]>arr[i]) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=arr[i];
        }
        printArray(arr);
    }
    static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length-1);
        printArray(arr);
    }
    static void selectSort(int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            int s = i;
            for (int j=i+1;j<arr.length-1;j++){
                if (arr[j]<arr[s]) {
                    s=j;
                }
            }
            int tmp=arr[i];
            arr[s]=arr[i];
            arr[i]=tmp;
        }
        printArray(arr);
    }
    static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int p=partion(arr, low, high);
            qsort(arr,low, p-1);
            qsort(arr,p+1, high);
        }
    }
    static int partion(int[] arr, int low, int high) {
        int pivot=arr[low];
        while(low < high) {
            while (low < high && arr[high]>=pivot) high--;
            arr[low]=arr[high];
            while (low<high && arr[low]<=pivot) low++;
            arr[high]=arr[low];
        }
        arr[low]=pivot;
        return low;
    }
    static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] tmp = new int[len];
        merge(arr, tmp, 0, len - 1);
        printArray(arr);
    }
    static void heapSort(int[] arr) {
        for(int i=arr.length/2-1;i>=0;i--) {
            adjustHeap(arr, i, arr.length);
        }
        for(int i=arr.length-1;i>0;i--){
            int tmp=arr[i];
            arr[i]=arr[0];
            arr[0]=tmp;
            adjustHeap(arr, 0, i);
        }
        printArray(arr);
    }
    static void adjustHeap(int[] arr, int s, int len) {
        int tmp=arr[s];
        for(int i=s*2+1;i<len;i=i*2+1) {
            if(i+1<len && arr[i] < arr[i+1]) {
                i++;
            }
            if(tmp < arr[i]) {
                arr[s] = arr[i];
                s=i;
            } else {
                break;
            }
        }
        arr[s]=tmp;
    }
    static void merge(int[] arr, int[] tmp, int low, int high) {
        if(low >= high) {
            return;
        }
        int len = high - low;
        int mid = len/2+low;
        int left1 = low, right1=mid;
        int left2 = mid+1, right2=high;
        merge(arr, tmp, left1, right1);
        merge(arr, tmp, left2, right2);
        int i = left1;
        while(left1<=right1 && left2<=right2) {
            tmp[i++] = arr[left1]<arr[left2] ? arr[left1++] : arr[left2++];
        }
        while(left1<=right1) {
            tmp[i++]=arr[left1++];
        }
        while(left2<=right2) {
            tmp[i++]=arr[left2++];
        }
        for (int j=low; j<=high;j++){
            arr[j]=tmp[j];
        }
    }
    public static void main(String[] args) {
        System.out.println("hello");
        int[] input = new int[]{3,2,9,10,4,2,3,5,6,15};
        System.out.print("Heap Sort: ");
        heapSort(input);
        input = new int[]{3,2,9,10,4,2,3,5,6,15};
        System.out.print("Bubble Sort: ");
        bubbleSort(input);
        input = new int[]{3,2,9,10,4,2,3,5,6,15};
        System.out.print("Quick Sort: ");
        quickSort(input);
        input = new int[]{3,2,9,10,4,2,3,5,6,15};
        System.out.print("Insert Sort: ");
        insertSort(input);
        input = new int[]{3,2,9,10,4,2,3,5,6,15};
        System.out.print("Select Sort: ");
        selectSort(input);
        input = new int[]{3,2,9,10,4,2,3,5,6,15};
        System.out.print("Merge Sort: ");
        mergeSort(input);
    }
}
