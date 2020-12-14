package ladder.step3_renewal.domain;

import org.junit.jupiter.api.Test;
import step3_renewal.domain.Direction;
import step3_renewal.domain.Point;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 현재위치에서_왼쪽으로이동() {
        Point point = new Point(0, Direction.of(true, false));
        assertThat(point.move()).isEqualTo(-1);
    }

    @Test
    public void 현재위치에서_오른쪽이동() {
        Point point = new Point(0, Direction.of(false, true));
        assertThat(point.move()).isEqualTo(1);
    }
}
