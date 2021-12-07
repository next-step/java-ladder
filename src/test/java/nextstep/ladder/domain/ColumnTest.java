package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ColumnTest {

    @ParameterizedTest
    @DisplayName("Column head create test")
    @ValueSource(booleans = {true, false})
    void createHead(boolean right) {
        Column column = Column.head(right);

        assertThat(column).isInstanceOf(Column.class);
    }

    @ParameterizedTest
    @DisplayName("Column body create test")
    @MethodSource
    void createBody(boolean left, boolean right) {
        Column column = Column.body(left, right);

        assertThat(column).isInstanceOf(Column.class);
    }

    static Stream<Arguments> createBody() {
        return Stream.of(
                Arguments.of(
                    Boolean.TRUE, Boolean.FALSE
                ),
                Arguments.of(
                    Boolean.FALSE, Boolean.TRUE
                )
        );
    }

    @ParameterizedTest
    @DisplayName("Column tail create test")
    @ValueSource(booleans = {true, false})
    void createTail(boolean left) {
        Column column = Column.tail(left);

        assertThat(column).isInstanceOf(Column.class);
    }

    @ParameterizedTest
    @DisplayName("Column move test")
    @MethodSource
    void move(Column column, int before, int expected) {
        assertThat(column.move(before)).isEqualTo(expected);
    }

    static Stream<Arguments> move() {
        return Stream.of(
                Arguments.of(
                    Column.head(Boolean.TRUE), 0, 1
                ),
                Arguments.of(
                    Column.body(Boolean.FALSE, Boolean.TRUE), 2, 3
                ),
                Arguments.of(
                    Column.body(Boolean.TRUE, Boolean.FALSE), 2, 1
                ),
                Arguments.of(
                    Column.body(Boolean.FALSE, Boolean.FALSE), 2, 2
                ),
                Arguments.of(
                    Column.tail(Boolean.TRUE), 5, 4
                )
        );
    }
}