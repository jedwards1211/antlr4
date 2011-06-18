package org.antlr.v4.codegen.model;

import org.antlr.v4.codegen.*;
import org.antlr.v4.codegen.model.actions.ActionChunk;
import org.antlr.v4.tool.*;

import java.util.List;

/** */
public class Action extends RuleElement {
	public List<ActionChunk> chunks;
	public Action(OutputModelFactory factory, GrammarAST ast) {
		super(factory,ast);
		RuleFunction rf = null;
		if ( factory.currentRule.size()>0 ) rf = factory.currentRule.peek();
		chunks = ActionTranslator.translateAction(factory, rf, ast.token, (ActionAST)ast);
		//System.out.println("actions="+chunks);
	}

//	@Override
//	public List<String> getChildren() {
//		final List<String> sup = super.getChildren();
//		return new ArrayList<String>() {{
//			if ( sup!=null ) addAll(sup);
//			add("chunks");
//		}};
//	}

}
