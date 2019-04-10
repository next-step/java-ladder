package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test(expected = IllegalArgumentException.class)
    public void 라인중복회피() {
        Point point = new Point(true, true);
        boolean result = point.hasHorizontalLine();
        assertThat(result).isFalse();
    }

    @Test
    public void 라인중복안됨() {
        Point point = new Point(false, true);
        boolean result = point.hasHorizontalLine();
        assertThat(result).isTrue();
    }

    @Test
    public void 왼쪽으로이동() {
        Point point = new Point(true, false);
        boolean result = point.isLeft();
        assertThat(result).isTrue();
    }

    @Test
    public void 오른쪽으로이동() {
        Point point = new Point(false, true);
        boolean result = point.isRight();
        assertThat(result).isTrue();
    }

    @Test
    public void 이동안함() {
        Point point = new Point(false, false);
        boolean result = point.isCenter();
        assertThat(result).isTrue();
    }
}