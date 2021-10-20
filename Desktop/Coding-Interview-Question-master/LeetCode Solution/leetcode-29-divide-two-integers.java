/*  
    Video explanation: https://youtu.be/V20qmx_l2-4
*/
/*
Time Complexity Fixed:
Let say dividend / divisor = N
The complexity will be O((logN)^2).

Take a look at the worst case:
dividend = 1+2+4+8+16... = 2*N + 1
divisor = 2
Then in the first loop, the time complexity will be log(N),
and in the second run, it will reduce to log(N/2) = logN - 1,
so the total number of steps will be 1+2+...+ logN-1+ logN = O((logN)^2).
*/
class Solution {
    public int divide(int dividend, int divisor) {
        System.out.println(1<<2);
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while (absDividend >= absDivisor) {
            long tmp = absDivisor, count = 1;
            while (tmp <= absDividend){
                tmp <<= 1;
                count <<= 1;
            }
            // add the quotient
            result += count >> 1;
            // set remainder to dividend
            absDividend -= tmp >> 1;
        }
        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}

/***Intuitive Solution Without long***/
/*Try solving this problem using the following code*/

class Solution {
      public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A); b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
