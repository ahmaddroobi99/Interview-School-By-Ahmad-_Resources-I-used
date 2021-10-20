/*
    Contributed by: Md. A. Barik
    Video Explanation: https://youtu.be/flTxRaeUNtc
*/

public class OneEditAway {
    public static void main(String[] args) {
        // The following input value for test
        isOneAway("abcde", "abcd");  // should return true
        isOneAway("abde", "abcde");  // should return true
        isOneAway("a", "a");  // should return true
        isOneAway("abcdef", "abqdef");  // should return true
        isOneAway("abcdef", "abccef");  // should return true
        isOneAway("abcdef", "abcde");  // should return true
        isOneAway("aaa", "abc");  // should return false
        isOneAway("abcde", "abc");  // should return false
        isOneAway("abc", "abcde");  // should return false
        isOneAway("abc", "bcc");  // should return false
    }

    public static Boolean isOneAway(String s1, String s2) {
        if (s1.length() - s2.length() >= 2 || s2.length() - s1.length() >= 2) {
            return false;
        } else if (s1.length() == s2.length()) {
            return isOneAwaySameLength(s1, s2);
        } else if (s1.length() > s2.length()) {
            return isOneAwayDiffLengths(s1, s2);
        } else {
            return isOneAwayDiffLengths(s2, s1);
        }
    }

    public static Boolean isOneAwaySameLength(String s1, String s2) {
        int countDiff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                countDiff += 1;
                if (countDiff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // s1.length() == s2.length() + 1
    public static Boolean isOneAwayDiffLengths(String s1, String s2) {
        int i = 0;
        int countDiff = 0;
        while (i < s2.length()) {
            if (s1.charAt(i + countDiff) == s2.charAt(i)) {
                i += 1;
            } else {
                countDiff += 1;
            }
            if (countDiff > 1) {
                return false;
            }
        }
        return true;
    }
}
