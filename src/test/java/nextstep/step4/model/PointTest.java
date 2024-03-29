package nextstep.step4.model;

import org.junit.jupiter.api.Test;

import static nextstep.step4.model.Direction.DOWN;
import static nextstep.step4.model.Direction.LEFT;
import static nextstep.step4.model.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    void create() {
        Point point = new Point(true, false);
        assertThat(point).isEqualTo(new Point(true, false));
    }

    @Test
    void 연속적으로_참인경우_예외를_반환한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Point(true, true));
    }

    @Test
    void first() {
        Point first = Point.first(true);
        assertThat(first).isEqualTo(new Point(false, true));
    }

    @Test
    void next() {
        Point next = Point.first(true).next();
        assertThat(next).isEqualTo(new Point(true, false));
    }

    @Test
    void last() {
        Point last = Point.first(true).next().last();
        assertThat(last).isEqualTo(new Point(false, false));
    }

    @Test
    void moveToLeft() {
        Point point = Point.first(true).next();
        assertThat(point.move()).isEqualTo(LEFT);
    }

    @Test
    void moveToRight() {
        Point first = Point.first(true);
        assertThat(first.move()).isEqualTo(RIGHT);
    }

    @Test
    void moveToDown() {
        Point first = Point.first(false);
        assertThat(first.move()).isEqualTo(DOWN);
    }

}
