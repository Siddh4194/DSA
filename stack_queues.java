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
