package esprima4java.ast.deserialize;

import com.google.gson.JsonObject;

import esprima4java.Esprima2Java;
import esprima4java.ast.IfStatement;
import esprima4java.ast.Node;
import esprima4java.ast.NodeType;

public class IfStatementDeserializer implements NodeDeserializer {

    @Override
    public NodeType getSupportedType() {
	return NodeType.IF_STATEMENT;
    }

    @Override
    public Node deserialize(JsonObject json) throws DeserializationException {
	Node test = Esprima2Java.deserialize(json.get("test"));
	Node consequent = Esprima2Java.deserialize(json.get("consequent"));
	if (json.has("alternate")) {
	    Node alternate = Esprima2Java.deserialize(json.get("alternate"));
	    return IfStatement.create(test, consequent, alternate);
	} else {
	    return IfStatement.create(test, consequent);
	}
    }

}
