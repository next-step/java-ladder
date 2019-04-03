package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 첫번째포인트_왼쪽단절상태() {
        // given
        Point previous = null;
        // when
        Point first = Point.valueOf(previous);
        // then
        assertThat(first.isLeftLinked()).isFalse();
    }

    @Test
    public void 이전포인트가_오른쪽연결상태이면_현재포인트_왼쪽연결상태() {
        // given
        Point previous1 = Point.onlyRightLinkedPoint;
        // when
        Point current1 = Point.valueOf(previous1);
        // then
        assertThat(current1.isLeftLinked()).isTrue();
    }

    @Test
    public void 이전포인트가_오른쪽단절상태이면_현재포인트_왼쪽단절상태() {
        // given
        Point previous1 = Point.onlyLeftLinkedPoint;
        Point previous2 = Point.neitherLinkedPoint;
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
        Point previous2 = Point.neitherLinkedPoint;
        // when
        Point last2 = Point.getRightNotLinked(previous2);
        // then
        assertThat(last2.isRightLinked()).isFalse();
    }
}
