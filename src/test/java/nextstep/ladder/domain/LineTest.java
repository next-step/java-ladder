package nextstep.ladder.domain;

import nextstep.ladder.exception.LineDuplicateException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Direction.*;

public class LineTest {

    @ParameterizedTest
    @MethodSource("providePoints")
    @DisplayName("실패 - 가로 라인이 겹치는 경우 예외가 발생한다.")
    void fail_line_duplicate(List<Direction> directions) {
        Assertions.assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(LineDuplicateException.class)
                .hasMessage("가로 라인이 겹칩니다.");
    }

    private static Stream<Arguments> providePoints() {
        return Stream.of(
                Arguments.of(List.of(RIGHT, LEFT, LEFT, STAY)),
                Arguments.of(List.of(STAY, RIGHT, LEFT, LEFT))
        );
    }
}
