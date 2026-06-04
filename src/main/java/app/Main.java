package app;

import regexp.RegExp1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RegExp1 reg = new RegExp1();

		//System.out.println(reg.isMatch(".*bc*b", "ccccccaabb"));
		
		System.out.println(reg.isMatch(".*a.*a.*a.*a.*a.*a.*a.*a.*a.*b",
	                    "aaaaaaaaaaaaaaaaaaaaaaaaaac"));
	}
}
