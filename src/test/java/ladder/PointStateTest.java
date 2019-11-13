package ladder;

import ladder.PointState.Direction;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointStateTest {
    @Test
    void move() {
        PointState right = new PointState(FALSE, TRUE);
        assertThat(right.move()).isEqualTo(Direction.RIGHT);

        PointState left = new PointState(TRUE, FALSE);
        assertThat(left.move()).isEqualTo(Direction.LEFT);

        PointState center = new PointState(FALSE, FALSE);
        assertThat(center.move()).isEqualTo(Direction.CENTER);
    }

    @Test
    void first() {
        PointState first = PointState.first(TRUE);
        assertThat(first).isEqualTo(new PointState(FALSE, TRUE));
    }

    @Test
    void next() {
        PointState second = PointState.first(TRUE).next(FALSE);
        assertThat(second).isEqualTo(new PointState(TRUE, FALSE));
    }

    @Test
    void next_when_left_true() {
        PointState second = PointState.first(TRUE).next(TRUE);
        assertThat(second).isEqualTo(new PointState(TRUE, FALSE));
    }

    @Test
    void last() {
        PointState last = PointState.first(TRUE).last();
        assertThat(last).isEqualTo(new PointState(TRUE, FALSE));
    }

    @Test
    void 생성_invalid() {
        assertThatThrownBy(() -> new PointState(TRUE, TRUE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성() {
        PointState pointState = new PointState(FALSE, TRUE);
        assertThat(pointState).isEqualTo(new PointState(FALSE, TRUE));
    }
}
