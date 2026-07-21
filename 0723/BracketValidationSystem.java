import java.util.Stack;

public class BracketValidationSystem {

    public static void main(String[] args) {
        String[] testCases = {
            "{[()]}",                   
            "a * (b + c) - [d / {e}]",  
            "([)]",                     
            "((()",                     
            "))",                       
            "{[a + b] * (c - d)}"       
        };

        for (int i = 0; i < testCases.length; i++) {
            String expr = testCases[i];
            boolean valid = isValid(expr);
            System.out.println("測試案例 " + (i + 1) + " : " + expr);
            System.out.println("驗證結果 : " + (valid ? "配對正確" : "配對失敗"));
            System.out.println("-----------------------------------");
        }
    }

    public static boolean isValid(String expr) {
        if (expr == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatching(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}