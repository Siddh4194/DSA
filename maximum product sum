//Maximum Product Subarray
class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        int min_end=1,max_end=1;
        long max_so_far=0,flag=0;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                max_end=max_end*arr[i];
                min_end=Math.min(min_end*arr[i],1);
                flag=1;
            }
            else if(arr[i]==0){
                min_end=1;max_end=1;
            }
            else{
                int temp=max_end;
                max_end=Math.max(arr[i]*min_end,1);
                min_end=temp*arr[i];
            }
            if(max_so_far<max_end) max_so_far=max_end;
        }
        if(flag==0 && max_so_far==0) return 0;
        return max_so_far;
    }
}
//it dosent work well

//second approach
class Solution {
    public int maxProduct(int[] nums) {
        int max_end=nums[0],min_end=nums[0];
        int max_so_far=nums[0];
         for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(Math.max(nums[i], nums[i] * max_end),nums[i] *min_end);
            min_end = Math.min(Math.min(nums[i], nums[i] * max_end),nums[i] * min_end);
            max_end = temp;
            max_so_far= Math.max(max_so_far, max_end);
        }
        return max_so_far;
    }
}
