/*
  Video explanation: https://youtu.be/8EF1nphtJIs
*/

class Solution {
    public int[] plusOne(int[] digits) {
        // intially set curry to 1
        int curry = 1;
        for (int i = digits.length - 1; i >= 0 && curry == 1; i--) {
            int tmp = digits[i] + curry;
            // if we have nums[i] + 1 >= 10
            if (tmp >= 10) {
                curry = 1;
                digits[i] = tmp % 10;
            } else {
                curry = 0;
                digits[i] = tmp;
            }
        }
        // if we have input like [9,9,9] then we will have curry = 1
        // so in this case we have an or of length len(digits) + 1
        // first digits is 1 and rest copy from digits to newDigits array
        if (curry != 0) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i-1];s
            }
            return newDigits;
        }
        return digits;
    }
}
