// postfix
class Solution {
    // Function to convert an infix expression to a postfix expression.
    // Function to convert an infix expression to a postfix expression.
public static boolean isOperator(char ch) {
    if (ch == '*' || ch == '/' || ch == '-' || ch == '+' || ch == '^' || ch == '(' || ch == ')') {
        return true;
    }
    return false;
}

public static int priority(char ch) { // Corrected method name to 'priority'
    if (ch == '^') {
        return 3;
    } else if (ch == '*' || ch == '/') {
        return 2;
    } else if (ch == '+' || ch == '-') {
        return 1;
    }
    return -1;
}

public static String infixToPostfix(String exp) {
    // Your code here
    Stack<Character> symbol = new Stack<Character>();
    StringBuilder postfix = new StringBuilder();
    int i = 0;
    while (i < exp.length()) {
        if (!isOperator(exp.charAt(i))) {
            postfix.append(exp.charAt(i));
            i++;
        } else {
            if (symbol.isEmpty() || exp.charAt(i) == '(') {
                symbol.push(exp.charAt(i));
                i++;
                continue;
            }
            // when there is a closing bracket, empty the symbols/operators until we get the opening bracket
            if (exp.charAt(i) == ')') {
                while (symbol.peek() != '(') {
                    postfix.append(symbol.pop());
                }
                symbol.pop();
                i++;
                continue;
            }
            if (priority(exp.charAt(i)) > priority(symbol.peek())) { // Corrected method name to 'priority'
                symbol.push(exp.charAt(i));
                i++;
                continue;
            }
            if (priority(exp.charAt(i)) <= priority(symbol.peek())) { // Corrected method name to 'priority'
                // if both are ^
                if (symbol.peek() == '^' && exp.charAt(i) == '^') {
                    postfix.append(symbol.pop());
                    symbol.push(exp.charAt(i));
                    i++;
                    continue;
                }
                // add symbols to the postfix
                while (!symbol.isEmpty() && symbol.peek() != '(') {
                    postfix.append(symbol.pop());
                }
                symbol.push(exp.charAt(i));
                i++;
                continue;
            }
        }
    }
    while (!symbol.isEmpty()) {
        postfix.append(symbol.pop());
    }
    return postfix.toString(); // Convert StringBuilder to a String
}

}


// check Find if an expression has duplicate parenthesis or not
class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                char top = stack.pop();
                boolean isRedundant = true;

                while (top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isRedundant = false;
                    }
                    top = stack.pop();
                }

                        // System.out.println(isRedundant);
                if (isRedundant) {
                    return 1; // Found redundant parentheses
                }
            } else {
                stack.push(ch);
            }
        }
        return 0;
    }
}






class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        if(grid.length == 0 || grid[0].length == 0){
            return null;
        }
        
        int n = grid.length , m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[n][m];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // assign the max in the all array
        for(int i = 0 ;i < n;i++){
            for(int j = 0 ;j < m;j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // pass values of the 1's places for further improvements
        for(int i = 0 ;i < n;i++){
            for(int j = 0 ;j < m;j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    distance[i][j] = 0;
                }
            }
        }
        
        // iterate through the que to operate according to the places of the 1's
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for(int[] dir : directions){
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if(newI < n && newI >= 0 && newJ < m && newJ >= 0 && distance[newI][newJ] > distance[i][j] + 1){
                    distance[newI][newJ] = distance[i][j] + 1;
                    queue.offer(new int[]{newI,newJ});
                }
            }
        }
        
        return distance;
    }
}
// rotten mangose solved using the queue
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        if(grid==null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int n = grid.length,m = grid[0].length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        
        //assign the values to the que for the rotten oranges
        int freshOranges = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j,0});
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        int minTime = 0;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            int time = cell[2];
            minTime = Math.max(time,minTime);
            for(int[] dir : directions){
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if(newJ >= 0 && newJ < m && newI >= 0 && newI < n && grid[newI][newJ] == 1){
                    queue.offer(new int[] {newI,newJ,time+1});
                    grid[newI][newJ] = 2;
                    freshOranges--;
                }
            }
        }
        return freshOranges == 0 ? minTime : -1;
    }
}

// // Java program to demonstrate implementation of k stacks in a single
// array in time and space efficient way

public class GFG
{
	// A Java class to represent k stacks in a single array of size n
	static class KStack
	{
		int arr[]; // Array of size n to store actual content to be stored in stacks
		int top[]; // Array of size k to store indexes of top elements of stacks
		int next[]; // Array of size n to store next entry in all stacks
					// and free list
		int n, k;
		int free; // To store beginning index of free list

		//constructor to create k stacks in an array of size n
		KStack(int k1, int n1)
		{
			// Initialize n and k, and allocate memory for all arrays
			k = k1;
			n = n1;
			arr = new int[n];
			top = new int[k];
			next = new int[n];

			// Initialize all stacks as empty
			for (int i = 0; i < k; i++)
				top[i] = -1;

			// Initialize all spaces as free
			free = 0;
			for (int i = 0; i < n - 1; i++)
				next[i] = i + 1;
			next[n - 1] = -1; // -1 is used to indicate end of free list
		}

		// A utility function to check if there is space available
		boolean isFull()
		{
			return (free == -1);
		}

		// To push an item in stack number 'sn' where sn is from 0 to k-1
		void push(int item, int sn)
		{
			// Overflow check
			if (isFull())
			{
				System.out.println("Stack Overflow");
				return;
			}

			int i = free; // Store index of first free slot

			// Update index of free slot to index of next slot in free list
			free = next[i];

			// Update next of top and then top for stack number 'sn'
			next[i] = top[sn];
			top[sn] = i;

			// Put the item in array
			arr[i] = item;
		}

		// To pop an element from stack number 'sn' where sn is from 0 to k-1
		int pop(int sn)
		{
			// Underflow check
			if (isEmpty(sn))
			{
				System.out.println("Stack Underflow");
				return Integer.MAX_VALUE;
			}

			// Find index of top item in stack number 'sn'
			int i = top[sn];

			top[sn] = next[i]; // Change top to store next of previous top

			// Attach the previous top to the beginning of free list
			next[i] = free;
			free = i;

			// Return the previous top item
			return arr[i];
		}

		// To check whether stack number 'sn' is empty or not
		boolean isEmpty(int sn)
		{
			return (top[sn] == -1);
		}

	}

	// Driver program
	public static void main(String[] args)
	{
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;
		
		KStack ks = new KStack(k, n);

		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}
// This code is Contributed by Sumit Ghosh
public class GFG
{
	// A Java class to represent k stacks in a single array of size n
	static class KStack
	{
		int arr[]; // Array of size n to store actual content to be stored in stacks
		int top[]; // Array of size k to store indexes of top elements of stacks
		int next[]; // Array of size n to store next entry in all stacks
					// and free list
		int n, k;
		int free; // To store beginning index of free list

		//constructor to create k stacks in an array of size n
		KStack(int k1, int n1)
		{
			// Initialize n and k, and allocate memory for all arrays
			k = k1;
			n = n1;
			arr = new int[n];
			top = new int[k];
			next = new int[n];

			// Initialize all stacks as empty
			for (int i = 0; i < k; i++)
				top[i] = -1;

			// Initialize all spaces as free
			free = 0;
			for (int i = 0; i < n - 1; i++)
				next[i] = i + 1;
			next[n - 1] = -1; // -1 is used to indicate end of free list
		}

		// A utility function to check if there is space available
		boolean isFull()
		{
			return (free == -1);
		}

		// To push an item in stack number 'sn' where sn is from 0 to k-1
		void push(int item, int sn)
		{
			// Overflow check
			if (isFull())
			{
				System.out.println("Stack Overflow");
				return;
			}

			int i = free; // Store index of first free slot

			// Update index of free slot to index of next slot in free list
			free = next[i];

			// Update next of top and then top for stack number 'sn'
			next[i] = top[sn];
			top[sn] = i;

			// Put the item in array
			arr[i] = item;
		}

		// To pop an element from stack number 'sn' where sn is from 0 to k-1
		int pop(int sn)
		{
			// Underflow check
			if (isEmpty(sn))
			{
				System.out.println("Stack Underflow");
				return Integer.MAX_VALUE;
			}

			// Find index of top item in stack number 'sn'
			int i = top[sn];

			top[sn] = next[i]; // Change top to store next of previous top

			// Attach the previous top to the beginning of free list
			next[i] = free;
			free = i;

			// Return the previous top item
			return arr[i];
		}

		// To check whether stack number 'sn' is empty or not
		boolean isEmpty(int sn)
		{
			return (top[sn] == -1);
		}

	}

	// Driver program
	public static void main(String[] args)
	{
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;
		
		KStack ks = new KStack(k, n);

		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}
// This code is Contributed by Sumit Ghosh
public class GFG
{
	// A Java class to represent k stacks in a single array of size n
	static class KStack
	{
		int arr[]; // Array of size n to store actual content to be stored in stacks
		int top[]; // Array of size k to store indexes of top elements of stacks
		int next[]; // Array of size n to store next entry in all stacks
					// and free list
		int n, k;
		int free; // To store beginning index of free list

		//constructor to create k stacks in an array of size n
		KStack(int k1, int n1)
		{
			// Initialize n and k, and allocate memory for all arrays
			k = k1;
			n = n1;
			arr = new int[n];
			top = new int[k];
			next = new int[n];

			// Initialize all stacks as empty
			for (int i = 0; i < k; i++)
				top[i] = -1;

			// Initialize all spaces as free
			free = 0;
			for (int i = 0; i < n - 1; i++)
				next[i] = i + 1;
			next[n - 1] = -1; // -1 is used to indicate end of free list
		}

		// A utility function to check if there is space available
		boolean isFull()
		{
			return (free == -1);
		}

		// To push an item in stack number 'sn' where sn is from 0 to k-1
		void push(int item, int sn)
		{
			// Overflow check
			if (isFull())
			{
				System.out.println("Stack Overflow");
				return;
			}

			int i = free; // Store index of first free slot

			// Update index of free slot to index of next slot in free list
			free = next[i];

			// Update next of top and then top for stack number 'sn'
			next[i] = top[sn];
			top[sn] = i;

			// Put the item in array
			arr[i] = item;
		}

		// To pop an element from stack number 'sn' where sn is from 0 to k-1
		int pop(int sn)
		{
			// Underflow check
			if (isEmpty(sn))
			{
				System.out.println("Stack Underflow");
				return Integer.MAX_VALUE;
			}

			// Find index of top item in stack number 'sn'
			int i = top[sn];

			top[sn] = next[i]; // Change top to store next of previous top

			// Attach the previous top to the beginning of free list
			next[i] = free;
			free = i;

			// Return the previous top item
			return arr[i];
		}

		// To check whether stack number 'sn' is empty or not
		boolean isEmpty(int sn)
		{
			return (top[sn] == -1);
		}

	}

	// Driver program
	public static void main(String[] args)
	{
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;
		
		KStack ks = new KStack(k, n);

		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}
// This code is Contributed by Sumit Ghosh
public class GFG
{
	// A Java class to represent k stacks in a single array of size n
	static class KStack
	{
		int arr[]; // Array of size n to store actual content to be stored in stacks
		int top[]; // Array of size k to store indexes of top elements of stacks
		int next[]; // Array of size n to store next entry in all stacks
					// and free list
		int n, k;
		int free; // To store beginning index of free list

		//constructor to create k stacks in an array of size n
		KStack(int k1, int n1)
		{
			// Initialize n and k, and allocate memory for all arrays
			k = k1;
			n = n1;
			arr = new int[n];
			top = new int[k];
			next = new int[n];

			// Initialize all stacks as empty
			for (int i = 0; i < k; i++)
				top[i] = -1;

			// Initialize all spaces as free
			free = 0;
			for (int i = 0; i < n - 1; i++)
				next[i] = i + 1;
			next[n - 1] = -1; // -1 is used to indicate end of free list
		}

		// A utility function to check if there is space available
		boolean isFull()
		{
			return (free == -1);
		}

		// To push an item in stack number 'sn' where sn is from 0 to k-1
		void push(int item, int sn)
		{
			// Overflow check
			if (isFull())
			{
				System.out.println("Stack Overflow");
				return;
			}

			int i = free; // Store index of first free slot

			// Update index of free slot to index of next slot in free list
			free = next[i];

			// Update next of top and then top for stack number 'sn'
			next[i] = top[sn];
			top[sn] = i;

			// Put the item in array
			arr[i] = item;
		}

		// To pop an element from stack number 'sn' where sn is from 0 to k-1
		int pop(int sn)
		{
			// Underflow check
			if (isEmpty(sn))
			{
				System.out.println("Stack Underflow");
				return Integer.MAX_VALUE;
			}

			// Find index of top item in stack number 'sn'
			int i = top[sn];

			top[sn] = next[i]; // Change top to store next of previous top

			// Attach the previous top to the beginning of free list
			next[i] = free;
			free = i;

			// Return the previous top item
			return arr[i];
		}

		// To check whether stack number 'sn' is empty or not
		boolean isEmpty(int sn)
		{
			return (top[sn] == -1);
		}

	}

	// Driver program
	public static void main(String[] args)
	{
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;
		
		KStack ks = new KStack(k, n);

		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}
// This code is Contributed by Sumit Ghosh
public class GFG
{
	// A Java class to represent k stacks in a single array of size n
	static class KStack
	{
		int arr[]; // Array of size n to store actual content to be stored in stacks
		int top[]; // Array of size k to store indexes of top elements of stacks
		int next[]; // Array of size n to store next entry in all stacks
					// and free list
		int n, k;
		int free; // To store beginning index of free list

		//constructor to create k stacks in an array of size n
		KStack(int k1, int n1)
		{
			// Initialize n and k, and allocate memory for all arrays
			k = k1;
			n = n1;
			arr = new int[n];
			top = new int[k];
			next = new int[n];

			// Initialize all stacks as empty
			for (int i = 0; i < k; i++)
				top[i] = -1;

			// Initialize all spaces as free
			free = 0;
			for (int i = 0; i < n - 1; i++)
				next[i] = i + 1;
			next[n - 1] = -1; // -1 is used to indicate end of free list
		}

		// A utility function to check if there is space available
		boolean isFull()
		{
			return (free == -1);
		}

		// To push an item in stack number 'sn' where sn is from 0 to k-1
		void push(int item, int sn)
		{
			// Overflow check
			if (isFull())
			{
				System.out.println("Stack Overflow");
				return;
			}

			int i = free; // Store index of first free slot

			// Update index of free slot to index of next slot in free list
			free = next[i];

			// Update next of top and then top for stack number 'sn'
			next[i] = top[sn];
			top[sn] = i;

			// Put the item in array
			arr[i] = item;
		}

		// To pop an element from stack number 'sn' where sn is from 0 to k-1
		int pop(int sn)
		{
			// Underflow check
			if (isEmpty(sn))
			{
				System.out.println("Stack Underflow");
				return Integer.MAX_VALUE;
			}

			// Find index of top item in stack number 'sn'
			int i = top[sn];

			top[sn] = next[i]; // Change top to store next of previous top

			// Attach the previous top to the beginning of free list
			next[i] = free;
			free = i;

			// Return the previous top item
			return arr[i];
		}

		// To check whether stack number 'sn' is empty or not
		boolean isEmpty(int sn)
		{
			return (top[sn] == -1);
		}

	}

	// Driver program
	public static void main(String[] args)
	{
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;
		
		KStack ks = new KStack(k, n);

		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}
