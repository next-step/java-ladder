package nextstep.ladder.domain;

import nextstep.ladder.exception.LineDuplicateException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LineTest {

    @ParameterizedTest
    @MethodSource("providePoints")
    @DisplayName("실패 - 가로 라인이 겹치는 경우 예외가 발생한다.")
    void fail_line_duplicate(List<Boolean> points) {
        Assertions.assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(LineDuplicateException.class)
                .hasMessage("가로 라인이 겹칩니다.");
    }

    private static Stream<Arguments> providePoints() {
        return Stream.of(
                Arguments.of(List.of(true, true, false, false)),
                Arguments.of(List.of(false, true, true, false)),
                Arguments.of(List.of(false, false, true, true)),
                Arguments.of(List.of(true, true, false, true)),
                Arguments.of(List.of(true, false, true, true)),
                Arguments.of(List.of(false, true, true, true)),
                Arguments.of(List.of(true, true, true, false)),
                Arguments.of(List.of(true, true, true, true))
        );
    }
}
