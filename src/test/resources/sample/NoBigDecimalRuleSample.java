import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aki.sus.Entity;

public class NoBigDecimalRuleSample {
    
    List<Entity> entities = new ArrayList<>();

    public void analysisError() {
        entities.stream().map(Entity::someStringStuff).collect(Collectors.toList());
    }
    
    public void ruleOk() {
        "".length(); // Compliant
    }
    
    public void ruleKo() {
        BigDecimal.ZERO.compareTo(BigDecimal.ONE); // Noncompliant
    }
}
