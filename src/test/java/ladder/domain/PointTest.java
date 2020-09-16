package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    private Point point;

    @DisplayName("올바른 사다리 규칙인지 테스트")
    @Test
    void point_Validate_Test() {
        assertThatThrownBy(() ->{
            Point.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫번째 사다리 생성 테스트")
    @Test
    void first_Ladder_Test() {
        point = Point.first(true);
        assertThat(point.isLeft()).isFalse();
        assertThat(point.isRight()).isTrue();
    }

    @DisplayName("다음 사다리 생성 테스트")
    @Test
    void next_Ladder_Test() {
        point = Point.next(Point.of(false, true), false);
        assertThat(point.isLeft()).isTrue();
        assertThat(point.isRight()).isFalse();
    }

    @DisplayName("마지막 사다리 생성 테스트")
    @Test
    void last_Ladder_Test() {
        point = Point.last(true);
        assertThat(point.isLeft()).isTrue();
        assertThat(point.isRight()).isFalse();
    }
}