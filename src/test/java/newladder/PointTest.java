package newladder;


import newladder.model.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void 왼쪽_방향() {
        Point point = new Point(true, false);
        assertThat(point.isLeft()).isTrue();
    }

    @Test
    void 오른쪽_방향() {
        Point point = new Point(false, true);
        assertThat(point.isRight()).isTrue();
    }

    @Test
    void 멈춤() {
        Point point = new Point(false, false);
        assertThat(point.isLeft()).isFalse();
        assertThat(point.isRight()).isFalse();
    }

    @Test
    void 첫번째포인트_오른쪽() {
        Point point = Point.first(true);
        assertThat(point.isRight()).isTrue();
    }

    @Test
    void 첫번째포인트_왼쪽은_없어() {
        Point point = Point.first(false);
        assertThat(point.isLeft()).isFalse();
    }

    @Test
    void 마지막포인트_오른쪽은_없어() {
        Point point = Point.first(false);
        Point lastPoint = point.last();
        assertThat(lastPoint.isRight()).isFalse();
    }

}
