package poaug32021;

import java.util.ArrayList;
import java.util.HashMap;

public class SmallestLargestInArray {
    public static void main(String[] args){
        SmallestLargestInArray sla = new SmallestLargestInArray();
        int[] arr = new int[]{0, 0, 1, 2, 3, 3};
        int[] ans = sla.getMinMax(arr);
        System.out.println("The minimum is"+" "+ans[0]);
        System.out.println("The maximum is"+" "+ans[1]);
    }
    //Counting - slower than sorting for smaller inputs
    //Time O(n) Mem O(n)
    public int[] getMinMax(int[] nums) {
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;
        ans[1] = Integer.MIN_VALUE;

        //Count values in the array so we can avoid duplicates later
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            if(!count.containsKey(nums[i])) count.put(nums[i], 0);
            count.replace(nums[i], count.get(nums[i]) + 1);
        }

        //Get min and max
        for(int val: count.keySet()) {
            //skip duplicates
            if(count.get(val) > 1) continue;
            ans[0] = Math.min(ans[0], val);
            ans[1] = Math.max(ans[1], val);
        }
        return ans;
    }
}
