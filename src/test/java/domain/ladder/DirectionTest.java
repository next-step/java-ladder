package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DirectionTest {

    @Test
    public void go_left() {
        Pair pair = new Pair(Boolean.TRUE, Boolean.FALSE);
        int result = Direction.move(pair, 5);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void go_right() {
        Pair pair = new Pair(Boolean.FALSE, Boolean.TRUE);
        int result = Direction.move(pair, 5);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void go_forward() {
        Pair pair = new Pair(Boolean.FALSE, Boolean.FALSE);
        int result = Direction.move(pair, 5);
        assertThat(result).isEqualTo(5);
    }
}