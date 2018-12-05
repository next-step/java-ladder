package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 첫번째_Point_방향_생성시_무조건_RIGHT() {
        Point first = Point.first(true);

        assertThat(first).isEqualTo(new Point(0, Direction.RIGHT));
    }

    @Test
    public void 현재_Point_방향_RIGHT_면_다음_Point_방향_무조건_LEFT() {
        Point point = new Point(0, Direction.RIGHT);
        Point next = point.next(true);

        assertThat(next).isEqualTo(new Point(1, Direction.LEFT));
    }

    @Test
    public void 현재_Point_방향_RIGHT_아닐_때_다음_Point_방향_생성시엔_RIGHT() {
        Point point = new Point(0, Direction.NONE);
        Point next = point.next(true);

        assertThat(next).isEqualTo(new Point(1, Direction.RIGHT));
    }

    @Test
    public void 마지막_Point_의_이전_Point_가_RIGHT_면_무조건_LEFT() {
        Point prev = new Point(1, Direction.RIGHT);
        Point last = prev.last();

        assertThat(last).isEqualTo(new Point(2, Direction.LEFT));
    }

    @Test
    public void 마지막_Point_의_이전_Point_RIGHT_아니면_무조건_NONE() {
        Point prev = new Point(1, Direction.NONE);
        Point last = prev.last();

        assertThat(last).isEqualTo(new Point(2, Direction.NONE));
    }
}