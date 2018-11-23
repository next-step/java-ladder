package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    public void create() {
        Position p = new Position(0);
        assertThat(p).isEqualTo(new Position(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_position() {
        new Position(-1);
    }
}
