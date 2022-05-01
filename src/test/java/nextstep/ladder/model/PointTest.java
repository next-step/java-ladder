package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("포인트")
class PointTest {

    @Test
    @DisplayName("연결 여부")
    void isConnected() {
        assertThat(Point.CONNECTED.isConnected()).isTrue();
        assertThat(Point.DISCONNECTED.isConnected()).isFalse();
    }
}
