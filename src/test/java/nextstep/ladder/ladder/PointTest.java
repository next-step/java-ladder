package nextstep.ladder.ladder;

import nextstep.ladder.strategy.RandomLadderStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("첫번째 포인트를 이동했을 때의 위치 테스트")
    @Test
    void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isZero();
    }

    @DisplayName("첫번째와 두 번째 포인트가 false 일 경우 이동하지 않는다.")
    @Test
    void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("첫번째 포인트가 true 이고, 현재 포인트가 false 이면 인덱스가 1 감소 한다.")
    @Test
    void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isZero();
    }

    @DisplayName("첫번째 포인트가 false 이고 현재 포인트가 true 이면 인덱스가 1 증가한다.")
    @Test
    void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("첫 번째 포인트가 true 이면 현재 포인트는 false 이므로 인덱스가 1 감소한다.")
    @Test
    void next() {
        Point next = Point.first(TRUE).next(new RandomLadderStrategy());
        assertThat(next.move()).isZero();
    }
}