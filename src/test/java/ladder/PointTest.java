package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void 새포인트_생성() {
        Point point = new Point(true);
        assertThat(point.isTrue()).isTrue();
    }
}
