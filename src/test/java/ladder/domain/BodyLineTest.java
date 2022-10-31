package ladder.domain;

import static ladder.domain.Point.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BodyLineTest {
    @DisplayName("라인의 길이는 사람 수 * 2 - 1 이고, 시작과 끝에 수직선이 있다.")
    @Test
    void points() {
        int countOfPerson = 3;
        assertThat(new BodyLine(countOfPerson).getPoints())
                .hasSize(countOfPerson * 2 - 1)
                .startsWith(VERTICAL_LINE)
                .endsWith(VERTICAL_LINE);
    }

    @DisplayName("이전 포인트가 수평선이라면 수평선이 오고, 수평선이 아니라면 수평선 / 공백이 온다.")
    @ParameterizedTest
    @MethodSource("choiceBeforeLastSet")
    void choiceBeforeLast(Point before, List<Point> expected) {
        assertThat(new BodyLine(2).choiceBeforeLast(before)).isIn(expected);
    }

    private static Stream<Arguments> choiceBeforeLastSet() {
        return Stream.of(
                Arguments.arguments(VERTICAL_LINE, List.of(HORIZON, BLANK)),
                Arguments.arguments(HORIZON, List.of(HORIZON)),
                Arguments.arguments(BLANK, List.of(HORIZON, BLANK))
        );
    }
}
