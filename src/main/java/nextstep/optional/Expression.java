package nextstep.optional;

import java.util.Arrays;

enum Expression {
	PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

	private String expression;

	Expression(String expression) {
		this.expression = expression;
	}
	
	private static boolean matchExpression(Expression e, String expression) {
		return expression.equals(e.expression);
	}

	static Expression of(String expression) {
		return Arrays.stream(Expression.values()).filter(x -> matchExpression(x,expression)).findFirst().orElseThrow(IllegalArgumentException::new);
	}
}
