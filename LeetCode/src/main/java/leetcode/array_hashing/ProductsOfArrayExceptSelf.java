package leetcode.array_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsOfArrayExceptSelf {

    public static void main(String[] args){
        ProductsOfArrayExceptSelf solution = new ProductsOfArrayExceptSelf();
        int[] res = solution.productExceptSelf(new int[]{-1,0,1,0,3});
        System.out.println(Arrays.toString(res));
    }

    public int[] productExceptSelf(int[] nums) {

        List<Integer> positionOfZero = new ArrayList<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length;i++){
            if (nums[i] == 0){
                positionOfZero.add(i);
            }
        }

        if (positionOfZero.size() > 1){
            return result;
        }

        if (positionOfZero.size() == 1){
            int idx = positionOfZero.get(0);
            int temp = 1;
            for (int i = 0; i < nums.length;i ++){
                if (i != idx){
                    temp*=nums[i];
                }
            }
            result[idx] = temp;
            return result;
        }
        int totalProduct = 1;
        for (int i = 0; i < nums.length;i++){
            totalProduct*=nums[i];
        }

        for (int i = 0 ; i < nums.length;i++){
            result[i] = totalProduct / nums[i];
        }


        return result;
    }

}
