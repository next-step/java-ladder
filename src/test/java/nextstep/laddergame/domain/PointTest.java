package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("Point 연결 테스트")
    @Test
    public void pointConnectTest() {
        assertThat(new Point(true).isConnected()).isTrue();
        assertThat(new Point(false).isConnected()).isFalse();
    }

}