package ladder;

import ladder.model.DirectionTdd;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTddTest {
    @Test
    public void init() {
        assertThat(DirectionTdd.of(true, false)).isEqualTo(DirectionTdd.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> DirectionTdd.of(TRUE, TRUE));
    }

    @Test
    public void next_random_true() {
        DirectionTdd next = DirectionTdd.first(TRUE).next();
        assertThat(next).isEqualTo(DirectionTdd.of(TRUE, FALSE));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            DirectionTdd.first(FALSE).next();
        }
    }

    @Test
    public void next_true() {
        DirectionTdd next = DirectionTdd.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(DirectionTdd.of(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        DirectionTdd next = DirectionTdd.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(DirectionTdd.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        DirectionTdd first = DirectionTdd.first(TRUE);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @Test
    public void last() {
        DirectionTdd last = DirectionTdd.first(TRUE).last();
        assertThat(last).isEqualTo(DirectionTdd.of(TRUE, FALSE));
    }
}
