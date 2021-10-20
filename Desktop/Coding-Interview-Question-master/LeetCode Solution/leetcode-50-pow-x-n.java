class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long num = n;
        if (n < 0) {
            num = -1 * num;
        }
        while (num > 0) {
            if (num % 2 == 0) {
                x = x * x;
                num = num / 2;
            } else {
                ans = ans * x;
                num = num - 1;
            }
        }
        if (n < 0) {
            return (double)(1.0) / (double)(ans);
        }
        return ans;
    }  
}

/*
2.0 ^ 2
    4 ^ 1
    ans = 1
    while n is greater than zero:
        if n is divisible by 2:
            x = x * x
            n = n / 2;
        else:
            ans = ans * x; // ans = 4
            n = n - 1
                
O(log(n))
*/
