package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void first() {
        final Point firstPoint = Point.first(Movable.FALSE);
        assertThat(firstPoint.hasIndex(0)).isEqualTo(true);
        assertThat(firstPoint.hasDirection(Direction.NONE)).isEqualTo(true);
    }

    @Test
    public void last() {
        final Point lastPoint = Point.first(Movable.TRUE).last();
        assertThat(lastPoint.hasIndex(1)).isEqualTo(true);
        assertThat(lastPoint.hasDirection(Direction.LEFT)).isEqualTo(true);
    }

    @Test
    public void next_이동없음() {
        final Point second = Point.first(Movable.FALSE).next(Movable.FALSE);
        assertThat(second.hasDirection(Direction.NONE)).isEqualTo(true);
    }

    @Test
    public void next_왼쪽이동() {
        final Point second = Point.first(Movable.TRUE).next(Movable.FALSE);
        assertThat(second.hasDirection(Direction.LEFT)).isEqualTo(true);
    }

    @Test
    public void next_오른쪽이동() {
        final Point second = Point.first(Movable.FALSE).next(Movable.TRUE);
        assertThat(second.hasDirection(Direction.RIGHT)).isEqualTo(true);
    }
}