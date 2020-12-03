package step2.hint;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    void next_random_true() {
        Direction next = Direction.first(TRUE).next(new CreateLadderPointGenerator());
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next(new CreateLadderPointGenerator());
        }
    }

    @Test
    void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }


    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }

}