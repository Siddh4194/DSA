//#01find missing in array
int[] ans=new int[n];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        Arrays.sort(arr);
        for(int i:arr){
            if(!map.containsKey(i)){
                map.put(i,1);
            }
            else{
                map.put(i,map.get(i)+1);
            }
        }
        Set<Integer> e = map.keySet();
        int j=1,k=0;
        for(int s:e){
            if(map.get(s)==2){
                ans[k++] = s;
            }
        }
        for(int s:e){
            if (j>n) break;
            if(s!=j){
                ans[k++] = j;
            }
            j++;
        }
        return ans;
        
        //time limit exceed
        class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        int[] ans=new int[n];int k=0;
        for(int i:arr){
            if(list.contains(i)){
              ans[k++]=i;        
            }
            else{
                list.add(i);
            }
        }
        int m=list.size();
        int sum = ((m + 1) * (m + 2)) / 2;
        for (int i = 0; i < m; i++)
            sum -= list.get(i);
        ans[k++]=sum;
        return ans;
    }
}
//Optimized Code
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] ans=new int[2];
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        for(int i : arr){
            if(!map.containsKey(i)){
                map.put(i,true);
            }
            else{
                ans[0]=i;
            }
        }
        for(int i=1;i<=n;i++){
            if(!map.containsKey(i)){
                ans[1]=i;
                break;
            }
        }
        return ans;
    }
}
Count Reverse Pairs
You are given an array of N integers arr, find the count of reverse pairs. 

A pair of indices (i, j) is said to be a reverse pair if both the following conditions are met:

0 <= i < j < N 
arr[i] > 2 * arr[j]

class Solution {
    public int countRevPairs(int N, int arr[]) {
        // Code here
        int i=0,t=0;
        while(i<=(N-2)){
            for(int j=i+1;j<N;j++){
                if(arr[i]>(2*arr[j])){
                    t++;
                }
            }i++;
        }
        return t;
    }
}

Test Cases Passed: 
10114 /10120
Time Limit Exceeded

Your program took more time than expected.Expected Time Limit : 5.24sec
Hint : Please optimize your code and submit again
