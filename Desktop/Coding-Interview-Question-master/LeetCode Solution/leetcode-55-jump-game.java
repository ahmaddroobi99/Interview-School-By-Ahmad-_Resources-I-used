/*
  LeetCode solution playlist: https://www.youtube.com/playlist?list=PL506NMU6kUaDHBeg7iiNo6nRiRfQVCnm4
  Link to problem: https://leetcode.com/problems/jump-game/
  Video explanation: https://youtu.be/-LC5TsGxXmw
*/
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int prev = len - 2;
        for (int i = len - 1; i >= 0; i++) {
            if (i - prev >= 0 && prev >= 0) {
                prev--;
            }
        }
        if(prev == 0) return true;
        return false;
    }
}
