package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @Test
    @DisplayName("LEFT는 왼쪽으로 간다.")
    void move_Left() {
        final Direction direction = Direction.LEFT;
        assertThat(direction.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("Right는 오른쪽으로 간다.")
    void move_Right() {
        final Direction direction = Direction.RIGHT;
        assertThat(direction.move(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("DOWN는 제자리로 내려간다.")
    void move_Down() {
        final Direction direction = Direction.DOWN;
        assertThat(direction.move(1)).isEqualTo(1);
    }
}
