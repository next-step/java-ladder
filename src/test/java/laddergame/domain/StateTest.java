package laddergame.domain;

import laddergame.Generator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StateTest {
    public static Stream<Arguments> providedStates() {
        return Stream.of(
                Arguments.of(new State(true), (Generator) () -> true, new State(false)),
                Arguments.of(new State(true), (Generator) () -> false, new State(false)),
                Arguments.of(new State(false), (Generator) () -> true, new State(true)),
                Arguments.of(new State(false), (Generator) () -> false, new State(false))
        );
    }

    @ParameterizedTest
    @MethodSource("providedStates")
    void 이전_상태가_True_이면_항상_false_그외_입력값_그대로(State previous, Generator generator, State expected) {
        assertThat(previous.next(generator)).isEqualTo(expected);
    }
}
