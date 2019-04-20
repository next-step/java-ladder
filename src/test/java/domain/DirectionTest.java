package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    public void init() {
        Direction.generate(true, false);
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        Direction.generate(true, true);
    }

    @Test
    public void isLeftMovable_true() {
        assertThat(Direction.generate(true, false).isLeftMovable()).isTrue();
    }

    @Test
    public void isLeftMovable_false() {
        assertThat(Direction.generate(false, true).isLeftMovable()).isFalse();
    }

    @Test
    public void isRightMovable_true() {
        assertThat(Direction.generate(false, true).isRightMovable()).isTrue();
    }

    @Test
    public void isRightMovable_false() {
        assertThat(Direction.generate(true, false).isRightMovable()).isFalse();
    }
}
