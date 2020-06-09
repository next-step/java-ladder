package nextstep.ladder.domain.point;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

    @DisplayName("사다리가 연속적으로 존재하지 않으면 유효하다.")
    @ParameterizedTest
    @CsvSource(value = {
        "false,true",
        "false,false",
        "true,false"
    })
    void isValidLadder(boolean pre, boolean current) {
        Point prePoint = Point.first(() -> pre);
        Point currentPoint = prePoint.next(() -> current);

        assertThat(currentPoint.isValid(prePoint)).isEqualTo(true);
    }

    @DisplayName("사다리가 연속적으로 존재하면 유효하지 않다.")
    @Test
    void isInValidLadder() {
        Point prePoint = Point.first(() -> true);
        Point currentPoint = Point.first(() -> true);

        assertThat(currentPoint.isValid(prePoint)).isEqualTo(false);
    }

    @DisplayName("첫번째 point 방향이 오른쪽이면 1칸 이동한다.")
    @Test
    void first() {
        Point firstPoint = Point.first(() -> true);
        assertThat(firstPoint.move()).isEqualTo(1);
    }

    @DisplayName("이전 point 방향이 오른쪽이면 다음 point는 왼쪽방향이다.")
    @Test
    void next_right_false_if_pre_right_true() {
        Point pre = Point.first(() -> true);
        Point next = pre.next(() -> true);

        assertThat(next.move()).isEqualTo(0);
    }

    @DisplayName("이전 point 방향이 오른쪽 아니면 다음 point는 방향은 오른쪽/그대로 이다")
    @ParameterizedTest
    @CsvSource({
        "true,2",
        "false,1"
    })
    void next_right_or_none_if_pre_right_false(boolean hasRight, int nextPosition) {
        Point pre = Point.first(() -> false);
        Point next = pre.next(() -> hasRight);

        assertThat(next.move()).isEqualTo(nextPosition);
    }
}
