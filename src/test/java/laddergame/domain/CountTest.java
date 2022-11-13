package laddergame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTest {
    public static Stream<Arguments> provideCountAndCompare() {
        return Stream.of(
                Arguments.of(new Count(1), true),
                Arguments.of(new Count(2), false),
                Arguments.of(new Count(3), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCountAndCompare")
    void 크기_비교(Count count, boolean result) {
        assertThat(new Count(2).bigger(count)).isEqualTo(result);
    }
}
