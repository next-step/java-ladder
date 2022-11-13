package laddergame.domain;

import laddergame.Generator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class PointTest {
    public static Stream<Arguments> providedStates() {
        return Stream.of(
                Arguments.of(Point.valueOf(true), (Generator) () -> true, Point.valueOf(false)),
                Arguments.of(Point.valueOf(true), (Generator) () -> false, Point.valueOf(false)),
                Arguments.of(Point.valueOf(false), (Generator) () -> true, Point.valueOf(true)),
                Arguments.of(Point.valueOf(false), (Generator) () -> false, Point.valueOf(false))
        );
    }

    @ParameterizedTest
    @MethodSource("providedStates")
    void 이전_상태가_True_이면_항상_false_그외_입력값_그대로(Point previous, Generator generator, Point expected) {
        assertThat(previous.next(generator)).isEqualTo(expected);
    }

    @Test
    void 캐시() {
        assertThatNoException().isThrownBy(() -> Point.valueOf(true));
    }
}
