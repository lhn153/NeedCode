package leetcode.stack;

import java.lang.reflect.Array;
import java.util.*;

public class EvaluateReversePolishNotation {


    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> operands = new ArrayDeque<>();

        for (String str : tokens) {
            switch (str) {
                case "+":
                    operands.push(operands.pop() + operands.pop());
                    break;
                case "-":
                    int first = operands.pop();
                    int second = operands.pop();
                    operands.push(second - first);
                    break;
                case "*":
                    operands.push(operands.pop() * operands.pop());
                    break;
                case "/":
                    first = operands.pop();
                    second = operands.pop();
                    operands.push(second / first);
                    break;
                default:
                    operands.push(Integer.parseInt(str));
                    break;
            }
        }

        return operands.pop();
    }


}
