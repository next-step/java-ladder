package ladder.direction;

import ladder.model.move.Direction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false))
                .isEqualTo(Direction.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Direction.of(true, true))
                .withMessage("올바르지 못한 방향입니다.");
    }

    @Test
    public void next_random_true() {
        assertThat(Direction.first(true).next())
                .isEqualTo(Direction.of(true, false));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(false).next();
        }
    }

    @Test
    public void next_true() {
        assertThat(Direction.of(true, false).next(true))
                .isEqualTo(Direction.of(false, true));
    }


    @Test
    public void next_false() {
        assertThat(Direction.of(false, true).next(false))
                .isEqualTo(Direction.of(true, false));
    }


    @Test
    public void first() {
        assertThat(Direction.first(true).isLeft())
                .isEqualTo(false);
    }

    @Test
    public void last() {
        assertThat(Direction.first(true).last())
                .isEqualTo(Direction.of(true, false));
    }
}