package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PointTest {

    @Test
    public void 생성() {
        assertThat(Point.of(true, true)).isEqualTo(Point.of(true, true));
    }

    @Test
    public void 오른쪽이동() {
        Point point = Point.of(false, true);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    public void 왼쪽이동() {
        Point point = Point.of(true, false);
        assertThat(point.move()).isEqualTo(-1);
    }

    @Test
    public void 제자리() {
        Point point = Point.of(false, false);
        assertThat(point.move()).isEqualTo(0);
    }
}