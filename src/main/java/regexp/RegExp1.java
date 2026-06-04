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

		llamadas = 0;
		solucionesBackTrack = new HashMap<Tupla, Boolean>();

		return generarRegex(0, 0);
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

	public boolean generarRegex(int i, int j) {

		llamadas++;

		Secuencia sec = new Secuencia();
		boolean quedaPorVerificar = cadena.length() - j > 0; // relativo a la secuencia paralela actual (sea regex: a*bc
																// y cadena: aaabc -> cuando llega b =>
																// quedaPorVerificar = false)
		boolean matchActual = false;

		sec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(regex, i);
		if (sec != null) {
			i = i + sec.getCaracteresConsumidos();
		}

		if (sec != null) {
			if (sec.getCaracter() == '.' && sec.getTipoSecuencia() >= 1 && (i < regex.length())) {

				Tupla clave = new Tupla(i, j);

				if (solucionesBackTrack.containsKey(clave)) {
					return solucionesBackTrack.get(clave);
				}

				// sec '.*' expandiendo desde una pos más de cadena
				// sigSec evaluando desde pos de cadena actual

				if ((cadena.length() - j) >= 0) {
					matchActual = generarRegex(i - sec.getCaracteresConsumidos(), j + 1) || generarRegex(i, j);
				}

				solucionesBackTrack.put(clave, matchActual);

				return matchActual;
			}

			while (quedaPorVerificar && (sec.cantidadMinima > 0 || sec.getTipoSecuencia() != 0)) {

				char actualCadena = cadena.charAt(j);

				if (actualCadena != sec.getCaracter() && sec.getCaracter() != '.') {

					matchActual = false;

				} else {

					if (sec.getCantidadMinima() > 0) {
						sec.decrementarCantidadMinima();
					}

					matchActual = true;
					j++;
				}

				if (j >= cadena.length() || matchActual == false) {

					quedaPorVerificar = false;
				}
			}

			if (sec.getCantidadMinima() == 0 && matchActual == false) {

				matchActual = true;
				if (j < cadena.length()) {
					quedaPorVerificar = true;
				}
			}

			if (j >= cadena.length()) {

				while (sec != null && matchActual) {

					if (sec.getCantidadMinima() != 0) {

						matchActual = false;
					}

					sec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(regex, i);
					if (sec != null) {
						i = i + sec.getCaracteresConsumidos();
					}
				}
			}

			return (matchActual == true) ? generarRegex(i, j) : false;
		} else {
			matchActual = false;
		}

		if (i >= regex.length()) {
			matchActual = (j == cadena.length());
		} else {
			matchActual = true;
		}

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
			
			if (i < 0 || i >= cad.length()) {
				return null;
			}
			while (i < cad.length() && estadoSecuencia != 2) {
				secNueva = reducirSiguienteParDeCaracteresLogs(cad, i);
				if (estadoSecuencia == 0) {
					secActual.setCaracter(secNueva.getCaracter());
					secActual.setTipoSecuencia(secNueva.getTipoSecuencia());
					secActual.setCantidadMinima(secNueva.getCantidadMinima());
					estadoSecuencia = 1;
				} else if (secNueva.getCaracter() == secActual.getCaracter()) {
					secActual.simplificarParDeSecuencias(secNueva);
				} else {
					estadoSecuencia = 2;
				}
				
				if (estadoSecuencia != 2) {
					secActual.incrementarCaracteresConsumidos();
					i++;
					if (secNueva.getTipoSecuencia() == 1) {
						secActual.incrementarCaracteresConsumidos();
						i++;
					}
				}
			}

			return secActual;
		}

		private static Secuencia reducirSiguienteParDeCaracteresLogs(String cad, int i) {
			if (i < 0 || i >= cad.length()) {
				return null;
			}

			Secuencia sec = new Secuencia();
			int tipo;

			if (cad.charAt(i) == '*') {
				sec.setCaracter(' ');
				return sec;
			}

			sec.setCaracter(cad.charAt(i));

			if (i + 1 < cad.length()) {
				if (cad.charAt(i + 1) != '*') {
					tipo = 0;
				} else {
					tipo = 1;
				}
			} else {
				tipo = 0;
			}
			sec.setTipoSecuencia(tipo);
			if (tipo == 0) {
				sec.incrementarCantidadMinima();
			}

			return sec;
		}

		public static int minimaRegexRequerida(String cad, int i) {
			Secuencia proxSec = new Secuencia();
			int contador = 0;
			proxSec = Secuencia.obtenerSiguienteSecuenciaLookAheadLogs(cad, i);

			while (proxSec != null && proxSec.cantidadMinima > 0) {
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
			if (this == obj)
				return true;

			// 2. Comprobar si el objeto es nulo o de otra clase
			if (obj == null || getClass() != obj.getClass())
				return false;

			// 3. Convertir y comparar atributos
			Tupla other = (Tupla) obj;
			return first == other.first && second == other.second;
		}

		@Override
		public int hashCode() {
			// Siempre que sobrescribas equals, sobrescribe hashCode
			return Objects.hash(first, second);
		}
	}
}