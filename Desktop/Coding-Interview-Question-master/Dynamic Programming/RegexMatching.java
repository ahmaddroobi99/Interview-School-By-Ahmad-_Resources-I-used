/*
    Contributed by Md. A. Barik
    Video on TechBarik YouTube channel - https://www.youtube.com/watch?v=DrPKvbCjmbo
*/
public class RegexMatching {

	public static void main(String args[]) {
        String s = "axyb";
        String p = "a.*b";
        System.out.println(is_match(s.toCharArray(), p.toCharArray()));
    }

    public static boolean is_match(char[] s, char[] p) {
	// constractng a dynamic programming table T (2D array)
        boolean T[][] = new boolean[s.length + 1][p.length + 1];

        T[0][0] = true;
        //For a* or a*b* or p that can match with empty string
        for (int i = 1; i < T[0].length; i++) {
            if (p[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (p[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (p[j-2] == '.' || p[j - 2] == s[i - 1]) {
                        T[i][j] = T[i][j] || T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[s.length][p.length];
    }
}
