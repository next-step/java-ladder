package ladder.domain.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void 같은좌표_비교() {
        int x = 1;
        int y = 1;
        Point point = new Point(x, y);

        assertThat(point).isEqualTo(new Point(x, y));
    }
}