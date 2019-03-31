import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void 첫번째포인트는_단절상태() {
        // given
        Point previous = null;
        // when
        Point point = Point.valueOf(previous);
        // then
        assertThat(point.isLinked()).isFalse();
    }

    @Test
    public void 이전포인트가_연결상태일때_단절상태_포인트_생성() {
        // given
        Point previous = Point.linkedPoint;
        // when
        Point point = Point.valueOf(previous);
        // then
        assertThat(point.isLinked()).isFalse();
    }
}
