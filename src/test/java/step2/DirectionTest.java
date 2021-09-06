package step2;

import org.junit.jupiter.api.Test;
import step2.model.Direction;

import static org.assertj.core.api.Assertions.*;

public class DirectionTest {
    @Test
    public void 방향_반환_테스트() {
        assertThat(Direction.findDirection(false, true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.findDirection(true, false)).isEqualTo(Direction.LEFT);
        assertThat(Direction.findDirection(false, false)).isEqualTo(Direction.DOWN);
    }

    @Test
    public void 선연속_예외_반환() {
        assertThatThrownBy(() -> Direction.findDirection(true, true))
                .isInstanceOf(IllegalStateException.class);
    }
}
