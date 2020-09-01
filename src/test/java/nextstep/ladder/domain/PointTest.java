package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PointTest {

    private Point point;

    @Test
    @DisplayName("첫번째 사다리 좌표 확인")
    void first() {
        point = new Point().isFirst(true);
        assertThat(point.isLeft()).isFalse();
        assertThat(point.isRight()).isTrue();
    }

    @Test
    @DisplayName("마지막 사다리 좌표 확인")
    void last() {
        point = new Point().isLast(true);
        assertThat(point.isLeft()).isTrue();
        assertThat(point.isRight()).isFalse();
    }

    @Test
    @DisplayName("다음 좌표 확인")
    void next() {
        Point previousPoint = new Point(false, true);
        point = new Point().next(previousPoint, false);
        assertThat(point.isLeft()).isTrue();
        assertThat(point.isRight()).isFalse();
    }

    @Test
    @DisplayName("left, right 모두 true가 온다면 사다리게임 규칙 위반으로 Exception 발생")
    void validate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Point(true, true);
                });
    }

}
