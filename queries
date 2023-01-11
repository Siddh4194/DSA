class Solution {
    void rearrange(int arr[], int n) {
        // code here
        int[] newarr=new int[n];
        int pos=0,neg=1,t=0;
        for(int k:arr){if(k<0){t++;}}
        for(int i:arr)
        {
            if(i>=0)
            {
                if(pos<n){newarr[pos]=i;}
                if(t>0){pos+=2;}
                else{pos++;}
                if(pos>n){break;}
            }
            else if(i<0 && t>0)
            {
                if(neg<n){newarr[neg]=i;}
                neg+=2;
                t--;
                if(neg>n){break;}
                
            }
        }
        for(int i=0;i<n;i++)
        {
            arr[i]=newarr[i];
        }
    }
}
