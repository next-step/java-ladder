package nextstep.ladder;

import nextstep.ladder.domain.point.PointState;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointStateTest {

    @Test
    void moveableTest() {
        PointState pointState = new PointState(false, null);

        assertThat(pointState.canMoveNext()).isFalse();
        assertThat(pointState.canMovePrevious()).isFalse();

        PointState pointState2 = new PointState(true, pointState);

        assertThat(pointState2.canMoveNext()).isTrue();
        assertThat(pointState2.canMovePrevious()).isFalse();

        PointState pointState3 = pointState2.createNextStateWithNoLine();

        assertThat(pointState3.canMoveNext()).isFalse();
        assertThat(pointState3.canMovePrevious()).isTrue();
    }
}
