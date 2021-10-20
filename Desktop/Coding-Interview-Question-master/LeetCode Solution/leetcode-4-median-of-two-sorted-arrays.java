class Solution {
    private double findMedian(int[] A, int[] B) {        
        int m = A.length;
        int n = B.length;
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            
            int j = halfLen - i;
            
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                System.out.println(i);
                iMax = i - 1; // i is too big
                System.out.println(iMax);
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                //System.out.println(j);
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        if (len1 > len2) {
            return findMedian(B, A);
        } else {
            return findMedian(A, B);
        }
    }
}
