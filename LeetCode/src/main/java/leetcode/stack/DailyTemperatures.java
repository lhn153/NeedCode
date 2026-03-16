package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            while (!stack.isEmpty() && temperatures[currentIndex] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();
                result[previousIndex] = currentIndex - previousIndex;
            }

            stack.push(currentIndex);
        }

        return result;

    }
}
