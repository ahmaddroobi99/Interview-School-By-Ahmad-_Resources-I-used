
/*
  LeetCode solution playlist: https://www.youtube.com/playlist?list=PL506NMU6kUaDHBeg7iiNo6nRiRfQVCnm4
  Video explanation: https://youtu.be/PqH85flDVDg
*/
class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        for (int i = 0; i < salary.length; i++) {
            minSalary = Math.min(minSalary, salary[i]);
            maxSalary = Math.max(maxSalary, salary[i]);
        }
        double sum = 0;
        for (int i = 0; i < salary.length; i++) {
            if (minSalary != salary[i] && maxSalary != salary[i]) {
                sum += salary[i];
            }
        }
        return sum / (salary.length - 2);
    }
}
