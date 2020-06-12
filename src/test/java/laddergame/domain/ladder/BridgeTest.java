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

    @DisplayName("만약 이전 다리가 오른쪽 연결이면 만드려는 다리는 생성 여부에 상관없이 왼쪽 연결이다.")
    @ParameterizedTest
    @CsvSource({"true, true, LEFT",
            "true, false, LEFT"})
    void createNextBridge(boolean before, boolean current, BridgeType afterCreate) {
        Bridge beforeBridge = Bridge.createFirstBridge(before);

        Bridge currentBridge = Bridge.createNextBridge(current, beforeBridge);

        assertThat(currentBridge.getBridgeType()).isEqualTo(afterCreate);
    }
}
