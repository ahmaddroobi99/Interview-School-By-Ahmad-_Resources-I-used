// Video explanation: https://youtu.be/IJNSof5g09M

class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int num = 0;
        while (num < N) {
            num = (num << 1) | 1;
        }
        return ~N & num;
    }
}
