class Solution {
    protected void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> results) {
        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination 
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            // backtrack, remove the number from the combination 
            comb.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
}

/*
    Time complexity is O(2^N) where N is a length of candidates array.
    Space complexity is O(target).

    The runtime: O(2^n)
    T(n) = T(n-1) + T(n-2) + T(n-2) ...
    T(n-1) = T(n-2)+T(n-3)... replace T(n-1) in the above,
    So, T(n) = 2 * [ T(n-2) + T(n-3) ], and so on, T(n) = O(2^n)
*/
