package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {
    @Test
    public void 생성() {
        assertThat(new Points(1)).isInstanceOf(Points.class);
    }

    @Test
    public void 연속으로_연결하면_안됨() {
        assertThat(new Points(2)).isNotEqualTo(new Points(Arrays.asList(new Point(true), new Point(true))));
    }
}
