/*
  LeetCode solution playlist: https://www.youtube.com/playlist?list=PL506NMU6kUaDHBeg7iiNo6nRiRfQVCnm4
  Video explanation: https://youtu.be/P0-WwCzFzV8
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
