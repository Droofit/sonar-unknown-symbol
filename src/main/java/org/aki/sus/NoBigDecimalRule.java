package org.aki.sus;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;

@Rule(key="NoBigDecimal")
public class NoBigDecimalRule extends BaseTreeVisitor implements JavaFileScanner {

    private JavaFileScannerContext context;

    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }
    
    @Override
    public void visitMethodInvocation(MethodInvocationTree tree) {
        Symbol symbol = tree.symbol();
        Symbol owner = symbol.owner();
        Type type = owner.type();
        if(type == null) {
            throw new IllegalStateException("Type should not be null !");
        } else if(type.isSubtypeOf("java.math.BigDecimal")) {
            context.reportIssue(this, tree, "You used a BigDecimal, naughty coder !");
        }
        super.visitMethodInvocation(tree);
    }
}
