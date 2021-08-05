package poaug32021;

public class MissingElement {
    public static void main(String[] args){
        MissingElement me = new MissingElement();
        int[] arr = new int[]{1, 2, 0, 3};
        System.out.println("The missing element is"+" "+me.getMissingInRange(arr));
    }
    //Array marking techinque
    //BUG - this only works assuming numbers are within range 0 - size of nums
    //Time O(n) Mem O(1)
    public int getMissingInRange(int[] nums) {
        //Array Marking
        int missing = nums.length+1;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == nums.length) missing = 0;
            if(nums[i] == 0 || nums[i] > nums.length) continue;
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) nums[index] *= -1;
        }

        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] > 0) return i+1;
        }
        return missing;
    }
}
