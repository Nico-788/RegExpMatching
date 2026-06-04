package regexp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegExpTest {

	@Test
	void testEjemplo1() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 1");
	}

	@Test
	void testEjemplo2() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("aa", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 2");
	}

	@Test
	void testEjemplo3() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 3");
	}

	@Test
	void testEjemplo4() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 4");
	}

	@Test
	void testEjemplo5() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 5");
	}

	@Test
	void testEjemplo6() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aa", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 6");
	}

	@Test
	void testEjemplo7() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 7");
	}

	@Test
	void testEjemplo8() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 8");
	}

	@Test
	void testEjemplo9() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 9");
	}

	@Test
	void testEjemplo10() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*b", "aab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 10");
	}

	@Test
	void testEjemplo11() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*b*", "aab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 11");
	}

	@Test
	void testEjemplo12() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*c*a*b*", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 12");
	}

	@Test
	void testEjemplo13() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*c*a*b*c", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 13");
	}

	@Test
	void testEjemplo14() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 14");
	}

	@Test
	void testEjemplo15() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aabc");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 15");
	}

	@Test
	void testEjemplo16() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 16");
	}

	@Test
	void testEjemplo17() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 17");
	}

	@Test
	void testEjemplo18() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 18");
	}

	@Test
	void testEjemplo19() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "acaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 19");
	}

	@Test
	void testEjemplo20() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "acac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 20");
	}

	@Test
	void testEjemplo21() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "caac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 21");
	}

	@Test
	void testEjemplo22() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "ccccaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 22");
	}

	@Test
	void testEjemplo23() {

		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*aac*a*c*", "aacccaaaccc");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 22");
	}

	@Test
	void testEjemplo24() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".", "a");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 24");
	}

	@Test
	void testEjemplo25() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".", "ab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 25");
	}

	@Test
	void testEjemplo26() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 26");
	}

	@Test
	void testEjemplo27() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*", "abcdef");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 27");
	}

	@Test
	void testEjemplo28() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*c", "abc");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 28");
	}

	@Test
	void testEjemplo29() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*c", "abd");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 29");
	}

	@Test
	void testEjemplo30() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a.*", "a");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 30");
	}

	@Test
	void testEjemplo31() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a.*", "abcdef");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 31");
	}

	@Test
	void testEjemplo32() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("ab.*f", "abcdef");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 32");
	}

	@Test
	void testEjemplo33() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("ab.*g", "abcdef");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 33");
	}

	@Test
	void testEjemplo34() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*b", "b");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 34");
	}

	@Test
	void testEjemplo35() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*b", "aaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 35");
	}

	@Test
	void testEjemplo36() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*b", "aaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 36");
	}

	@Test
	void testEjemplo37() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*a", "ba");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 37");
	}

	@Test
	void testEjemplo38() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*a", "baa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 38");
	}

	@Test
	void testEjemplo39() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*a", "bbb");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 39");
	}

	@Test
	void testEjemplo40() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("mis*is*p*.", "mississippi");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 40");
	}

	@Test
	void testEjemplo41() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("mis*is*ip*.", "mississippi");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 41");
	}

	@Test
	void testEjemplo42() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*a*b", "aab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 42");
	}

	@Test
	void testEjemplo43() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a", "aaa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 43");
	}

	@Test
	void testEjemplo44() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*ca*b", "aab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 44");
	}

	@Test
	void testEjemplo45() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*ccca*b", "caab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 45");
	}

	@Test
	void testEjemplo46() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*ca*b", "caab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 46");
	}

	@Test
	void testEjemplo47() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*ca*b", "cccccaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 47");
	}

	@Test
	void testEjemplo48() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("c*ca*b", "aab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 48");
	}

	@Test
	void testEjemplo49() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("cccc*ccca*b", "ccccccaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 49");
	}

	@Test
	void testEjemplo50() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("cccc*a*b", "ccccccaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 50");
	}

	@Test
	void testEjemplo51() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 51");
	}

	@Test
	void testEjemplo52() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("", "a");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 52");
	}

	@Test
	void testEjemplo53() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 53");
	}

	@Test
	void testEjemplo54() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 54");
	}

	@Test
	void testEjemplo55() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 55");
	}

	@Test
	void testEjemplo56() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 56");
	}

	@Test
	void testEjemplo57() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*", "adfgadfgfd");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 57");
	}

	@Test
	void testEjemplo58() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("e.*", "adfgadfgfd");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 58");
	}

	@Test
	void testEjemplo59() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("..*", "adfgadfgfd");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 59");
	}

	@Test
	void testEjemplo60() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("..*.", "adfgadfgfd");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 60");
	}

	@Test
	void testEjemplo61() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("..*.a", "adfgadfgfd");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 61");
	}

	@Test
	void testEjemplo62() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("..*.a*", "adfgadfgfd");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 62");
	}

	@Test
	void testEjemplo63() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("..*.a*a", "adfgadfgfd");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 63");
	}

	@Test
	void testEjemplo64() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("..*.a*aaaaa", "adfgadfgfdaaaa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 64");
	}

	@Test
	void testEjemplo65() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("..*.a*aaaaaa", "adfgadfgfdaaaaaaa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 65");
	}

	@Test
	void testEjemplo66() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("..*.a*a", "adfgadfgfda");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 66");
	}

	@Test
	void testEjemplo67() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*b", "aaaaaaaaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 67");
	}

	@Test
	void testEjemplo68() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*b", "aaaaaaaaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 68");
	}

	@Test
	void testEjemplo69() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*.*.*.*b", "aaaaaaaaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 69");
	}

	@Test
	void testEjemplo70() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*.*.*.*b", "aaaaaaaaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 70");
	}

	@Test
	void testEjemplo71() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*a.*b.*c", "zzzazzzbzzzc");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 71");
	}

	@Test
	void testEjemplo72() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*a.*b.*c", "zzzazzzczzzb");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 72");
	}

	@Test
	void testEjemplo73() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*b*c*d*e*", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 73");
	}

	@Test
	void testEjemplo74() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*b*c*d*e*f", "");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 74");
	}

	@Test
	void testEjemplo75() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*abc", "xyzabc");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 75");
	}

	@Test
	void testEjemplo76() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*abc", "xyzabx");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 76");
	}

	@Test
	void testEjemplo77() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b", "aaaaaaaaaaaaaaaaaaaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 77");
	}

	@Test
	void testEjemplo78() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*a*a*c", "aaaaaaaaaaaaaaaaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 78");
	}

	@Test
	void testEjemplo79() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*.*.*.*.*", "abcdefghijklmnopqrstuvwxyz");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 79");
	}

	@Test
	void testEjemplo80() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*a", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 80");
	}

	@Test
	void testEjemplo81() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*b.*c.*d", "aaaaaaaaabaaaaaaaaacaaaaaaaaad");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado, "ejemplo 81");
	}

	@Test
	void testEjemplo82() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*b.*c.*d", "aaaaaaaaabaaaaaaaaadaaaaaaaaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado, "ejemplo 82");
	}

	@Test
	void testEjemplo83() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b", "aaaaaaaaaaaaaaaaaaaaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado);
	}

	@Test
	void testEjemplo84() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b", "aaaaaaaaaaaaaaaaaaaaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado);
	}

	@Test
	void testEjemplo85() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*.*.*.*.*.*.*.*x", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaax");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado);
	}

	@Test
	void testEjemplo86() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*a*a*c", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado);
	}

	@Test
	void testEjemplo87() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*.*.*.*.*.*.*.*.*.*", "aaaaaaaaaaaaaaaaaaaa");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(true, resultado);
	}

	@Test
	void testEjemplo88() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch("a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b", "aaaaaaaaaaaaaaaaaaaaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado);
	}

	@Test
	void testEjemplo89() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*a.*a.*a.*a.*a.*a.*a.*a.*a.*b", "aaaaaaaaaaaaaaaaaaaaaaaaaac");

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado);
	}

	@Test
	void testEjemplo90() {
		RegExp1 reg = new RegExp1();

		boolean resultado = reg.isMatch(".*a.*a.*a.*a.*a.*a.*a.*a.*a.*a.*a.*a.*b",
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac");

		// observar crecimiento del algoritmo

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado);
	}

	@Test
	void testEjemplo91() {
		RegExp1 reg = new RegExp1();

		StringBuilder regex = new StringBuilder();
		StringBuilder cadena = new StringBuilder();

		for (int i = 0; i < 50; i++) {
			regex.append("a*");
			cadena.append("a");
		}

		regex.append("b");
		cadena.append("c");

		boolean resultado = reg.isMatch(regex.toString(), cadena.toString());

		// observar crecimiento del algoritmo

		System.out.println("cantidad de llamadas: " + reg.getLlamadas());
		System.out.println("cantidad de estados: " + reg.getCantidadEstados());

		assertEquals(false, resultado);
	}
}
