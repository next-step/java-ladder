package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BridgeTest {
    @DisplayName("같은 연결 타입이면 true를 반환한다.")
    @Test
    void isSameBridgeType() {
        Bridge bridgeFirst = Bridge.createRightBridge();
        Bridge bridgeSecond = Bridge.createRightBridge();
        Bridge bridgeThird = Bridge.createLeftBridge();

        assertAll(
                () -> assertThat(Bridge.isSameBridgeType(bridgeFirst, bridgeSecond)).isTrue(),
                () -> assertThat(Bridge.isSameBridgeType(bridgeFirst, bridgeThird)).isFalse()
        );
    }

    @DisplayName("오른쪽 연결 또는 왼쪽 연결은 연결 여부 확인시 true를 반환한다.")
    @Test
    void isConnected() {
        Bridge bridgeRight = Bridge.createRightBridge();
        Bridge bridgeLeft = Bridge.createLeftBridge();
        Bridge bridgeNone = Bridge.createNotLinkedBridge();

        assertAll(
                () -> assertThat(bridgeRight.isConnected()).isTrue(),
                () -> assertThat(bridgeLeft.isConnected()).isTrue(),
                () -> assertThat(bridgeNone.isConnected()).isFalse()
        );
    }
}
