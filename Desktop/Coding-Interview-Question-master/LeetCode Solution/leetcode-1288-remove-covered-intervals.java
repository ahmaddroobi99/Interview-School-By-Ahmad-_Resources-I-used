
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int removed = 0, last = -1;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        
        for (int[] i : intervals) {
            if (i[1] <= last) {
                removed += 1;
            } else {
                last = i[1];
            }
        }
        return intervals.length - removed;
    }
}
