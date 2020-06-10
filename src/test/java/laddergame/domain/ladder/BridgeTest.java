package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @DisplayName("첫번쨰 연결 다리는 다음 연결을 확인하지않고 생성한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void createFirstBridge(boolean isConnected) {
        Bridge firstBridge = Bridge.createFirstBridge(isConnected);

        assertThat(firstBridge.isConnected()).isEqualTo(isConnected);
    }

    @DisplayName("만약 이전 다리가 연결되어있고 연결된 다리를 새로 생성하려하면 연결이 끊긴 다리를 생성한다.")
    @ParameterizedTest
    @CsvSource({"false, true, true",
            "false, false, false",
            "true, false, false",
            "true, true, false"})
    void createNextBridge(boolean before, boolean current, boolean afterCreate) {
        Bridge beforeBridge = Bridge.createFirstBridge(before);

        Bridge currentBridge = Bridge.createNextBridge(current, beforeBridge);

        assertThat(currentBridge.isConnected()).isEqualTo(afterCreate);
    }
}
