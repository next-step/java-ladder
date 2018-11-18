package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PointTest {

    @Test
    public void 생성() {
        assertThat(Point.of(true)).isEqualTo(Point.of(true));
    }
}