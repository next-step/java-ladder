package ladder.backEnd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @Test
    @DisplayName("연결(-----) 있음")
    void create_bridge_connected() {
        Bridge neighbor = new Bridge(false);
        Bridge bridge = Bridge.create(() -> neighbor.isConnected(), () -> true);
        assertThat(bridge.isConnected()).isEqualTo(true);
    }

    @Test
    @DisplayName("연결(-----) 없음")
    void create_bridge_not_connected() {
        Bridge neighbor = new Bridge(true);
        Bridge bridge1 = Bridge.create(() -> neighbor.isConnected(), () -> true);
        Bridge bridge2 = Bridge.create(() -> neighbor.isConnected(), () -> false);
        assertThat(bridge1.isConnected()).isEqualTo(false);
        assertThat(bridge2.isConnected()).isEqualTo(false);
    }

}
