package org.aki.sus;

import org.aki.sus.NoBigDecimalRule;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class NoBigDecimalRuleTest {

    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/resources/sample/NoBigDecimalRuleSample.java",
                new NoBigDecimalRule());
    }
}
