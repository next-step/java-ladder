package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BridgeTest {

    @DisplayName("true 또는 false로 Bridge 생성시 연결여부를 결정한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void newBridge(boolean isConnect) {
        Bridge bridge = new Bridge(isConnect, 1);

        assertThat(bridge.isConnected()).isEqualTo(isConnect);
    }

    @DisplayName("두 인접 Bridge가 연속으로 연결되어있는지 확인")
    @ParameterizedTest
    @CsvSource({"true, true, true", "false, true, false", "true, false, false"})
    void isContinuousBridge(boolean beforeConnection, boolean nextConnection, boolean result) {
        Bridge before = new Bridge(beforeConnection, 1);
        Bridge next = new Bridge(nextConnection, 2);

        assertThat(Bridge.isContinuousBridge(before, next)).isEqualTo(result);
    }

    @DisplayName("두 Bridge가 인접 Bridge가 아니라면 연결 여부에 상관없이 false 반환")
    @ParameterizedTest
    @CsvSource({"true, true", "true, false", "false, true", "false, false"})
    void isContinuousBridgeNotNext(boolean beforeConnection, boolean nextConnection) {
        Bridge before = new Bridge(beforeConnection, 1);
        Bridge next = new Bridge(nextConnection, 3);

        assertThat(Bridge.isContinuousBridge(before, next)).isFalse();
    }
}
