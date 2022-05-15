package ladder.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    void Point는_direction_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Point(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
