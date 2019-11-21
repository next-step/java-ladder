package nextstep.ladder;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.PointState;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void pointMoveTest() {
        Point linePoint = new Point(0, new PointState(true, null));
        assertThat(linePoint.move()).isEqualTo(1);
        assertThat(new Point(1, false, linePoint).move()).isEqualTo(0);

        Point noLinePoint = new Point(0, new PointState(false, null));
        assertThat(noLinePoint.move()).isEqualTo(0);
    }
}
