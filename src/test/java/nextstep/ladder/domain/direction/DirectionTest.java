package nextstep.ladder.domain.direction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {

    @Test
    void moveDown() {
        Direction direction = Direction.DOWN;

        assertThat(direction.moveX(1)).isEqualTo(1);
        assertThat(direction.moveY(0)).isEqualTo(1);
    }

    @Test
    void moveRightDown() {
        Direction direction = Direction.RIGHT_DOWN;

        assertThat(direction.moveX(1)).isEqualTo(2);
        assertThat(direction.moveY(0)).isEqualTo(1);
    }

    @Test
    void moveLeftDown() {
        Direction direction = Direction.LEFT_DOWN;

        assertThat(direction.moveX(1)).isEqualTo(0);
        assertThat(direction.moveY(0)).isEqualTo(1);
    }

    @Test
    void throwExceptionIfMoveLeftDownToNegative() {
        assertThatIllegalArgumentException().isThrownBy(() -> Direction.LEFT_DOWN.moveX(0));
    }
}
