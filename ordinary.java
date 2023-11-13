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
//100% accuracy
public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        int[] new1=new int[N];
        for(int i=0;i<N;i++)
        {
            if(arr[i]>0 && arr[i]<=N)
            {
                new1[arr[i]-1]++;
            }
        }
        for(int i=0;i<N;i++)
        {
            arr[i]=new1[i];
        }
    }
    //using a Hashmap
    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<N;i++)
        {
            if(hash.containsKey(arr[i]))
            {
                hash.put(arr[i],hash.get(arr[i])+1);
            }
            else hash.put(arr[i],1);
        }
        for(int i=1;i<=N;i++)
        {
            if(hash.containsKey(i)) arr[i-1]=hash.get(i);
            else arr[i-1]=0;
        }
    }
longest subarray sum
//not optimized  1 time limit warning
public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int n=A.length;
        int res=0,max=0,sum=0,f=0;
        for(int i=0; i<n; i++){
            sum=0;res=0;f=0;
            for(int j=i;j<n; j++){
                sum+=A[j];
                res++;
                if(sum==K)f=res;
            }
            if(max<f){max=f;}
        }return max;
    }
//not optimized code 2 timelimit warning
//Sliding window is used
public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int wr=0,wl=0,bestw=0,bestl=0;int total=0;
        while(wr<N)
        {
            if(total<K)
            {
                total+=A[wr];
                wr++;
            }
            if(total==K)
            {
                wl++;
            }
            if((wr-wl)>bestw && total<K)
            {
                bestw=wr-wl;
                bestl=wl;
            }
        }
        return bestw;
    }
//runned on leetcode
public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int res=0;
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=i;j<n; j++){
                sum+=nums[j];
                if(sum==k) res++;
            }
        }return res;
    }
//passing error
// foursum problem
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(i==j) continue;
                int l=j+1,r=arr.length-1;
                while(l<r){
                    int sum=arr[i]+arr[j]+arr[l]+arr[r];
                     if(sum==k){
                         ArrayList<Integer> sans=new ArrayList<Integer>();
                         sans.add(arr[i]);
                         sans.add(arr[j]);
                         sans.add(arr[l]);
                         sans.add(arr[r]);
                         ans.add(sans);
                     }
                     if(sum<k){
                         l++;
                     }
                     else r--;
                }
            }
        }
        return ans;
    }
}
//pair method
public  class pair{
    int first,sec;
    public pair(int first,int sec){
        this.first=first;
        this.sec=sec;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(arr);
        HashMap<Integer,pair> map=new HashMap<Integer,pair>();
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                map.put(arr[i]+arr[j],new pair(i,j));
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(j==i) continue;
                ArrayList<Integer> list = new ArrayList<Integer>();
                int sum=arr[i]+arr[j];
                if(map.containsKey(k-sum)){
                    pair p=map.get(k-sum);
                    if(p.first!=i && p.first!=j && p.sec!=i && p.sec!=j){
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[p.first]);
                        list.add(arr[p.sec]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}
