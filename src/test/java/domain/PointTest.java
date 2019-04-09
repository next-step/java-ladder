package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test(expected = IllegalArgumentException.class)
    public void _1미만값을_전달하면_예외가_발생한다() {
        Point.valueOf(0, Direction.LEFT);
    }

    @Test
    public void 같은_위치와_방향을_가진_포인트는_같다() {
        Point point1 = Point.valueOf(2, Direction.RIGHT);
        Point point2 = Point.valueOf(2, Direction.RIGHT);

        assertThat(point1).isEqualTo(point2);
    }

    @Test
    public void 첫번째_포인트를_생성한다() {
        Point point = Point.first(Direction.RIGHT);
        assertThat(point.getLocation()).isEqualTo(1);
        assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 첫번째_포인트는_왼쪽으로_갈수없다() {
        Point.first(Direction.LEFT);
    }

    @Test
    public void 마지막_포인트를_생성한다() {
        Point last1 = Point.last(Point.valueOf(3, Direction.RIGHT));
        assertThat(last1).isEqualTo(Point.valueOf(4, Direction.LEFT));

        Point last2 = Point.last(Point.valueOf(3, Direction.NONE));
        assertThat(last2).isEqualTo(Point.valueOf(4, Direction.NONE));
    }

    @Test
    public void 오른쪽_방향을_가진_포인트의_다음포인트는_무조건_왼쪽_방향을_가진다() {
        Point point = Point.first(Direction.RIGHT);
        assertThat(Point.next(point, Direction.LEFT)).isEqualTo(Point.valueOf(2, Direction.LEFT));
        assertThat(Point.next(point, Direction.RIGHT)).isEqualTo(Point.valueOf(2, Direction.LEFT));
    }

    @Test
    public void 왼쪽_방향을_가진_포인트의_다음포인트는_NONE_RIGHT만_올수있다() {
        Point point = Point.valueOf(2, Direction.LEFT);
        assertThat(Point.next(point, Direction.RIGHT)).isEqualTo(Point.valueOf(3, Direction.RIGHT));
        assertThat(Point.next(point, Direction.NONE)).isEqualTo(Point.valueOf(3, Direction.NONE));
        assertThat(Point.next(point, Direction.LEFT)).isEqualTo(Point.valueOf(3, Direction.NONE));
    }

    @Test
    public void 해당_포인트가_왼쪽으로_이동가능한지_체크한다() {
        // 양쪽이 연결됨
        Point point1 = Point.valueOf(4, Direction.LEFT);
        assertThat(point1.leftMovable(Point.valueOf(3, Direction.RIGHT))).isTrue();

        // 왼쪽으로는 연결되었지만 오른쪽으로는 연결되지 못함
        Point point2 = Point.valueOf(4, Direction.LEFT);
        assertThat(point2.leftMovable(Point.valueOf(3, Direction.NONE))).isFalse();

        // 바로 옆 포인트가 아님
        Point point3 = Point.valueOf(4, Direction.LEFT);
        assertThat(point3.leftMovable(Point.valueOf(2, Direction.RIGHT))).isFalse();
    }

    @Test
    public void 해당_포인트가_오른쪽으로_이동가능한지_체크한다() {
        // 양쪽이 연결됨
        Point point1 = Point.first(Direction.RIGHT);
        assertThat(point1.rightMovable(Point.valueOf(2, Direction.LEFT))).isTrue();

        // 오른쪽으로는 연결되었지만 왼쪽으로는 연결되지 못함
        Point point2 = Point.first(Direction.RIGHT);
        assertThat(point2.rightMovable(Point.valueOf(2, Direction.NONE))).isFalse();

        // 바로 옆 포인트가 아님
        Point point3 = Point.first(Direction.RIGHT);
        assertThat(point3.rightMovable(Point.valueOf(3, Direction.LEFT))).isFalse();
    }
}
