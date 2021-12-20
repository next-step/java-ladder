package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static ladder.enums.LadderPart.RAIL;
import static ladder.enums.LadderPart.RUNG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @DisplayName("대상 이름의 결과를 찾기")
    @ParameterizedTest
    @MethodSource(value = "provideResults")
    void resultOf(Results results) {
        assertThat(results.resultOf("pobi")).isEqualTo(new Result("pobi", "a"));
    }

    @DisplayName("대상 이름의 결과를 못 찾으면 예외")
    @ParameterizedTest
    @MethodSource(value = "provideResults")
    void resultOf_fail(Results results) {
        assertThatThrownBy(() -> results.resultOf("pobib"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Results.NOT_FOUND_TARGET_MESSAGE);
    }

    private static Stream<Arguments> provideResults() {
        return Stream.of(
                Arguments.of(new Results(new Result("pobi", "a"), new Result("crong", "b")))
        );
    }

    @DisplayName("올바른 결과")
    @ParameterizedTest
    @MethodSource(value = "provideLadder")
    void makeResult(Ladder ladder) {
        Results results = new Results(new Names("pobi, crong"), ladder, new Rewards("a, b"));
        assertThat(results.resultOf("pobi")).isEqualTo(new Result("pobi", "b"));
        assertThat(results.resultOf("crong")).isEqualTo(new Result("crong", "a"));
    }

    @DisplayName("올바르지 않은 결과 - 길이가 다름")
    @ParameterizedTest
    @MethodSource(value = "provideLadder")
    void makeResult_fail(Ladder ladder) {
        assertThatThrownBy(() -> new Results(new Names("pobi, crong, honux"), ladder, new Rewards("a, b, c")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Results.INVALID_RESULT_LENGTH_MESSAGE);
    }

    private static Stream<Arguments> provideLadder() {
        Line line = new Line(Arrays.asList(RAIL, RUNG, RAIL));
        Ladder ladder = new Ladder(Arrays.asList(line));

        return Stream.of(
                Arguments.of(ladder)
        );
    }
}