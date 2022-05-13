package ladder.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    void Point는_position_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Point(null, Direction.RIGHT)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Point는_direction_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Point(Position.value(1), null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
