package ladder;

import ladder.model.PointTdd;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTddTest {
    @Test
    public void first() {
        assertThat(PointTdd.first(TRUE).move()).isEqualTo(1);
        assertThat(PointTdd.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        PointTdd second = PointTdd.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        PointTdd second = PointTdd.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        PointTdd second = PointTdd.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        PointTdd second = PointTdd.first(TRUE).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
