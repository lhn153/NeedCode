package leetcode.two_pointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(new int[]{-2,0,0,2,2}).toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return List.of();
        }
        int[] copyOfNums = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copyOfNums);

        for (int i = 0; i < copyOfNums.length - 2 ; i++) {
            if ( i > 0 && copyOfNums[i] == copyOfNums[i-1]){
                System.out.println(copyOfNums[i]);
                continue;
            }

            List<List<Integer>> resOfFind = this.twoSum(copyOfNums, i + 1, -copyOfNums[i]);
            res.addAll(resOfFind);
        }

        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int startIdx, int sumToFind) {
        List<List<Integer>> res = new ArrayList<>();

        int begin = startIdx;
        int end = nums.length - 1;
        while (begin < end) {
            int currentSum = nums[begin] + nums[end];
            if (currentSum == sumToFind) {
                res.add(Arrays.asList(-sumToFind, nums[begin], nums[end]));

                while (begin < end && nums[begin] == nums[begin+1]) begin++;
                while (begin < end && nums[end] == nums[end-1]) end--;
                begin++;
                end--;
            } else if (currentSum > sumToFind) {
                end--;
            } else {
                begin++;
            }
        }

        return res;
    }
}
