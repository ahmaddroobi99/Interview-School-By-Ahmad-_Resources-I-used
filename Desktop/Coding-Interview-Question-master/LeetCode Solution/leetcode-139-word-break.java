class Solution {
    public boolean wordBreak(String s, List<String> wordList) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
/*
s = leetcode
wordDict = ["leet", "code"]
*/

/*

|T| | | | | | | | |
0 1 2 3 4 5 6 7 8

i = 1
j = o sub = l

i = 2
j = 0 sub = le
j = 1 sub = e

i = 3
j = 0 sub = lee
j = 1 sub = ee
j = 2 sub = e

i = 4
j = 0 sub = leet && T[0] and then break, no need to check for rest
|T | | | |T| | | | |
0 1 2 3 4 5 6 7 8

i = 5
j = 0 sub = leetc
j = 1 sub = eetc
j = 2 sub = etc
j = 3 sub = tc
j = 4 sub = c

i = 6
j = 0 sub = leetco
j = 1 sub = eetco
j = 2 sub = etco
j = 3 sub = tco
j = 4 sub = co
j = 5 sub = o

i = 7
j = 0 sub = leetcod
j = 1 sub = eetcod
j = 2 sub = etcod
j = 3 sub = tcod
j = 4 sub = cod
j = 5 sub = od
j = 6 sub = d

i = 8
j = 0 sub = leetcode
j = 1 sub = eetcode
j = 2 sub = etcode
j = 3 sub = tcode
j = 4 sub = code && T[4] and then break

|T| | | |T| | | | T|
0 1 2 3 4 5 6 7 8
*/




