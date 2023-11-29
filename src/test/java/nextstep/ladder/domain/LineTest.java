package nextstep.ladder.domain;

import nextstep.ladder.exception.LineDuplicateException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Direction.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @ParameterizedTest
    @MethodSource("provideDirection")
    @DisplayName("성공 - 위치에서 이동 한 후에 이동 후의 해당하는 방향을 구한다.")
    void success_find_direction(int position, int nextPosition) {
        Line line = new Line(new int[]{0, 1, -1});
        assertThat(line.move(position)).isEqualTo(nextPosition);
    }

    private static Stream<Arguments> provideDirection() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 2),
                Arguments.of(2, 1)
        );
    }

    @Test
    @DisplayName("성공 - 인원수를 토대로 Line을 생성한다 ")
    void success_create_line_by_count_of_person() {
        Line line = new Line(4);
        assertThat(line.size()).isEqualTo(4);
    }

}
