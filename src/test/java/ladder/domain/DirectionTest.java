package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void 왼쪽() {
        assertThat(Direction.create(true, false).isLeft()).isTrue();
    }

    @Test
    public void 오른쪽() {
        assertThat(Direction.create(false, true).isRight()).isTrue();
    }

    @Test
    public void 방향없음() {
        assertThat(Direction.create(false, false).isNone()).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 잘못된방향() {
        Direction.create(true, true);
    }
}
