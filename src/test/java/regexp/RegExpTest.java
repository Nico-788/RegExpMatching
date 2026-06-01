package regexp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegExpTest {
	
	@Test
	void testEjemplo1() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("a", "aa");

		assertEquals(false, resultado, "ejemplo 1");
	}
	
	@Test
	void testEjemplo2() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("aa", "aa");

		assertEquals(true, resultado, "ejemplo 2");
	}
	
	@Test
	void testEjemplo3() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("a*", "aa");

		assertEquals(true, resultado, "ejemplo 3");
	}
	
	@Test
	void testEjemplo4() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("a*a*", "aa");

		assertEquals(true, resultado, "ejemplo 4");
	}
	
	@Test
	void testEjemplo5() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*", "aa");

		assertEquals(false, resultado, "ejemplo 5");
	}
	
	@Test
	void testEjemplo6() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aa", "aa");

		assertEquals(true, resultado, "ejemplo 6");
	}
	
	@Test
	void testEjemplo7() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*", "aa");

		assertEquals(true, resultado, "ejemplo 7");
	}
	
	@Test
	void testEjemplo8() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a", "aa");

		assertEquals(false, resultado, "ejemplo 8");
	}
	
	@Test
	void testEjemplo9() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*", "aa");

		assertEquals(true, resultado, "ejemplo 9");
	}
	
	@Test
	void testEjemplo10() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*b", "aab");

		assertEquals(true, resultado, "ejemplo 10");
	}
	
	@Test
	void testEjemplo11() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*b*", "aab");

		assertEquals(true, resultado, "ejemplo 11");
	}
	
	@Test
	void testEjemplo12() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*c*a*b*", "");

		assertEquals(true, resultado, "ejemplo 12");
	}
	
	@Test
	void testEjemplo13() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*c*a*b*c", "");

		assertEquals(false, resultado, "ejemplo 13");
	}
	
	@Test
	void testEjemplo14() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aab");

		assertEquals(false, resultado, "ejemplo 14");
	}
	
	@Test
	void testEjemplo15() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aabc");

		assertEquals(false, resultado, "ejemplo 15");
	}
	
	@Test
	void testEjemplo16() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aa");

		assertEquals(true, resultado, "ejemplo 16");
	}
	
	@Test
	void testEjemplo17() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aac");

		assertEquals(true, resultado, "ejemplo 17");
	}
	
	@Test
	void testEjemplo18() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aaac");

		assertEquals(true, resultado, "ejemplo 18");
	}
	
	@Test
	void testEjemplo19() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "acaac");

		assertEquals(false, resultado, "ejemplo 19");
	}
	
	@Test
	void testEjemplo20() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "acac");

		assertEquals(false, resultado, "ejemplo 20");
	}
	
	@Test
	void testEjemplo21() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "caac");

		assertEquals(true, resultado, "ejemplo 21");
	}
	
	@Test
	void testEjemplo22() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "ccccaac");

		assertEquals(true, resultado, "ejemplo 22");
	}
	
	@Test
	void testEjemplo23() {

		RegExp reg = new RegExp();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aacccaaaccc");

		assertEquals(true, resultado, "ejemplo 22");
	}
	
	@Test
	void testEjemplo24() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".", "a");

	    assertEquals(true, resultado, "ejemplo 24");
	}

	@Test
	void testEjemplo25() {
	    RegExp reg = new RegExp();

		boolean resultado = reg.isMatch(".", "ab");

	    assertEquals(false, resultado, "ejemplo 25");
	}

	@Test
	void testEjemplo26() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*", "");

	    assertEquals(true, resultado, "ejemplo 26");
	}

	@Test
	void testEjemplo27() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*", "abcdef");

	    assertEquals(true, resultado, "ejemplo 27");
	}

	@Test
	void testEjemplo28() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*c", "abc");

	    assertEquals(true, resultado, "ejemplo 28");
	}

	@Test
	void testEjemplo29() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*c", "abd");

	    assertEquals(false, resultado, "ejemplo 29");
	}

	@Test
	void testEjemplo30() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a.*", "a");

	    assertEquals(true, resultado, "ejemplo 30");
	}

	@Test
	void testEjemplo31() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a.*", "abcdef");

	    assertEquals(true, resultado, "ejemplo 31");
	}

	@Test
	void testEjemplo32() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("ab.*f", "abcdef");

	    assertEquals(true, resultado, "ejemplo 32");
	}

	@Test
	void testEjemplo33() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("ab.*g", "abcdef");

	    assertEquals(false, resultado, "ejemplo 33");
	}
	
	@Test
	void testEjemplo34() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*b", "b");

	    assertEquals(true, resultado, "ejemplo 34");
	}

	@Test
	void testEjemplo35() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*b", "aaab");

	    assertEquals(true, resultado, "ejemplo 35");
	}

	@Test
	void testEjemplo36() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*b", "aaac");

	    assertEquals(false, resultado, "ejemplo 36");
	}
	
	@Test
	void testEjemplo37() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*a", "ba");

	    assertEquals(true, resultado, "ejemplo 37");
	}

	@Test
	void testEjemplo38() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*a", "baa");

	    assertEquals(true, resultado, "ejemplo 38");
	}

	@Test
	void testEjemplo39() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*a", "bbb");

	    assertEquals(false, resultado, "ejemplo 39");
	}
	
	@Test
	void testEjemplo40() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("mis*is*p*.", "mississippi");

	    assertEquals(false, resultado, "ejemplo 40");
	}
	
	@Test
	void testEjemplo41() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("mis*is*ip*.", "mississippi");

	    assertEquals(true, resultado, "ejemplo 41");
	}

	@Test
	void testEjemplo42() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("c*a*b", "aab");

	    assertEquals(true, resultado, "ejemplo 42");
	}
	
	@Test
	void testEjemplo43() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*a", "aaa");

	    assertEquals(true, resultado, "ejemplo 43");
	}
	
	@Test
	void testEjemplo44() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("c*ca*b", "aab");

	    assertEquals(false, resultado, "ejemplo 44");
	}
	
	@Test
	void testEjemplo45() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("c*ccca*b", "caab");

	    assertEquals(false, resultado, "ejemplo 45");
	}
	
	@Test
	void testEjemplo46() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("c*ca*b", "caab");

	    assertEquals(true, resultado, "ejemplo 46");
	}
	
	@Test
	void testEjemplo47() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("c*ca*b", "cccccaab");

	    assertEquals(true, resultado, "ejemplo 47");
	}
	
	@Test
	void testEjemplo48() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("c*ca*b", "aab");

	    assertEquals(false, resultado, "ejemplo 48");
	}
	
	@Test
	void testEjemplo49() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("cccc*ccca*b", "ccccccaab");

	    assertEquals(true, resultado, "ejemplo 49");
	}
	
	@Test
	void testEjemplo50() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("cccc*a*b", "ccccccaab");

	    assertEquals(true, resultado, "ejemplo 50");
	}
	
	@Test
	void testEjemplo51() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("", "");

	    assertEquals(true, resultado, "ejemplo 51");
	}
	
	@Test
	void testEjemplo52() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("", "a");

	    assertEquals(false, resultado, "ejemplo 52");
	}
	
	@Test
	void testEjemplo53() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a", "");

	    assertEquals(false, resultado, "ejemplo 53");
	}
	
	@Test
	void testEjemplo54() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*", "");

	    assertEquals(true, resultado, "ejemplo 54");
	}
	
	@Test
	void testEjemplo55() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".", "");

	    assertEquals(true, resultado, "ejemplo 55");
	}
	
	@Test
	void testEjemplo56() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*", "");

	    assertEquals(true, resultado, "ejemplo 56");
	}
	
	@Test
	void testEjemplo57() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*", "adfgadfgfd");

	    assertEquals(true, resultado, "ejemplo 57");
	}
	
	@Test
	void testEjemplo58() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("e.*", "adfgadfgfd");

	    assertEquals(false, resultado, "ejemplo 58");
	}
	
	@Test
	void testEjemplo59() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("..*", "adfgadfgfd");

	    assertEquals(true, resultado, "ejemplo 59");
	}
	
	@Test
	void testEjemplo60() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("..*.", "adfgadfgfd");

	    assertEquals(true, resultado, "ejemplo 60");
	}
	
	@Test
	void testEjemplo61() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("..*.a", "adfgadfgfd");

	    assertEquals(false, resultado, "ejemplo 61");
	}
	
	@Test
	void testEjemplo62() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("..*.a*", "adfgadfgfd");

	    assertEquals(true, resultado, "ejemplo 62");
	}
	
	@Test
	void testEjemplo63() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("..*.a*a", "adfgadfgfd");

	    assertEquals(false, resultado, "ejemplo 63");
	}
	
	@Test
	void testEjemplo64() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("..*.a*aaaaa", "adfgadfgfdaaaa");

	    assertEquals(false, resultado, "ejemplo 64");
	}
	
	@Test
	void testEjemplo65() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("..*.a*aaaaaa", "adfgadfgfdaaaaaaa");

	    assertEquals(true, resultado, "ejemplo 65");
	}
	
	@Test
	void testEjemplo66() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("..*.a*a", "adfgadfgfda");

	    assertEquals(true, resultado, "ejemplo 66");
	}
	
	@Test
	void testEjemplo67() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*b", "aaaaaaaaab");

	    assertEquals(true, resultado, "ejemplo 67");
	}
	
	@Test
	void testEjemplo68() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*b", "aaaaaaaaac");

	    assertEquals(false, resultado, "ejemplo 68");
	}
	
	@Test
	void testEjemplo69() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*.*.*.*b", "aaaaaaaaab");

	    assertEquals(true, resultado, "ejemplo 69");
	}
	
	@Test
	void testEjemplo70() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*.*.*.*b", "aaaaaaaaac");

	    assertEquals(false, resultado, "ejemplo 70");
	}
	
	@Test
	void testEjemplo71() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*a.*b.*c", "zzzazzzbzzzc");

	    assertEquals(true, resultado, "ejemplo 71");
	}
	
	@Test
	void testEjemplo72() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*a.*b.*c", "zzzazzzczzzb");

	    assertEquals(false, resultado, "ejemplo 72");
	}
	
	@Test
	void testEjemplo73() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*b*c*d*e*", "");

	    assertEquals(true, resultado, "ejemplo 73");
	}
	
	@Test
	void testEjemplo74() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch("a*b*c*d*e*f", "");

	    assertEquals(false, resultado, "ejemplo 74");
	}
	
	@Test
	void testEjemplo75() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*abc", "xyzabc");

	    assertEquals(true, resultado, "ejemplo 75");
	}
	
	@Test
	void testEjemplo76() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(".*abc", "xyzabx");

	    assertEquals(false, resultado, "ejemplo 76");
	}
	
	@Test
	void testEjemplo77() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b",
	        "aaaaaaaaaaaaaaaaaaaab"
	    );

	    assertEquals(true, resultado, "ejemplo 77");
	}
	
	@Test
	void testEjemplo78() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        "a*a*a*a*a*a*a*a*a*a*c",
	        "aaaaaaaaaaaaaaaaab"
	    );

	    assertEquals(false, resultado, "ejemplo 78");
	}
	
	@Test
	void testEjemplo79() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        ".*.*.*.*.*",
	        "abcdefghijklmnopqrstuvwxyz"
	    );

	    assertEquals(true, resultado, "ejemplo 79");
	}
	
	@Test
	void testEjemplo80() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        ".*a",
	        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	    );

	    assertEquals(true, resultado, "ejemplo 80");
	}
	
	@Test
	void testEjemplo81() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        ".*b.*c.*d",
	        "aaaaaaaaabaaaaaaaaacaaaaaaaaad"
	    );

	    assertEquals(true, resultado, "ejemplo 81");
	}
	
	@Test
	void testEjemplo82() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        ".*b.*c.*d",
	        "aaaaaaaaabaaaaaaaaadaaaaaaaaac"
	    );

	    assertEquals(false, resultado, "ejemplo 82");
	}
	
	@Test
	void testEjemplo83() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b",
	        "aaaaaaaaaaaaaaaaaaaaab"
	    );

	    assertEquals(true, resultado);
	}
	
	@Test
	void testEjemplo84() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b",
	        "aaaaaaaaaaaaaaaaaaaaac"
	    );

	    assertEquals(false, resultado);
	}
	
	@Test
	void testEjemplo85() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        ".*.*.*.*.*.*.*.*x",
	        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaax"
	    );

	    assertEquals(true, resultado);
	}
	
	@Test
	void testEjemplo86() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        "a*a*a*a*a*a*a*a*a*a*c",
	        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
	    );

	    assertEquals(false, resultado);
	}
	
	@Test
	void testEjemplo87() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        ".*.*.*.*.*.*.*.*.*.*",
	        "aaaaaaaaaaaaaaaaaaaa"
	    );

	    assertEquals(true, resultado);
	}
	
	@Test
	void testEjemplo88() {
	    RegExp reg = new RegExp();

	    boolean resultado = reg.isMatch(
	        "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b",
	        "aaaaaaaaaaaaaaaaaaaaac"
	    );
	    
	    System.out.println("cantidad de llamadas: " + reg.getLlamadas());

	    assertEquals(false, resultado);
	}
}
