package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("Point 인스턴스의 다음 이동이 Direction.PASS 인지 확인")
    @Test
    void pass() {
        Point point = new Point(false, true);
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }
}