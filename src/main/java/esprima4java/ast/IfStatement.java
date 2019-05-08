package esprima4java.ast;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class IfStatement extends Node {
    public static IfStatement create(Node test, Node consequent, Node alternate) {
	return new AutoValue_IfStatement(NodeType.IF_STATEMENT, test, consequent, alternate);
    }

    public abstract Node test();

    public abstract Node consequent();

    @Nullable
    public abstract Node alternate();

    @Override
    protected List<Node> getChildren() {
	List<Node> children = new ArrayList<>();
	children.add(test());
	children.add(consequent());
	if (alternate() != null)
	    children.add(alternate());
	return children;
    }

}
