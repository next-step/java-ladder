package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("")
    void create() {
        assertThat(new Line(5)).isEqualTo(new Line(5));
    }

    @ParameterizedTest
    @MethodSource("moveSource")
    @DisplayName("")
    void move(BooleanSupplier createFactor, int currIndex, int result) {
        // given
        Line line = new Line(5, createFactor);

        // when
        int nextIndex = line.move(currIndex);

        // then
        assertThat(nextIndex).isSameAs(result);
    }

    static Stream<Arguments> moveSource() {
        return Stream.of(
                Arguments.of((BooleanSupplier) () -> false, 0, 0),
                Arguments.of((BooleanSupplier) () -> false, 1, 1),
                Arguments.of((BooleanSupplier) () -> false, 2, 2),
                Arguments.of((BooleanSupplier) () -> false, 3, 3),
                Arguments.of((BooleanSupplier) () -> false, 4, 4),
                Arguments.of((BooleanSupplier) () -> true, 0, 1),
                Arguments.of((BooleanSupplier) () -> true, 1, 0),
                Arguments.of((BooleanSupplier) () -> true, 2, 3),
                Arguments.of((BooleanSupplier) () -> true, 3, 2),
                Arguments.of((BooleanSupplier) () -> true, 4, 4)
        );
    }
}
