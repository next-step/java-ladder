package nextstep.optional;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

enum Expression {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/");

    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    private static final Map<String, Expression> valuesMap = Arrays.stream(Expression.values())
            .collect(Collectors.toMap(value -> value.expression, Function.identity()));

    static Expression of(String expression) {
        return Optional.ofNullable(valuesMap.get(expression))
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않습니다.", expression)));
    }
}
