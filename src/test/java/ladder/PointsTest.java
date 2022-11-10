package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {
    private static final Point connectedPoint = new Point(true);
    private static final Point notConnectedPoint = new Point(false);

    @Test
    public void 생성() {
        assertThat(new Points(1)).isInstanceOf(Points.class);
    }

    @Test
    public void 연속으로_연결하면_안됨() {
        assertThat(new Points(2)).isNotEqualTo(new Points(Arrays.asList(connectedPoint, connectedPoint)));
    }

    @Test
    public void 연결이_하나라도_있어야함() {
        assertThat(new Points(2)).isNotEqualTo(new Points(Arrays.asList(notConnectedPoint, notConnectedPoint)));
    }

    @Test
    public void 첫번째는_연결되거나_연결_안될_수_있음() {
        assertThat(new Points(1, () -> true)).isEqualTo(new Points(Arrays.asList(connectedPoint)));
    }

    @Test
    public void connections() {
        Points points = new Points(Arrays.asList(new Point(true), new Point(true)));
        assertThat(points.connections()).isEqualTo(Arrays.asList(true, true));
    }
}
