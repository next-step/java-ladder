package ladder.domain.point;

import org.junit.jupiter.api.Test;

import static ladder.domain.point.Position.INITIAL_POSITION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    void Position은_초기값_미만으로_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Position(INITIAL_POSITION - 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
