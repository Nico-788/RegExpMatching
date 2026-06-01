package app;

import regexp.RegExp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RegExp reg = new RegExp();

		//System.out.println(reg.isMatch(".*bc*b", "ccccccaabb"));
		
		StringBuilder regex = new StringBuilder();
		StringBuilder cadena = new StringBuilder();

		for(int i = 0; i < 50; i++) {
		    regex.append("a*");
		    cadena.append("a");
		}

		regex.append("b");
		cadena.append("c");

		System.out.println(
		    reg.isMatch(regex.toString(), cadena.toString())
		);
	}
	
	
}
