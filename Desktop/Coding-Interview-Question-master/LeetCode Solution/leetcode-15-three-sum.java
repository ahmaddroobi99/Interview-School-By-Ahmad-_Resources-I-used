/*
  Video explanation: https://youtu.be/1aQvO4JPo70
*/
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length < 3)
        	return result;
    	// sort the array in-place
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 2; i++) {
    	    if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
    	        int low = i+1, high = nums.length - 1;
    	        int sum = 0 - nums[i];
                // Finding two sum using two pointer
    	        while (low < high) {
    	           if (nums[low] + nums[high] == sum) {
    	              result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                      // if next number is duplicates skip that
    	              while (low < high && nums[low] == nums[low+1]) low++;
                      // if previous number is duplicates skip that
    	              while (low < high && nums[high] == nums[high-1]) high--;
    	              low++; 
		              high--;
    	           } else if (nums[low] + nums[high] < sum) {
    	              low++;
    	           } else {
    	              high--;
    	           }
    	        }
    	    }
    	}
    	
       return result;
    }
}
