package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    void 왼쪽으로_이동() {
        Direction direction = new Direction(true, false);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void 오른쪽으로_이동() {
        Direction direction = new Direction(false, true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void 제자리() {
        Direction direction = new Direction(false, false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void 첫_포인트는_오른쪾으로만_이동_가능() {
        Direction expectedDirection = new Direction(false, true);
        assertThat(Direction.first(true)).isEqualTo(expectedDirection);
    }

    @Test
    void 왼쪽_오른쪽_동시_이동_불가() {
        // when
        assertThatThrownBy(() -> new Direction(true, true))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌,우 동시에 이동할 수 없습니다.");
    }
}