package app;

import regexp.RegExp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RegExp reg = new RegExp();

		//System.out.println(reg.isMatch(".*bc*b", "ccccccaabb"));
		
//		StringBuilder regex = new StringBuilder();
//		StringBuilder cadena = new StringBuilder();
//
//		for(int i = 0; i < 50; i++) {
//		    regex.append("a*");
//		    cadena.append("a");
//		}
//
//		regex.append("b");
//		cadena.append("c");
//
//		System.out.println(
//		    reg.isMatch(regex.toString(), cadena.toString())
//		);
		
		Solution sol = new Solution();
		
		System.out.println(sol.isMatch(".*a.*a.*a.*a.*a.*a.*a.*a.*a.*b",
	                    "aaaaaaaaaaaaaaaaaaaaaaaaaac"));
	}
	
	private static class Solution {
	    private Boolean[][] f;
	    private String s;
	    private String p;
	    private int m;
	    private int n;

	    public boolean isMatch(String s, String p) {
	        m = s.length();
	        n = p.length();
	        f = new Boolean[m + 1][n + 1];
	        this.s = s;
	        this.p = p;
	        return dfs(0, 0);
	    }

	    private boolean dfs(int i, int j) {
	        if (j >= n) {
	            return i == m;
	        }
	        if (f[i][j] != null) {
	            return f[i][j];
	        }
	        boolean res = false;
	        if (j + 1 < n && p.charAt(j + 1) == '*') {
	            res = dfs(i, j + 2)
	                || (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(i + 1, j));
	        } else {
	            res = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(i + 1, j + 1);
	        }
	        return f[i][j] = res;
	    }
	}
	
	
}
