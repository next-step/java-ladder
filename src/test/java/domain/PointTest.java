package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test(expected = IllegalArgumentException.class)
    public void _1미만값을_전달하면_예외가_발생한다() {
        Point.valueOf(0, false);
    }

    @Test
    public void 같은_위치에_이동가능하다면_두_포인트는_같다() {
        Point point1 = Point.valueOf(2, true);
        Point point2 = Point.valueOf(2, true);

        assertThat(point1).isEqualTo(point2);
    }

    @Test
    public void 첫번째_포인트를_생성한다() {
        Point point = Point.first(true);
        assertThat(point.getLocation()).isEqualTo(1);
        assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    public void 마지막_포인트를_생성한다() {
        Point last = Point.last(Point.valueOf(3, true));
        assertThat(last.getLocation()).isEqualTo(4);
        assertThat(last.getDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    public void 왼쪽_방향_포인트는_직접_생성할수_없다() {
        Point point1 = Point.valueOf(2, true);
        assertThat(point1.getDirection()).isNotEqualTo(Direction.LEFT);

        Point point2 = Point.valueOf(2, false);
        assertThat(point2.getDirection()).isNotEqualTo(Direction.LEFT);
    }

    @Test
    public void 이동가능하게_생성한_포인트는_오른쪽으로_이동가능하다() {
        Point point = Point.first(true);
        assertThat(point.rightMovable()).isTrue();
    }

    @Test
    public void 오른쪽으로_연결된_포인트의_다음_포인트이므로_왼쪽으로_이동이_가능하다() {
        Point point = Point.next(Point.first(true), false);

        assertThat(point.leftMovable()).isTrue();
    }

    @Test
    public void 오른쪽_방향을_가진_포인트의_다음포인트는_무조건_왼쪽_방향을_가진다() {
        Point criteria = Point.first(true);

        Point nextTrue = Point.next(criteria, true);
        assertThat(nextTrue.getDirection()).isEqualTo(Direction.LEFT);

        Point nextFalse = Point.next(criteria, false);
        assertThat(nextFalse.getDirection()).isEqualTo(Direction.LEFT);

    }

    @Test
    public void 연결된_포인트가_없으면_다음_포인트는_어느_방향이든_가능하다() {
        Point criteria = Point.valueOf(2, false);

        Point nextTrue = Point.next(criteria, true);
        assertThat(nextTrue.getDirection()).isEqualTo(Direction.RIGHT);

        Point nextFalse = Point.next(criteria, false);
        assertThat(nextFalse.getDirection()).isEqualTo(Direction.NONE);
    }
}
