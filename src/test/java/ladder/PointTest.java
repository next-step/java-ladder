package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ladder.domain.Point;

public class PointTest {

    @Test
    void 생성_테스트() {
        assertThat(Point.from(true)).isEqualTo(Point.CONNECT);
        assertThat(Point.from(false)).isEqualTo(Point.DISCONNECT);
    }
}
