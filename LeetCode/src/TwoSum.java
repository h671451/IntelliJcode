public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] newArray = new int[2];
        for(int i = 0; i<nums.length; i++){
            if((nums[i] + nums[i+1]) == target){
             newArray[0] =  nums[i];
             newArray[1] = nums[i+1];
            }
        }

        return newArray;

    }
}
