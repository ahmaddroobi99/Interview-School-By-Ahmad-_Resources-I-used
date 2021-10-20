/*
  Video Explanation: https://youtu.be/VwGTHVtSD7g
*/

class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = s.length - 1;
        while(left < right) {
          char tmp = s[left];
          s[left] = s[right];
          s[right] = tmp;
          left++;
          right--;
        }
    }
}
