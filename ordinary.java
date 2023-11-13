// profit in market
class Solution {
    public int solve(int i,int buy,int[] price,int[][] dp)
   {
     if(i>=price.length) return 0;
     if(dp[i][buy]!=-1) return dp[i][buy];
     int profit =0;
     if(buy==0){ //means we have to buy now
       profit =Math.max(0+solve(i+1,0,price,dp),-price[i]+solve(i+1,1,price,dp));
     }
     if(buy==1){ //means it's time to sell now 
       profit =Math.max(0+solve(i+1,1,price,dp),price[i]+solve(i+2,0,price,dp));
     }
     
     return dp[i][buy]=profit;
     
   }
   public int maxProfit(int[] price) {
     int n=price.length;
     int[][] dp=new int[n][2];
     for(int d[]:dp){
            Arrays.fill(d,-1);
        }
      return solve(0,0,price,dp);
    }
}



//union of two arrays not optimized
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i1:arr1)
        {
            if(al.contains(i1))
            {
                continue;
            }
           al.add(i1); 
        }
        for(int i:arr2)
        {
            if(al.contains(i))
            {
                continue;
            }
            al.add(i);
        }
        Collections.sort(al);
        return al;
    }
}
//union of two arrays optimized
public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
           TreeSet <Integer> s=new TreeSet<>();
  ArrayList < Integer > Union=new ArrayList<>();
  for (int i = 0; i < n; i++)
    s.add(arr1[i]);
  for (int i = 0; i < m; i++)
    s.add(arr2[i]);
  for (int it: s)
    Union.add(it);
  return Union;
    }
   
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
