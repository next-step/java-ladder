package nextstep.ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    void getPointStatus() {
        Point falsePoint = new Point(false);
        Point truePoint = new Point(true);

        Assertions.assertThat(falsePoint.isConnect()).isEqualTo(false);
        Assertions.assertThat(truePoint.isConnect()).isEqualTo(true);
    }
}
