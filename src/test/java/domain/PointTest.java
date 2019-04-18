package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 첫번째_포인트를_생성한다() {
        Point point = Point.first(true);
        assertThat(point.getLocation()).isEqualTo(1);
        assertThat(point.getDirection().leftMovable()).isFalse();
        assertThat(point.getDirection().rightMovable()).isTrue();
    }

    @Test
    public void 다음_포인트를_생성한다() {
        Point point = Point.first(true).next(false);
        assertThat(point.getLocation()).isEqualTo(2);
        assertThat(point.getDirection().leftMovable()).isTrue();
        assertThat(point.getDirection().rightMovable()).isFalse();

        point = point.next(true);
        assertThat(point.getLocation()).isEqualTo(3);
        assertThat(point.getDirection().leftMovable()).isFalse();
        assertThat(point.getDirection().rightMovable()).isTrue();
    }

    @Test
    public void 연속으로_선을_그을수_없다() {
        Point point = Point.first(true).next(true);
        assertThat(point.getDirection().leftMovable()).isTrue();
        assertThat(point.getDirection().rightMovable()).isFalse();
    }

    @Test
    public void 마지막_포인트를_생성한다() {
        Point point = Point.first(true).last();
        assertThat(point.getDirection().leftMovable()).isTrue();
        assertThat(point.getDirection().rightMovable()).isFalse();
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
