class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // nums = [1], k = 1
        int count = 0;
        int left = 0;
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[left++];
            }
            count += i - left + 1;
        }
        return count;
    }
}

