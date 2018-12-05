package ladder.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DirectionTest {

    @Test
    public void 왼쪽() {
        Direction direction = Direction.of(Boolean.TRUE, Boolean.FALSE);

        assertThat(direction).isEqualTo(Direction.LEFT);
    }
    @Test
    public void 오른쪽() {
        Direction direction = Direction.of(Boolean.FALSE, Boolean.TRUE);

        assertThat(direction).isEqualTo(Direction.RIGHT);

    }
    @Test
    public void 패스() {
        Direction direction = Direction.of(Boolean.FALSE, Boolean.FALSE);

        assertThat(direction).isEqualTo(Direction.PASS);

    }
}