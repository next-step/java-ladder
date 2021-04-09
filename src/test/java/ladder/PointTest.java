package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ladder.domain.Point;

public class PointTest {

    @Test
    void 생성_테스트() {
        assertThat(Point.of(0, true).toBoolean()).isEqualTo(true);
        assertThat(Point.of(0, false).toBoolean()).isEqualTo(false);
    }
}
