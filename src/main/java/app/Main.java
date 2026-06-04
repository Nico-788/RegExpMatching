package app;

import regexp.MatcherRegex;

public class Main {

	public static void main(String[] args) throws Exception {
        MatcherRegex mr = new MatcherRegex();

        System.out.println(mr.isMatch("aabcd", ".*aa*bcd.*"));
    }
}
