package laddergame.domain;

import laddergame.Generator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class StateTest {
    public static Stream<Arguments> providedStates() {
        return Stream.of(
                Arguments.of(State.valueOf(true), (Generator) () -> true, State.valueOf(false)),
                Arguments.of(State.valueOf(true), (Generator) () -> false, State.valueOf(false)),
                Arguments.of(State.valueOf(false), (Generator) () -> true, State.valueOf(true)),
                Arguments.of(State.valueOf(false), (Generator) () -> false, State.valueOf(false))
        );
    }

    @ParameterizedTest
    @MethodSource("providedStates")
    void 이전_상태가_True_이면_항상_false_그외_입력값_그대로(State previous, Generator generator, State expected) {
        assertThat(previous.next(generator)).isEqualTo(expected);
    }

    @Test
    void 캐시() {
        assertThatNoException().isThrownBy(() -> State.valueOf(true));
    }
}
