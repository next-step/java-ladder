package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ladder.domain.Point;

public class PointTest {

    @Test
    void 생성() {
        Point point = new Point();
        assertThat(point).isEqualTo(new Point(false));
    }
}
