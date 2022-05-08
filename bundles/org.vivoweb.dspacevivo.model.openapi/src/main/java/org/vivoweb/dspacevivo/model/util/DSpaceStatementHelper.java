package org.vivoweb.dspacevivo.model.util;

import org.vivoweb.dspacevivo.model.Statement;
import org.vivoweb.dspacevivo.model.StatementLiteral;

public class DSpaceStatementHelper {

	public static StatementLiteral createStatementLiteral(String supject, String predicate, String literal,
			String literaltype) {
		StatementLiteral aStatement = new StatementLiteral();
		aStatement.setSubjectUri(supject);
		aStatement.setPredicateUri(predicate);
		aStatement.setObjectLiteral(literal);
		aStatement.setLiteralType(literaltype);
		return aStatement;
	}
	public static Statement createStatement(String supject, String predicate, String object) {
		Statement aStatement = new Statement();
		aStatement.setSubjectUri(supject);
		aStatement.setPredicateUri(predicate);
		aStatement.setObjectUri(object);
		return aStatement;
	}
}
