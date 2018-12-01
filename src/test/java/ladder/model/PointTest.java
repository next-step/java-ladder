package ladder.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 생성() {
        assertThat(Point.from(true)).isNotNull();
    }

    @Test
    public void 연속시_충돌() {
        assertThat(Point.from(true).isCollapse(Point.from(true))).isTrue();
    }

    @Test
    public void 연속시_허용() {
        assertThat(Point.from(false).isCollapse(Point.from(true))).isFalse();
        assertThat(Point.from(true).isCollapse(Point.from(false))).isFalse();
        assertThat(Point.from(false).isCollapse(Point.from(false))).isFalse();
    }
}