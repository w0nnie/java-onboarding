package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        return removeDulicate(cryptogram);
    }

    public static String removeDulicate(String cryptogram){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<cryptogram.length(); i++){
            //핵심
            if(!stack.isEmpty() && stack.peek() == cryptogram.charAt(i))
                stack.pop();
            else
                stack.push(cryptogram.charAt(i));
        }
        return printCrypto(stack);
    }

    private static String printCrypto(Stack<Character> stack) {
        String answer = "";
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i) + "";
        }
        return answer;
    }
}
