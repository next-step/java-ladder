package step2;

import org.junit.jupiter.api.Test;
import step2.model.Direction;
import step2.model.Point;

import static org.assertj.core.api.Assertions.*;

public class DirectionTest {
    @Test
    public void 방향_반환_테스트() {
        assertThat(Direction.findDirection(new Point(false, true))).isEqualTo(Direction.RIGHT);
        assertThat(Direction.findDirection(new Point(true, false))).isEqualTo(Direction.LEFT);
        assertThat(Direction.findDirection(new Point(false, false))).isEqualTo(Direction.DOWN);
    }

    @Test
    public void 선연속_예외_반환() {
        assertThatThrownBy(() -> Direction.findDirection(new Point(true, true)))
                .isInstanceOf(IllegalStateException.class);
    }
}
