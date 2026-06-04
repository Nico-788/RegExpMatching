package regexp;

public class MatcherRegex {
    private static final int MIN_LENGTH_PATRON = 1;
    private static final int MIN_LENGTH_STRING = 1;
    private static final int MAX_LENGTH_PATRON = 20;
    private static final int MAX_LENGTH_STRING = 20;

    /*
    // Del primer intento
    private boolean isAnyLetter = false;
    private boolean isZeroOrMore = false; 
    private char zeroOrMore;
    */


    private boolean isMatchHelper(String s, String p, int indexS, int indexP) {
        if (indexP == p.length()) {         //Se acabó el patrón
            return indexS == s.length();    //Es para corroborar si consumí la cadena completa o me faltó
        }

        // Primero, corroboro que esté en el rango del tamaño de la cadena porque puedo terminar antes la cadena que el patrón.
        // Luego, ¿estamos parado en un . o el carácter actual del string coincide con el patrón?
        boolean firstMatch = indexS < s.length() && 
                            (p.charAt(indexP) == '.' || p.charAt(indexP) == s.charAt(indexS));

        // Necesito mirar el siguiente.
        // Implica, primero, ver si doy un paso adelante no me caigo del array.
        // Luego, pregunto si el siguiente es un *
        if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
            return isMatchHelper(s, p, indexS, indexP + 2)                  // vamos a corroborar si el patrón se consume cero veces. Caso p: ab*c / s: ac
                || (firstMatch && isMatchHelper(s, p, indexS + 1, indexP)); // cuando la cadena tiene una o más para consumir
        }

        return firstMatch && isMatchHelper(s, p, indexS + 1, indexP + 1);   // en el caso que no tenga * para consumir

        /*
        // Este caso fue el primer intento sin backtracking
        if(p.length() == indexP && isZeroOrMore || p.length() == indexP && s.length() == indexS) {
            return true;
        }
        if(s.length() == indexS || p.length() == indexP) {
            return false;
        }

        if(p.charAt(indexP) == '.') {
            this.isAnyLetter = true;
            return isMatchHelpper(s, p, indexS, indexP+1);
        }
        if(p.charAt(indexP) == '*') {
            this.isZeroOrMore = true;
            this.zeroOrMore = p.charAt(indexP-1);
            return isMatchHelpper(s, p, indexS, indexP+1);
        }

        if(isZeroOrMore) {
            if(isAnyLetter && s.charAt(indexS) != p.charAt(indexP) || s.charAt(indexS) == this.zeroOrMore) {
                return isMatchHelpper(s, p, indexS+1, indexP);
            } else if(s.charAt(indexS) == p.charAt(indexP)) {
                this.isAnyLetter = false;
                this.isZeroOrMore = false;
                return isMatchHelpper(s, p, indexS+1, indexP+1);
            }
            this.isZeroOrMore = false;
            this.zeroOrMore = '\0';
            return isMatchHelpper(s, p, indexS, indexP+1);

        } else if(isAnyLetter || s.charAt(indexS) == p.charAt(indexP)) {
            return isMatchHelpper(s, p, indexS+1, indexP+1);
        }

        return false;
        
        */
    }

    public boolean isMatch(String s, String p) throws IllegalArgumentException {
        if(s.length() < MIN_LENGTH_STRING || s.length() > MAX_LENGTH_STRING 
            || p.length() < MIN_LENGTH_PATRON || p.length() > MAX_LENGTH_PATRON) {
            
            throw new IllegalArgumentException("Los parametros están fuera de rango");
        }

        return isMatchHelper(s, p, 0, 0);
    }
}
