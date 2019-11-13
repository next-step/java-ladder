package ladder;

import ladder.State.Direction;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StateTest {
    @Test
    void move() {
        State right = new State(FALSE, TRUE);
        assertThat(right.move()).isEqualTo(Direction.RIGHT);

        State left = new State(TRUE, FALSE);
        assertThat(left.move()).isEqualTo(Direction.LEFT);

        State center = new State(FALSE, FALSE);
        assertThat(center.move()).isEqualTo(Direction.CENTER);
    }

    @Test
    void first() {
        State first = State.first(TRUE);
        assertThat(first).isEqualTo(new State(FALSE, TRUE));
    }

    @Test
    void next() {
        State second = State.first(TRUE).next(FALSE);
        assertThat(second).isEqualTo(new State(TRUE, FALSE));
    }

    @Test
    void next_when_left_true() {
        State second = State.first(TRUE).next(TRUE);
        assertThat(second).isEqualTo(new State(TRUE, FALSE));
    }

    @Test
    void last() {
        State last = State.first(TRUE).last();
        assertThat(last).isEqualTo(new State(TRUE, FALSE));
    }

    @Test
    void 생성_invalid() {
        assertThatThrownBy(() -> new State(TRUE, TRUE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성() {
        State state = new State(FALSE, TRUE);
        assertThat(state).isEqualTo(new State(FALSE, TRUE));
    }
}
