package regexp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class RegExp1 {
	private long llamadas = 0;
	private Map<Tupla, Boolean> solucionesBackTrack;
	private String regex;
	private String cadena;

	public RegExp1() {

	}

	public boolean isMatch(String p, String s) {

		regex = p;
		cadena = s;
		
		System.out.println("\n=================================");
		System.out.println("INICIO generarRegex1");
		System.out.println("regex  = [" + regex + "]");
		System.out.println("cadena = [" + cadena + "]");
		System.out.println("=================================\n");

		llamadas = 0;
		solucionesBackTrack = new HashMap<Tupla, Boolean>();

		return generarRegex2RecLogs(0, 0);
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
	
	

	public boolean generarRegex2RecLogs(int i, int j) {

		llamadas++;

		Secuencia sec = new Secuencia();
		boolean quedaPorVerificar = cadena.length() - j > 0; // relativo a la secuencia paralela actual (sea regex: a*bc y cadena: aaabc ->
											// cuando llega b => quedaPorVerificar = false)
		boolean matchActual = false;

		System.out.println("=== ENTRADA ===");
		System.out.println("reg.pos = " + i);
		System.out.println("cad.pos = " + j);
		System.out.println("restantes = " + (cadena.length() - j));

		System.out.println("\n=================================");
		System.out.println("BUSCANDO NUEVA SECUENCIA");
		System.out.println("Pos regex: " + i);
		System.out.println("=================================");

		sec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(regex, i);
		if(sec != null) {
			i = i + sec.getCaracteresConsumidos();			
		}

		System.out.println("Secuencia obtenida:");
		System.out.println(sec);

		if (sec != null) {
			if (sec.getCaracter() == '.' && sec.getTipoSecuencia() >= 1 && (i < regex.length())) {
				
				Tupla clave = new Tupla(i, j);

				if (solucionesBackTrack.containsKey(clave)) {
					System.out.println("MEMO -> [" + i + ", " + j + "]");
					return solucionesBackTrack.get(clave);
				}

				System.out.println("=== RECURSIÓN BACKTRACKING ===");
				System.out.println("restantes = " + (cadena.length() - j));
				System.out.println("matchActual = " + matchActual);

				System.out.println("RAMA 1");
				System.out.println("reg=" + (i - sec.getCaracteresConsumidos()) + " cad=" + (j + 1));

				System.out.println("RAMA 2");
				System.out.println("reg=" + i + " cad=" + j);

				// sec '.*' expandiendo desde una pos más de cadena
				// sigSec evaluando desde pos de cadena actual

				if ((cadena.length() - j) >= 0) {
					matchActual = generarRegex2RecLogs(i - sec.getCaracteresConsumidos(), j + 1)
							|| generarRegex2RecLogs(i, j);
				}

				solucionesBackTrack.put(clave, matchActual);
				System.out.println("SOL [" + i + ", " + j + "] = " + matchActual);

				return matchActual;
			}

			while (quedaPorVerificar && (sec.cantidadMinima > 0 || sec.getTipoSecuencia() != 0)) {

				char actualCadena = cadena.charAt(j);

				System.out.println("\n----- COMPARACIÓN -----");
				System.out.println("Cadena actual      : " + actualCadena);
				System.out.println("Patrón esperado    : " + sec.getCaracter());
				System.out.println("Cantidad mínima    : " + sec.getCantidadMinima());
				System.out.println("Tipo secuencia     : " + sec.getTipoSecuencia());

				if (actualCadena != sec.getCaracter() && sec.getCaracter() != '.') {

					System.out.println("❌ MISMATCH");
					System.out.println("Esperaba [" + sec.getCaracter() + "] pero encontró [" + actualCadena + "]");

					matchActual = false;

				} else {

					System.out.println("✅ MATCH");

					if (sec.getCantidadMinima() > 0) {
						sec.decrementarCantidadMinima();
					}
					
					matchActual = true;
					System.out.println("Avanzando cadena de posición: " + j);
					j++;
					System.out.println("A nueva posición: " + j);

					System.out.println("Cantidad mínima luego de decrementar: " + sec.getCantidadMinima());
				}

				if (j >= cadena.length() || matchActual == false) {
					System.out.println("Fin de match en secuencia paralela");
					
					quedaPorVerificar = false;
				}
			}

			System.out.println("\nSALIÓ DEL WHILE INTERNO");
			System.out.println("matchActual         = " + matchActual);
			System.out.println("quedaPorVerificar = " + quedaPorVerificar);

			if (sec.getCantidadMinima() == 0 && matchActual == false) {

				System.out.println("Mismatch ignorado porque la secuencia ya cumplió su mínimo");

				matchActual = true;
				if (j < cadena.length()) {
					quedaPorVerificar = true;
				}
			}

			if (j >= cadena.length()) {

				System.out.println("\nCadena terminada. Verificando secuencias restantes...");

				while (sec != null && matchActual) {

					System.out.println("Secuencia restante:");
					System.out.println(sec);

					if (sec.getCantidadMinima() != 0) {

						System.out.println(
								"❌ Secuencia restante requiere " + sec.getCantidadMinima() + " ocurrencias mínimas");

						matchActual = false;
					}

					sec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(regex, i);
					if(sec != null) {
						i = i + sec.getCaracteresConsumidos();						
					}
				}
			}

			System.out.println("=== RECURSIÓN ===");
			System.out.println("reg.pos = " + i);
			System.out.println("cad.pos = " + j);
			System.out.println("restantes = " + (cadena.length() - j));
			System.out.println("matchActual = " + matchActual);

			return (matchActual == true) ? generarRegex2RecLogs(i, j) : false;
		}
		else {
			System.out.println("RETURN FALSE");
			matchActual = false;
		}

		if(i >= regex.length()) {
			matchActual = (j == cadena.length()); 
		}
		else {
			System.out.println("RETURN TRUE");
			matchActual = true;
		}
		
		System.out.println("\n=================================");
		System.out.println("ESTADO FINAL");
		System.out.println("sec                      = " + sec); // (si quedó algo de la regex pendiente a procesar es
																	// != null)
		System.out.println("matchActual   = " + matchActual);
		System.out.println("matchsEsperadosRestantes = " + (cadena.length() - j));
		System.out.println("=================================");

		return matchActual;
	}

	private static class Secuencia {
		private char caracter;
		private int tipoSecuencia; // 0:simple; 1:claúsula kleene 2:clásusula positiva 3:cláusula minima positiva
		private int cantidadMinima; //
		private int caracteresConsumidos;

		private Secuencia(char car, int tipo) {
			caracter = car;
			tipoSecuencia = tipo;
			cantidadMinima = 0;
			caracteresConsumidos = 1;
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
		
		public int getCaracteresConsumidos() {
			return caracteresConsumidos;
		}

		public void setCaracteresConsumidos(int caracteresConsumidos) {
			this.caracteresConsumidos = caracteresConsumidos;
		}
		
		public void incrementarCaracteresConsumidos() {
			caracteresConsumidos++;
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

		public static Secuencia obtenerSiguienteSecuenciaLookAheadLogs(String cad, int i) {
			Secuencia secActual = new Secuencia(), secNueva = new Secuencia();

			int estadoSecuencia = 0; // 0:INIT 1:SECUENCIA_ACTIVA 2:CAMBIO_SECUENCIA

			System.out.println("\n=== obtenerSiguienteSecuenciaLookAhead ===");

			if (i < 0 || i >= cad.length()) {
				System.out.println("[EXIT] Posición fuera de rango");
				return null;
			}

			while (i < cad.length() && estadoSecuencia != 2) {

				System.out.printf("%n[LOOP] pos=%d estado=%d charActual='%c'%n", i, estadoSecuencia,
						cad.charAt(i));

				secNueva = reducirSiguienteParDeCaracteresLogs(cad, i);

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
					secActual.incrementarCaracteresConsumidos();
					i++;

					if (secNueva.getTipoSecuencia() == 1) {

						System.out.println("[AVANCE EXTRA] tipo=1 -> salto del '*' asociado");

						secActual.incrementarCaracteresConsumidos();
						i++;
					}
				}
			}

			System.out.printf("%n[FIN] caracter=%c tipo=%d min=%d consumidos=%d estado=%d%n", secActual.getCaracter(),
					secActual.getTipoSecuencia(), secActual.getCantidadMinima(), secActual.getCaracteresConsumidos(), estadoSecuencia);

			return secActual;
		}

		private static Secuencia reducirSiguienteParDeCaracteresLogs(String cad, int i) {

			System.out.println("\n--- reducirSiguienteParDeCaracteres ---");

			if (i < 0 || i >= cad.length()) {
				System.out.println("[EXIT] Posición fuera de rango");
				return null;
			}

			System.out.printf("[ENTRADA] pos=%d actual='%c'%n", i, cad.charAt(i));

			Secuencia sec = new Secuencia();
			int tipo;

			if (cad.charAt(i) == '*') {
				System.out.println("[ERROR] Encontrado '*' como caracter inicial");
				sec.setCaracter(' ');
				return sec;
			}

			sec.setCaracter(cad.charAt(i));

			if (i + 1 < cad.length()) {

				System.out.printf("[LOOKAHEAD] siguiente='%c'%n", cad.charAt(i + 1));

				if (cad.charAt(i + 1) != '*') {

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
		
		public static int minimaRegexRequerida(String cad, int i) {
			Secuencia proxSec = new Secuencia();
			int contador = 0;
			proxSec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(cad, i);
			
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