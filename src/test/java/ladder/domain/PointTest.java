package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 시작() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    public void 이동없음() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    public void 왼쪽으로_이동() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    public void 오른쪽으로_이동() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(2);
    }
}
