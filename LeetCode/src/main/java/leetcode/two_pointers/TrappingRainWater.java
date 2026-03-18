package leetcode.two_pointers;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int markPosition = 0;
        int currentTrappedRainWater = 0;
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[markPosition]) {
                res += currentTrappedRainWater;
                currentTrappedRainWater = 0;
                markPosition = i;
            } else {
                currentTrappedRainWater += height[markPosition] - height[i];
            }
        }

        int peak = markPosition;
        markPosition = height.length - 1;
        currentTrappedRainWater = 0;

        for (int i = height.length - 1; i >= peak; i--) {
            if (height[i] >= height[markPosition]) {
                res += currentTrappedRainWater;
                currentTrappedRainWater = 0;
                markPosition = i;
            } else {
                currentTrappedRainWater += height[markPosition] - height[i];
            }
        }

        return res;
    }
}

/**
 * int markPosition = 0
 * int currentTrappedRainWater = 0;
 * total  = 0;
 * for (int i =0; i < input.size();i++){
 * if (input[i] > 0 && markPosition == 0){
 * markPosition = i;
 * continue;
 * }
 * <p>
 * if (input[i] < input[markPosition]){
 * currentTrappedRainWater += input[markPosition] - input[i];
 * }
 * else{
 * if (i  == markPosition+1){
 * markPosition =i;
 * currentTrappedRainWater = 0;
 * }
 * else{
 * total+= currentTrappedRainWater;
 * markPosition = 0;
 * currentTrappedrainWater = 0;
 * }
 * }
 * }
 */