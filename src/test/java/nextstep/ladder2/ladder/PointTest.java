package nextstep.ladder2.ladder;

import nextstep.ladder2.domain.ladder.Direction;
import nextstep.ladder2.domain.ladder.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void 처음_포인트를_생성할수_있다() {
        Point point = Point.first(true);
        assertThat(point).isEqualTo(new Point(false, true));
    }

    @Test
    void 마지막_포인트를_생성할수_있다() {
        Point point = Point.first(true).last();
        assertThat(point).isEqualTo(new Point(true, false));
    }

    @Test
    void 다음_포인트를_생성할수있다() {
        Point point = Point.first(true).next(false);
        assertThat(point).isEqualTo(new Point(true, false));
    }

    @Test
    void 왼쪽값이_열려있다면_왼쪽으로_이동할수있다() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void 오른쪽값이열려있다면_오른쪽으로_이동할수있다() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void 한쪽이라도_열려있다면_연결할수있다() {
        assertThat(Point.first(false).canConnect(true)).isTrue();
        assertThat(Point.first(true).canConnect(false)).isTrue();
        assertThat(Point.first(false).canConnect(false)).isTrue();
    }

    @Test
    void 연속될수없다() {
        assertThat(Point.first(true).canConnect(true)).isFalse();
    }
}