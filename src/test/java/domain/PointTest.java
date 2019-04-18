package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 첫번째_포인트를_생성한다() {
        Point point = Point.first(true);
        assertThat(point.getLocation()).isEqualTo(1);
    }

    @Test
    public void 다음_포인트를_생성한다() {
        Point point = Point.first(true);
        point = point.next(false);

        assertThat(point.getLocation()).isEqualTo(2);
    }

    @Test
    public void 앞으로_이동한다() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    public void 뒤로_이동한다() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    public void 이동하지_않는다() {
        Point point = Point.first(false);
        assertThat(point.move()).isEqualTo(1);
    }
}
