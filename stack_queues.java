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
