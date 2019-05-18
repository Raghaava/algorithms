
import java.util.Stack;

public class BracketsValidator {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case '}':
                case ']':
                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    char openingBracket = stack.pop();
                    if(!arePair(openingBracket, ch)){
                        return false;
                    }
                    break;
                default:
                    stack.push(ch);
            }
        }
        return stack.empty();
    }

    private boolean arePair(char openingBracket, char closingBracket) {
        if (openingBracket == '{' && closingBracket == '}') return true;
        if (openingBracket == '[' && closingBracket == ']') return true;
        if (openingBracket == '(' && closingBracket == ')') return true;
        return false;
    }
}
