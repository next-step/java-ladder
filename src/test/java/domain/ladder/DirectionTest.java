package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DirectionTest {
    @Test
    public void go_left() {
        //given
        Pair pair = new Pair(Boolean.TRUE, Boolean.FALSE);

        //when
        int result = Direction.move(pair, 5);

        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void go_right() {
        //given
        Pair pair = new Pair(Boolean.FALSE, Boolean.TRUE);

        //when
        int result = Direction.move(pair, 5);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void go_forward() {
        //given
        Pair pair = new Pair(Boolean.FALSE, Boolean.FALSE);

        //when
        int result = Direction.move(pair, 5);

        //then
        assertThat(result).isEqualTo(5);
    }
}