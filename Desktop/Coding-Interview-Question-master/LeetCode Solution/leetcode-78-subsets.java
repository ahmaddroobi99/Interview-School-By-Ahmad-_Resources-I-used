/*
Problem Statement:
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    List<List<Integer>> ans = new ArrayList();
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums, int k) {
        if (curr.size() > k) return;
        if (curr.size() == k) {
            ans.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, k);
            curr.remove(curr.size() - 1);
        }
        return;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        for (int k = 0; k <= nums.length; k++) {
            backtrack(0, new ArrayList<Integer>(), nums, k);
        }
        return ans;
    }
    
}

