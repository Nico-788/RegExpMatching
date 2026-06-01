package app;

import regexp.RegExp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RegExp reg = new RegExp();

		System.out.println(reg.isMatch(".*bc*b", "ccccccaabb"));
	}

}
