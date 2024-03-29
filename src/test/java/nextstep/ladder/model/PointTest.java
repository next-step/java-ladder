package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    void create() {
        Point point = new Point(false, false);
        assertThat(point).isEqualTo(new Point(false, false));
    }

    @Test
    void 연속으로_true인경우_예외를_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Point(true, true))
                .withMessage("연속으로 연결할 수 없습니다");
    }

    @Test
    void first() {
        Point first = Point.first(true);
        assertThat(first).isEqualTo(new Point(false, true));
    }

    @Test
    void last() {
        Point first = Point.first(true).last();
        assertThat(first).isEqualTo(new Point(true, false));
    }

    @Test
    void next() {
        Point first = Point.first(true).next(false);
        assertThat(first).isEqualTo(new Point(true, false));
    }

    @Test
    void 아래로_이동하는_경우() {
        Point point = new Point(false, false);
        assertThat(point.directionTo()).isEqualTo(Direction.DOWN);
    }

    @Test
    void 왼쪽으로_이동하는_경우() {
        Point point = new Point(true, false);
        assertThat(point.directionTo()).isEqualTo(Direction.LEFT);
    }

    @Test
    void 오른쪽으로_이동하는_경우() {
        Point point = new Point(false, true);
        assertThat(point.directionTo()).isEqualTo(Direction.RIGHT);
    }
}
