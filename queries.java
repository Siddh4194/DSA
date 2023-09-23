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


// stackpermutation

//Optimized solution
class Solution {
public static int isStackPermutation(int n, int[] ip, int[] op) {
        Stack<Integer> st = new Stack<>();
        int j=0;
        
        for(int i=0; i<n; i++) {
            st.push(ip[i]);
            
            while(!st.isEmpty() && st.peek() == op[j]) {
                st.pop();
                j++;
            }
        }
        
        return (st.isEmpty() && (j == n)) ? 1 : 0;
    }
}

// partially run 10 test cases are not solved
public static int isStackPermutation(int n, int[] ip, int[] op) {
        // code here
        Queue<Integer> input = new LinkedList<>();
        Queue<Integer> output = new LinkedList<>();
        for(int i : ip){
            input.add(i);
        }
        for(int i : op){
            output.add(i);
        }
        Stack<Integer> temp = new Stack<>();
        while(!input.isEmpty()){
            int ele = input.poll();
            
            if(output.peek() == ele){
                temp.push(ele);
                while(!temp.isEmpty()){
                    if(temp.peek() == output.peek()){
                        temp.pop();
                        output.poll();
                    } else{
                        break;
                    }
                }
            } else{
                temp.push(ele);
            }
        }
        return (input.isEmpty() && temp.isEmpty()) ? 1 : 0;
    }



// celebrity problem
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here
    	Stack<Integer> stack = new Stack<>();
    	for(int i = 0 ; i < n; i++){
    	    stack.push(i);
    	}
    	
    	while(stack.size() > 1){
    	    int a = stack.pop();
    	    int b = stack.pop();
    	   // if a knows the b then a is not the celebrity
    	    if(M[a][b] == 1){
    	        stack.push(b);
    	    }
    	   // if a dosent know the b the b is not the celebrity
    	    else{
    	        stack.push(a);
    	    }
    	}
    	
    	int candidate = stack.pop();
    	
        for(int i = 0 ; i < n; i++){
    	    if(i != candidate && (M[i][candidate] == 0 || M[candidate][i] == 1)){
    	        return -1;
    	    }
    	}
    	
    	return candidate;
    }
}
