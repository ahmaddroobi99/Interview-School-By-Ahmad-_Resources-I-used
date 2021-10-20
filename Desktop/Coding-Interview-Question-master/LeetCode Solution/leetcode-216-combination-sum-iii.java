/*
  Video explanation: https://youtu.be/12t3_9DCNss
  LeetCode solution playlist: https://www.youtube.com/playlist?list=PL506NMU6kUaDHBeg7iiNo6nRiRfQVCnm4
*/
class Solution {
    protected void backtrack(int remain, int k,
            LinkedList<Integer> comb, int next_start,
            List<List<Integer>> results) {

        if (remain == 0 && comb.size() == k) {
            // Note: it's important to make a deep copy here.
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0 || comb.size() == k) {
            // Exceed the scope, no need to explore further.
            return;
        }
        // Iterate through the reduced list of candidates.
        for (int i = next_start; i < 9; ++i) {
            comb.add(i + 1);
            this.backtrack(remain - i - 1, k, comb, i + 1, results);
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(n, k, comb, 0, results);
        return results;
    }
}
