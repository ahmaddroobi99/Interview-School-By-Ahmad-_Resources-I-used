/*
    532: K-diff Pairs in an Array ~ Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
*/

public class Solution {
    public int findPairs(int[] nums, int k) {        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count number of elements in the array, appear more than or equal twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
