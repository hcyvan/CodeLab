#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findKthLargestQuickSort(vector<int>& nums, int k) {
        int l=0,r=nums.size()-1;
        while (true) {
            int p = quickSortPartion(nums, l, r);
            if(p > k-1) {
                r=p-1;
            } else if(p < k-1) {
                l=p+1;
            }else {
                break;
            }
        }
        return nums[k-1];
    }
    int quickSortPartion(vector<int>& nums, int l, int r) {
        int pivot=nums[r];
        while (l < r) {
            while (l<r && nums[l]>=pivot) l++;
            nums[r]=nums[l];
            while (l<r && nums[r] < pivot) r--;
            nums[l]=nums[r];
        }
        nums[r]=pivot;
        return r;
    }
    int findKthLargest(vector<int>& nums, int k) {
        int len=nums.size();
        for(int i=len/2-1;i>=0;i--){
            adjustHeap(nums, i, len);
        }
        int kth;
        for(int i=len-1;i>=len-k;i--) {
                int tmp=nums[i];
                nums[i]=nums[0];
                nums[0]=tmp;
                kth=nums[i];
                adjustHeap(nums, 0, i);
        }
        return kth;
    }
    void adjustHeap(vector<int>& v, int s, int len) {
        int tmp=v[s];
        for(int i=s*2+1;i<len;i=i*2+1) {
            if(i+1 < len && v[i] < v[i+1]) {
                i++;
            }
            if(tmp < v[i]) {
                v[s] = v[i];
                s=i;
            } else {
                break;
            }
        }
        v[s]=tmp;
    }
};

int main()
{
    Solution solution = Solution();
    vector<int> v = {11, 2,1,7,9,10,8,15,6};
    int k = solution.findKthLargestQuickSort(v, 1);
    cout << k << endl;
    k = solution.findKthLargestQuickSort(v, 3);
    cout << k << endl;
    k = solution.findKthLargestQuickSort(v, 5);
    cout << k << endl;
}