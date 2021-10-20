class Solution {
    public int[] countBits(int num) {
        int[] bit1s = new int[num + 1];
        for (int i = 1, j = 0; i <= num; i++) {
            if (j == 0) {
                j++;
                bit1s[i] = 1;
            } else if (i == j * 2) {
                bit1s[i] = 1;
                j <<= 1;
                continue;
            }
            bit1s[i] = bit1s[j] + bit1s[i - j];
        }
        return bit1s;
    }
}
