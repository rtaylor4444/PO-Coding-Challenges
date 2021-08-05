package poaug32021;

public class LCS {
    public static void main(String[] args){
        LCS lcs = new LCS();
        String s1 = "Minneapolis";
        String s2 = "Minnesota";

        System.out.println("The LCS is"+" "+lcs.getLCS(s1, s2));
    }

    //Space Optimized DP
    //Time O(n^2) Mem O(n)
    public int getLCS(String a, String b) {
        //Java sets to 0 by default
        int[][] dp = new int[2][b.length()+1];
        //Calc the rest of the array
        for(int i = 1; i <= a.length(); ++i) {
            for(int j = 1; j <= b.length(); ++j) {
                //if chars are equal add one to our subsequence chain
                if(a.charAt(i-1) == b.charAt(j-1)) dp[i%2][j] = dp[(i-1)%2][j-1] + 1;
                //otherwise take the largest chain
                else dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[i%2][j-1]);
                //System.out.print(dp[i%2][j] + " ");
            }
            //System.out.println(" ");
        }
        return dp[a.length()%2][b.length()];
    }
}
