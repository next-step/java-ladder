package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("연결된 포인트는 true 상태값을 가짐")
    @Test
    void connect() {
        assertThat(Point.connect().isConnect()).isTrue();
    }

    @DisplayName("연결 해제된 포인트는 false 상태값을 가짐")
    @Test
    void unconnect() {
        assertThat(Point.disconnect().isConnect()).isFalse();
    }
}
