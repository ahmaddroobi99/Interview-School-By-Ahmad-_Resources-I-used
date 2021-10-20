class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }     
    private int rob(int[] nums, int start, int end) {
        int max = 0;
        int p1 = 0;
        int p2 = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(p2 + nums[i], p1);
            p2 = p1;
            p1 = max;
        }
        return max;
    }
}

