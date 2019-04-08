package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
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
}