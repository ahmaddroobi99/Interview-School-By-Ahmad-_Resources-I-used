class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int pos = -1, curr = 0, total = 0;

      for (int i = 0; i < gas.length; i++) {
        int diff = gas[i] - cost[i];

        curr += diff;
        total += diff;

        if (curr < 0) {
          curr = 0;
          pos = i;
        }
      }

      if (total >= 0) {
          return pos + 1;
      }

      return -1;
    }
}
