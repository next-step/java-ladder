package nextstep.refactor_ladder.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointTest {
    @Test
    @DisplayName("첫번째 지점에서 이동 검증")
    void move_first() {
        assertAll(() -> {
            assertThat(Point.first(true).move()).isEqualTo(1);
            assertThat(Point.first(false).move()).isZero();
        });
    }

    @Test
    @DisplayName("중간 지점에서 이동 검증")
    void move_middle() {
        assertAll(() -> {
            assertThat(Point.of(1, Direction.of(false, false)).move()).isEqualTo(1);
            assertThat(Point.of(1, Direction.of(true, false)).move()).isZero();
            assertThat(Point.of(1, Direction.of(false, true)).move()).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("마지막 지점에서 이동 검증")
    void move_last() {
        assertAll(() -> {
            assertThat(Point.of(1, Direction.of(false, true)).last().move()).isEqualTo(1);
            assertThat(Point.of(1, Direction.of(false, false)).last().move()).isEqualTo(2);
            assertThat(Point.of(1, Direction.of(true, false)).last().move()).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("왼쪽이 참이고, 오른쪽이 거짓인 경우 왼쪽으로 이동 검증")
    void next_left() {
        Point second = Point.first(true).next(() -> false);
        assertThat(second.move()).isZero();
    }

    @Test
    @DisplayName("왼쪽이 거짓이고, 오른쪽이 참인 경우 오른쪽으로 이동 검증")
    void next_right() {
        Point second = Point.first(false).next(() -> true);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("왼쪽, 오른쪽 모두 거짓인 경우 제자리 검증")
    void next_stay() {
        Point second = Point.first(false).next(() -> false);
        assertThat(second.move()).isEqualTo(1);
    }
}
