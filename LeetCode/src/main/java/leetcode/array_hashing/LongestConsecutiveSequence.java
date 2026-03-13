package leetcode.array_hashing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int result = solution.longestConsecutive(new int[]{0,3,2,5,4,6,1,1});
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        int currentMax = 1;
        int tmpLength = 1;
        Set<Integer> numberSet = new HashSet<>();
        for (int num:nums){
            numberSet.add(num);
        }

        Integer[] sortedArray = numberSet.toArray(new Integer[0]);

        Arrays.sort(sortedArray);
        System.out.println(Arrays.toString(sortedArray));


        for (int i = 1 ; i < sortedArray.length; i++){
            System.out.println("Current Max: " + currentMax + ". Current Length: " + tmpLength);
            if (( sortedArray[i] - sortedArray[i-1] ) == 1){
                tmpLength++;
            }
            else {
                if (tmpLength >= currentMax){
                    currentMax = tmpLength;
                }
                tmpLength = 1;
            }
        }

        if (tmpLength >= currentMax){
            currentMax = tmpLength;
        }

        return currentMax;
    }
}
