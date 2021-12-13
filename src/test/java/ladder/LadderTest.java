package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("")
    void create() {
        assertThat(new Ladder(3, 5)).isEqualTo(new Ladder(3, 5));
    }

    @ParameterizedTest
    @MethodSource("singleResultSource")
    @DisplayName("")
    void singleResult(BooleanSupplier createFactor, int currIndex, int result) {
        // given
        Ladder ladder = new Ladder(4, 4, createFactor);

        // when
        int singleResult = ladder.singleResult(currIndex);

        // then
        assertThat(singleResult).isSameAs(result);
    }

    static Stream<Arguments> singleResultSource() {
        return Stream.of(
                Arguments.of((BooleanSupplier) () -> false, 0, 0),
                Arguments.of((BooleanSupplier) () -> false, 1, 1),
                Arguments.of((BooleanSupplier) () -> false, 2, 2),
                Arguments.of((BooleanSupplier) () -> false, 3, 3),
                Arguments.of((BooleanSupplier) () -> true, 0, 1),
                Arguments.of((BooleanSupplier) () -> true, 1, 0),
                Arguments.of((BooleanSupplier) () -> true, 2, 3),
                Arguments.of((BooleanSupplier) () -> true, 3, 2)
        );
    }
}
