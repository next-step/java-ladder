package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {
    @Test
    @DisplayName("Bridge 동작 확인 - true, false 경우")
    void testLeftRightConnection() {
        Bridge bridge = new Bridge(true, false);
        assertThat(bridge.isLeftConnected()).isTrue();
        assertThat(bridge.isRightConnected()).isFalse();
        assertThat(bridge.nextDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("Bridge 동작 확인 - false, true 경우")
    void testRightConnection() {
        Bridge bridge = new Bridge(false, true);
        assertThat(bridge.isLeftConnected()).isFalse();
        assertThat(bridge.isRightConnected()).isTrue();
        assertThat(bridge.nextDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("Bridge 동작 확인 - false, false 경우")
    void testNoConnection() {
        Bridge bridge = new Bridge(false, false);
        assertThat(bridge.isLeftConnected()).isFalse();
        assertThat(bridge.isRightConnected()).isFalse();
        assertThat(bridge.nextDirection()).isEqualTo(Direction.STAY);
    }

    @Test
    @DisplayName("Bridge 생성 에러 확인 - true, true 경우")
    void testBothSidesConnected() {
        assertThatThrownBy(() -> new Bridge(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Bridge.INVALID_CONNECTION_ERROR);
    }
}
