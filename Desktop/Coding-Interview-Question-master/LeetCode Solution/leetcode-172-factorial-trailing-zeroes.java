class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}

/*

First, let's think about in what situation will we get a trailing zero. We get a trailing zero whenever we multiply a non zero number by 10.

Example: 1 * 10 = 10

Since 10 is made up of multiplying 2 by 5, another way to get a trailing zero is to multiply a non zero number by 2 and 5.

Example: 1 * 2 * 5 = 10

So, to count the number of trailing zeroes we just need to figure out how many times we multiply 2 by 5.

Example:
1 * (2 * 5) = 10 // one trailing zero
1 * (2 * 5) * (2 * 5) = 100 // two trailing zeroes

Now let's look at factorial.

The factorial of 5 is:
1 * 2 * 3 * 4 * 5 = 120
Since we have multiplied 2 and 5 once, there is one trailing zero.

The factorial of 10 is:
1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 = 3628800
Another way to write this is:
1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 2 * 5 = 3628800
As you can see, we have multiplied 2 and 5 twice, so there are two trailing zeroes.

Instead of keeping track of the number of 2s and 5s, we really just need to keep track of the number of 5s. This is because in any factorial calculation there are always going to be more multiples of 2 than 5.

Example: From the numbers 1 to 10, there are five multiples of 2 but only two multiples of 5.

Question: How many 5s are there in the factorial of 25?
You may guess the answer is 25 / 5 = 5, however there are actually 6.

Here are all the multiples of 5 in the factorial of 25:
5, 10, 15, 20, 25
Another way to write this is:
(5 * 1), (5 * 2), (5 * 3), (5 * 4), (5 * 5)
As you can see, 5 is actually multiplied 6 times.

We can simplify the answer to the Factorial Trailing Zeroes question to the following:
(n / 5) + (n / 5^2) + (n / 5^3)... (n / 5^x)
We continue until 5^x is greater than n.

*/
