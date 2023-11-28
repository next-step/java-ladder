package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @RepeatedTest(10)
    void 같은_라인에_연속되는_다리는_생길_수_없다() {
        boolean active = new Point(true).nextPoint().isActive();
        assertThat(active).isFalse();
    }
}
