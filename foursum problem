//passing error
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
