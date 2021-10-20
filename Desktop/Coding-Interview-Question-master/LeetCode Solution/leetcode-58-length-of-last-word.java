/*
  LeetCode solution playlist: https://www.youtube.com/playlist?list=PL506NMU6kUaDHBeg7iiNo6nRiRfQVCnm4
  Video explanation: https://youtu.be/pRUYGnOHoes
*/
class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        // We are looking for the last word so let's go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // a letter is found so count
                count++;
            } else {  // it's a white space instead
				//  Did we already started to count a word ? Yes so we found the last word
                if (count > 0) return count;
            }
        }
        return count;
    }
}
