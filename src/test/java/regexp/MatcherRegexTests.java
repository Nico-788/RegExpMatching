package regexp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatcherRegexTests {
    MatcherRegex mr = new MatcherRegex();

    @Test
    public void patronMasCortoQueString() {
        Assertions.assertFalse(mr.isMatch("aa", "a"));
    }

    @Test
    public void matchVerdadero() {
        Assertions.assertTrue(mr.isMatch("aa", "aa"));
    }
}
