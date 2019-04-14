package ladder;

import ladder.domain.LinkedType;
import ladder.domain.Point;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 첫번째포인트_왼쪽단절상태() {
        // given
        // when
        Point first = Point.getFirst();
        // then
        assertThat(first.isLeftLinked()).isFalse();
    }

    @Test
    public void 이전포인트가_오른쪽연결상태이면_현재포인트_왼쪽연결상태() {
        // given
        Point previous1 = new Point(0, LinkedType.ONLY_RIGHT_LINKED);
        // when
        Point current1 = Point.valueOf(previous1);
        // then
        assertThat(current1.isLeftLinked()).isTrue();
    }

    @Test
    public void 이전포인트가_오른쪽단절상태이면_현재포인트_왼쪽단절상태() {
        // given
        Point previous1 = new Point(0, LinkedType.ONLY_LEFT_LINKED);
        Point previous2 = new Point(0, LinkedType.NEITHER_LINKED);
        // when
        Point current1 = Point.valueOf(previous1);
        Point current2 = Point.valueOf(previous2);
        // then
        assertThat(current1.isLeftLinked()).isFalse();
        assertThat(current2.isLeftLinked()).isFalse();
    }

    @Test
    public void 마지막포인트_오른쪽단절상태() {
        // given
        Point previous1 = new Point(0, LinkedType.ONLY_RIGHT_LINKED);
        Point previous2 = new Point(0, LinkedType.NEITHER_LINKED);
        Point previous3 = new Point(0, LinkedType.ONLY_LEFT_LINKED);
        // when
        Point last1 = Point.getLast(previous1);
        Point last2 = Point.getLast(previous2);
        Point last3 = Point.getLast(previous3);
        // then
        assertThat(last1.isRightLinked()).isFalse();
        assertThat(last2.isRightLinked()).isFalse();
        assertThat(last3.isRightLinked()).isFalse();
    }

    @Test
    public void 오른쪽으로_이동() {
        // given
        Point current = new Point(0, LinkedType.ONLY_RIGHT_LINKED);
        // when
        int nextIndex = current.move();
        // then
        assertThat(nextIndex).isEqualTo(1);
    }

    @Test
    public void 그대로() {
        // given
        Point current = new Point(0, LinkedType.NEITHER_LINKED);
        // when
        int nextIndex = current.move();
        // then
        assertThat(nextIndex).isEqualTo(0);
    }

    @Test
    public void 왼쪽으로_이동() {
        // given
        Point current = new Point(1, LinkedType.ONLY_LEFT_LINKED);
        // when
        int nextIndex = current.move();
        // then
        assertThat(nextIndex).isEqualTo(0);
    }
}
