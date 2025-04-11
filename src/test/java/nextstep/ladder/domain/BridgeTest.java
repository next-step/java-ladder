package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    @Test
    @DisplayName("2가지 생성자 동작 확인")
    void constructor_test() {
        assertThat(new Bridge()).isInstanceOf(Bridge.class);
        assertThat(new Bridge(true)).isInstanceOf(Bridge.class);
    }

    @Test
    @DisplayName("다리 생성 시 true 다음에 다리는 false 가 와야 함")
    void nextBridgeTest() {
        Bridge bridge = new Bridge(true);
        Bridge nextBridge = bridge.nextBridge();

        assertThat(nextBridge.isConnected()).isFalse();
    }
}
