package leetcode.two_pointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(new int[]{2,2,2}));
    }

    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int currentCapacity = (heights[l] <= heights[r] ? heights[l] : heights[r]) * (r - l);
            if (currentCapacity > res) {
                res = currentCapacity;
            }

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
