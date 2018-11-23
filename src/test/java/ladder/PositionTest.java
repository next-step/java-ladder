package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    public void create() {
        Position p = Position.of(0);
        assertThat(p).isEqualTo(Position.of(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_position() {
        Position.of(-1);
    }
}
