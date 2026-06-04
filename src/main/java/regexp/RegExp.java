package regexp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class RegExp {
	private long llamadas = 0;
	private Map<Tupla, Boolean> solucionesBackTrack;
	private String p;
	private String s;

	public RegExp() {

	}

	public boolean isMatch(String regex, String cadena) {

		System.out.println("\n=================================");
		System.out.println("INICIO generarRegex1");
		System.out.println("regex  = [" + regex + "]");
		System.out.println("cadena = [" + cadena + "]");
		System.out.println("=================================\n");

		int matchsEsperadosRestantes = cadena.length();

		IteradorCadena reg = new IteradorCadena(regex);
		IteradorCadena cad = new IteradorCadena(cadena);

		llamadas = 0;
		solucionesBackTrack = new HashMap<Tupla, Boolean>();

		return generarRegex2RecLogs(reg, cad, matchsEsperadosRestantes, false);
	}

	public long getLlamadas() {
		return llamadas;
	}
	
	public long getCantidadEstados() {
		int estadosCalculados = 0;
		
		for (Entry<Tupla, Boolean> entry : solucionesBackTrack.entrySet()) {
			Tupla clave = entry.getKey();
			boolean valor = entry.getValue();
			
			estadosCalculados++;
		}
		
		return estadosCalculados;
	}
	
	

	public boolean generarRegex2RecLogs(IteradorCadena reg, IteradorCadena cad, int matchsEsperadosRestantes,
			boolean missMatchPrevio) {

		llamadas++;

		if (llamadas % 1000 == 0) {
			System.out.println("LLAMADAS=" + llamadas + " reg=" + reg.getPosActual() + " cad=" + cad.getPosActual()
					+ " restantes=" + matchsEsperadosRestantes);
		}
		System.out.println(llamadas); // DEBUG TEMPORAL

		Secuencia sec = new Secuencia();
		boolean quedaPorVerificar = true; // relativo a la secuencia paralela actual (sea regex: a*bc y cadena: aaabc ->
											// cuando llega b => quedaPorVerificar = false)
		boolean missMatchActual = false;
		IteradorCadena backTrackRegRef = new IteradorCadena(reg);
		IteradorCadena backTrackReg = null;
		IteradorCadena backTrackCad = null;

		System.out.println("=== ENTRADA ===");
		System.out.println("reg.pos = " + reg.getPosActual());
		System.out.println("cad.pos = " + cad.getPosActual());
		System.out.println("restantes = " + matchsEsperadosRestantes);
		System.out.println("missMatchPrevio = " + missMatchPrevio);

		System.out.println("\n=================================");
		System.out.println("BUSCANDO NUEVA SECUENCIA");
		System.out.println("Pos regex: " + reg.getPosActual());
		System.out.println("=================================");

		sec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(reg);

		System.out.println("Secuencia obtenida:");
		System.out.println(sec);

		if (sec != null && !missMatchPrevio) {
			if (sec.getCaracter() == '.' && sec.getTipoSecuencia() >= 1 && reg.finDeCadena() == false) {
							
				backTrackReg = new IteradorCadena(reg);
				backTrackCad = new IteradorCadena(cad);
				Tupla clave = new Tupla(backTrackRegRef.getPosActual(), cad.getPosActual());
				boolean res;

				if (solucionesBackTrack.containsKey(clave)) {
					System.out.println("MEMO -> [" + backTrackRegRef.getPosActual() + ", " + (cad.getPosActual()) + "]");
					return solucionesBackTrack.get(clave);
				}
				
				if (cad.tieneSiguiente()) {
					backTrackCad.setPosActual(cad.getPosActual() + 1);
				}

				System.out.println("=== RECURSIÓN BACKTRACKING ===");
				System.out.println("restantes = " + (matchsEsperadosRestantes));
				System.out.println("missMatchActual = " + missMatchActual);

				System.out.println("RAMA 1");
				System.out.println("reg=" + backTrackRegRef.getPosActual() + " cad=" + backTrackCad.getPosActual());

				System.out.println("RAMA 2");
				System.out.println("reg=" + backTrackReg.getPosActual() + " cad=" + cad.getPosActual());

				// sec '.*' expandiendo desde una pos más de cadena
				// sigSec evaluando desde pos de cadena actual

				if (matchsEsperadosRestantes >= 0) {
					res = generarRegex2RecLogs(new IteradorCadena(backTrackRegRef), backTrackCad, matchsEsperadosRestantes - 1,
									missMatchActual)
							|| generarRegex2RecLogs(backTrackReg, new IteradorCadena(cad), matchsEsperadosRestantes, missMatchActual);
				} else {
					res = missMatchPrevio;
				}

				solucionesBackTrack.put(clave, res);
				System.out.println("SOL [" + backTrackRegRef.getPosActual() + ", " + (cad.getPosActual()) + "] = " + res);

				return res;
			}

			while (sec != null && quedaPorVerificar && (sec.cantidadMinima > 0 || sec.getTipoSecuencia() != 0)
					&& missMatchActual == false) {

				char actualCadena = cad.obtenerActual();

				System.out.println("\n----- COMPARACIÓN -----");
				System.out.println("Cadena actual      : " + actualCadena);
				System.out.println("Patrón esperado    : " + sec.getCaracter());
				System.out.println("Cantidad mínima    : " + sec.getCantidadMinima());
				System.out.println("Tipo secuencia     : " + sec.getTipoSecuencia());

				if (actualCadena != sec.getCaracter() && sec.getCaracter() != '.') {

					System.out.println("❌ MISMATCH");
					System.out.println("Esperaba [" + sec.getCaracter() + "] pero encontró [" + actualCadena + "]");

					missMatchActual = true;

				} else {

					System.out.println("✅ MATCH");

					if (sec.getCantidadMinima() > 0) {
						sec.decrementarCantidadMinima();
					}

					if (matchsEsperadosRestantes > 0) {
						matchsEsperadosRestantes--;
					}

					System.out.println("Cantidad mínima luego de decrementar: " + sec.getCantidadMinima());
				}

				if (cad.tieneSiguiente() && missMatchActual == false) {

					System.out.println("Avanzando cadena de posición " + cad.getPosActual());

					cad.incrementarPosActual();

					System.out.println("Nueva posición cadena " + cad.getPosActual());

				} else {

					System.out.println("Fin de match en secuencia paralela");

					quedaPorVerificar = false;
				}
			}

			System.out.println("\nSALIÓ DEL WHILE INTERNO");
			System.out.println("missMatch         = " + missMatchActual);
			System.out.println("quedaPorVerificar = " + quedaPorVerificar);

			if (sec != null && sec.cantidadMinima == 0 && missMatchActual) {

				System.out.println("Mismatch ignorado porque la secuencia ya cumplió su mínimo");

				missMatchActual = false;
				if (matchsEsperadosRestantes > 0) {
					quedaPorVerificar = true;
				}
			}

			if (sec != null && matchsEsperadosRestantes == 0) {

				System.out.println("\nCadena terminada. Verificando secuencias restantes...");

				while (sec != null && !missMatchActual) {

					System.out.println("Secuencia restante:");
					System.out.println(sec);

					if (sec.getCantidadMinima() != 0) {

						System.out.println(
								"❌ Secuencia restante requiere " + sec.getCantidadMinima() + " ocurrencias mínimas");

						missMatchActual = true;
					}

					sec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(reg);
				}
			}

			IteradorCadena sigInstanciaCad = new IteradorCadena(cad);
			IteradorCadena sigInstanciaReg = new IteradorCadena(reg);

			System.out.println("=== RECURSIÓN ===");
			System.out.println("reg.pos = " + reg.getPosActual());
			System.out.println("cad.pos = " + cad.getPosActual());
			System.out.println("restantes = " + matchsEsperadosRestantes);
			System.out.println("missMatch = " + missMatchActual);

			return generarRegex2RecLogs(sigInstanciaReg, sigInstanciaCad, matchsEsperadosRestantes, missMatchActual);
		}

		System.out.println("\n=================================");
		System.out.println("ESTADO FINAL");
		System.out.println("sec                      = " + sec); // (si quedó algo de la regex pendiente a procesar es
																	// != null)
		System.out.println("último valor missMatch   = " + missMatchPrevio);
		System.out.println("matchsEsperadosRestantes = " + matchsEsperadosRestantes);
		System.out.println("=================================");

		if (sec != null || missMatchPrevio || matchsEsperadosRestantes > 0) {

			System.out.println("RETURN FALSE");

			return false;
		}

		System.out.println("RETURN TRUE");

		return true;
	}

	private static class IteradorCadena {
		private String cadena;
		private int posActual;

		private IteradorCadena(String cad) {
			cadena = cad;
			posActual = 0;
		}

		private IteradorCadena(IteradorCadena cad) {
			cadena = cad.cadena;
			posActual = cad.posActual;
		}

		public void incrementarPosActual() {
			posActual++;
		}

		public boolean tieneSiguiente() {
			return posActual + 1 < cadena.length();
		}

		public char obtenerActual() {
			if (posActual >= 0 && posActual < cadena.length()) {
				return cadena.charAt(posActual);
			}

			return ' ';
		}

		public char verSiguiente() {
			if (posActual < 0 || posActual >= cadena.length() - 1) {
				return ' ';
			}

			return cadena.charAt(posActual + 1);
		}

		public int getPosActual() {
			return posActual;
		}

		public void setPosActual(int pos) {
			if (pos >= 0 && pos <= cadena.length()) {
				posActual = pos;
			}
		}

		public String getCadena() {
			return cadena;
		}

		public boolean finDeCadena() {
			return posActual >= cadena.length();
		}

		public void resetearPosActual() {
			posActual = 0;
		}

		public int obtenerTam() {
			return cadena.length();
		}

		public char obtenerPorPosicion(int pos) {
			if (pos < 0 || pos >= cadena.length()) {
				return ' ';
			}
			return cadena.charAt(pos);
		}

		public void establecerPosActual(int pos) {
			if (pos >= 0 && pos <= cadena.length()) {
				return;
			}
		}
	}

	private static class Secuencia {
		private char caracter;
		private int tipoSecuencia; // 0:simple; 1:claúsula kleene 2:clásusula positiva 3:cláusula minima positiva
		private int cantidadMinima; //

		private Secuencia(char car, int tipo) {
			caracter = car;
			tipoSecuencia = tipo;
			cantidadMinima = 0;
		}

		private Secuencia() {
			cantidadMinima = 0;
		}

		public char getCaracter() {
			return caracter;
		}

		public void setCaracter(char caracter) {
			this.caracter = caracter;
		}

		public int getTipoSecuencia() {
			return tipoSecuencia;
		}

		public void setTipoSecuencia(int tipoSecuencia) {
			this.tipoSecuencia = tipoSecuencia;
		}

		public int getCantidadMinima() {
			return cantidadMinima;
		}

		public void setCantidadMinima(int cantidad) {
			this.cantidadMinima = cantidad;
		}

		public void incrementarCantidadMinima() {
			cantidadMinima++;
		}

		public void decrementarCantidadMinima() {
			cantidadMinima--;
		}

		private void simplificarParDeSecuencias(Secuencia otra) {
			String resultante = "" + tipoSecuencia + otra.tipoSecuencia;

			// asignación de tipos resultantes

			if (resultante.equals("00")) {
				tipoSecuencia = 0;
			} else if (resultante.equals("11")) {
				tipoSecuencia = 1;
			} else if (resultante.equals("01") || resultante.equals("10") || resultante.equals("12")
					|| resultante.equals("21")) {
				tipoSecuencia = 2;
			} else if (resultante.equals("02") || resultante.equals("20") || resultante.equals("33")
					|| resultante.equals("13") || resultante.equals("31") || resultante.equals("22")
					|| resultante.equals("23") || resultante.equals("32") || resultante.equals("03")
					|| resultante.equals("30")) {
				tipoSecuencia = 3;
			}

			// asignación cantidades mínimas resultantes

			if (resultante.equals("00") || resultante.equals("02") || resultante.equals("20") || resultante.equals("03")
					|| resultante.equals("30") || resultante.equals("22") || resultante.equals("23")
					|| resultante.equals("32") || resultante.equals("33") || resultante.equals("11")
					|| resultante.equals("13") || resultante.equals("31") || resultante.equals("01")
					|| resultante.equals("10")) {
				cantidadMinima = cantidadMinima + otra.cantidadMinima;
			} else if (resultante.equals("12") || resultante.equals("21")) {
				cantidadMinima = Math.max(cantidadMinima, otra.cantidadMinima);
			}
		}

		public static Secuencia obtenerSiguienteSecuenciaLookAheadLogs(IteradorCadena cad) {
			Secuencia secActual = new Secuencia(), secNueva = new Secuencia();

			int estadoSecuencia = 0; // 0:INIT 1:SECUENCIA_ACTIVA 2:CAMBIO_SECUENCIA

			System.out.println("\n=== obtenerSiguienteSecuenciaLookAhead ===");

			if (cad.posActual < 0 || cad.posActual >= cad.obtenerTam()) {
				System.out.println("[EXIT] Posición fuera de rango");
				return null;
			}

			while (cad.posActual < cad.obtenerTam() && estadoSecuencia != 2) {

				System.out.printf("%n[LOOP] pos=%d estado=%d charActual='%c'%n", cad.posActual, estadoSecuencia,
						cad.obtenerActual());

				secNueva = Secuencia.reducirSiguienteParDeCaracteresLogs(cad);

				System.out.printf("[SEC_NUEVA] caracter=%c tipo=%d min=%d%n",
						secNueva != null ? secNueva.getCaracter() : '?',
						secNueva != null ? secNueva.getTipoSecuencia() : -1,
						secNueva != null ? secNueva.getCantidadMinima() : -1);

				if (estadoSecuencia == 0) {

					System.out.println("[RAMA A] Inicializando secActual");

					secActual.setCaracter(secNueva.getCaracter());
					secActual.setTipoSecuencia(secNueva.getTipoSecuencia());
					secActual.setCantidadMinima(secNueva.getCantidadMinima());

					estadoSecuencia = 1;

					System.out.printf("[SEC_ACTUAL] caracter=%c tipo=%d min=%d%n", secActual.getCaracter(),
							secActual.getTipoSecuencia(), secActual.getCantidadMinima());
				} else if (secNueva.getCaracter() == secActual.getCaracter()) {

					System.out.println("[RAMA B] Mismo caracter -> simplificarParDeSecuencias");

					secActual.simplificarParDeSecuencias(secNueva);

					System.out.printf("[SEC_ACTUAL DESPUÉS] caracter=%c tipo=%d min=%d%n", secActual.getCaracter(),
							secActual.getTipoSecuencia(), secActual.getCantidadMinima());
				} else {

					System.out.printf("[RAMA C] Cambio de secuencia (%c -> %c)%n", secActual.getCaracter(),
							secNueva.getCaracter());

					estadoSecuencia = 2;
				}

				if (estadoSecuencia != 2) {

					System.out.println("[AVANCE] incrementarPosActual()");
					cad.incrementarPosActual();

					if (secNueva.getTipoSecuencia() == 1) {

						System.out.println("[AVANCE EXTRA] tipo=1 -> salto del '*' asociado");

						cad.incrementarPosActual();
					}
				}
			}

			System.out.printf("%n[FIN] caracter=%c tipo=%d min=%d estado=%d%n", secActual.getCaracter(),
					secActual.getTipoSecuencia(), secActual.getCantidadMinima(), estadoSecuencia);

			return secActual;
		}

		private static Secuencia reducirSiguienteParDeCaracteresLogs(IteradorCadena cad) {

			System.out.println("\n--- reducirSiguienteParDeCaracteres ---");

			if (cad.posActual < 0 || cad.posActual >= cad.obtenerTam()) {
				System.out.println("[EXIT] Posición fuera de rango");
				return null;
			}

			System.out.printf("[ENTRADA] pos=%d actual='%c'%n", cad.posActual, cad.obtenerActual());

			Secuencia sec = new Secuencia();
			int tipo;

			if (cad.obtenerActual() == '*') {
				System.out.println("[ERROR] Encontrado '*' como caracter inicial");
				sec.setCaracter(' ');
				return sec;
			}

			sec.setCaracter(cad.obtenerActual());

			if (cad.tieneSiguiente()) {

				System.out.printf("[LOOKAHEAD] siguiente='%c'%n", cad.verSiguiente());

				if (cad.verSiguiente() != '*') {

					System.out.println("[RAMA A] Caracter normal");

					tipo = 0;
				} else {

					System.out.println("[RAMA B] Caracter seguido de '*'");

					tipo = 1;
				}
			} else {
				System.out.println("[RAMA C] No hay siguiente caracter");
				tipo = 0;
			}
			sec.setTipoSecuencia(tipo);

			if (tipo == 0) {
				sec.incrementarCantidadMinima();
			}

			System.out.printf("[RESULTADO] caracter=%c tipo=%d min=%d%n", sec.getCaracter(), sec.getTipoSecuencia(),
					sec.getCantidadMinima());

			return sec;
		}
		
		public static int minimaRegexRequerida(IteradorCadena cad) {
			Secuencia proxSec = new Secuencia();
			int contador = 0;
			proxSec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(cad);
			
			while(proxSec != null && proxSec.cantidadMinima > 0) {
				contador++;
			}
			
			return contador;
		}

		@Override
		public String toString() {
			return "caracter: " + caracter + ", tipo secuencia: " + tipoSecuencia + ", cant. min: " + cantidadMinima;
		}
	}
	
	private static class Tupla {
		private int first;
		private int second;
		
		public Tupla(int f, int s) {
			first = f;
			second = s;
		}
		
		public int getFirst() {
			return first;
		}
		
		public void setFirst(int first) {
			this.first = first;
		}
		
		public int getSecond() {
			return second;
		}
		
		public void setSecond(int second) {
			this.second = second;
		}
		
		@Override
	    public boolean equals(Object obj) {
	        // 1. Comprobar si es el mismo objeto
	        if (this == obj) return true;

	        // 2. Comprobar si el objeto es nulo o de otra clase
	        if (obj == null || getClass() != obj.getClass()) return false;

	        // 3. Convertir y comparar atributos
	        Tupla other = (Tupla) obj;
	        return first == other.first &&
	               second == other.second;
	    }

	    @Override
	    public int hashCode() {
	        // Siempre que sobrescribas equals, sobrescribe hashCode
	        return Objects.hash(first, second);
	    }
	}
}
