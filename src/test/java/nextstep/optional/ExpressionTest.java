package nextstep.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ExpressionTest {
//    @Test
//    public void of() {
//        assertThat(Expression.PLUS == Expression.of("+")).isTrue();
//    }
//
//    @Test
//    public void notValidExpression() {
//        assertThatIllegalArgumentException()
//                .isThrownBy(() -> {
//                    Expression.of("&");
//                });
//    }

    @Test
    void of() {
        assertEquals(Expression.PLUS, Expression.of("+"));
        assertEquals(Expression.MINUS, Expression.of("-"));
        assertEquals(Expression.TIMES, Expression.of("*"));
        assertEquals(Expression.DIVIDE, Expression.of("/"));
    }

    @Test
    void notValidExpression() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Expression.of("%");
        });
        assertEquals("Invalid expression symbol: %", exception.getMessage());
    }
}
