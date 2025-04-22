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
        assertThat(bridge.isRightConnected()).isFalse();
        assertThat(bridge.nextDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("Bridge 동작 확인 - false, true 경우")
    void testRightConnection() {
        Bridge bridge = new Bridge(false, true);
        assertThat(bridge.isRightConnected()).isTrue();
        assertThat(bridge.nextDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("Bridge 동작 확인 - false, false 경우")
    void testNoConnection() {
        Bridge bridge = new Bridge(false, false);
        assertThat(bridge.nextDirection()).isEqualTo(Direction.STAY);
    }

    @Test
    @DisplayName("Bridge 생성 에러 확인 - true, true 경우")
    void testBothSidesConnected() {
        assertThatThrownBy(() -> new Bridge(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Bridge.INVALID_CONNECTION_ERROR);
    }

    @Test
    @DisplayName("연결된 Bridge와의 정보 일치성 확인")
    void testIsValidWithNext() {
        Bridge bridge = new Bridge(false, true);
        Bridge nextBridge = new Bridge(true, false);
        Bridge invalidBridge = new Bridge(false, false);
        assertThat(bridge.notMatchWithNext(nextBridge)).isFalse();
        assertThat(bridge.notMatchWithNext(invalidBridge)).isTrue();
    }

    @Test
    @DisplayName("첫번째/마지막 Bridge는 왼쪽/오른쪽으로 연결되면 안됨")
    void testNotValidAsFirstOrLast() {
        Bridge firstBridge = new Bridge(false, true);
        Bridge lastBridge = new Bridge(true, false);
        assertThat(firstBridge.notValidAsFirst()).isFalse();
        assertThat(lastBridge.notValidAsLast()).isFalse();

        Bridge invalidFirstBridge = new Bridge(true, false);
        Bridge invalidLastBridge = new Bridge(false, true);
        assertThat(invalidFirstBridge.notValidAsFirst()).isTrue();
        assertThat(invalidLastBridge.notValidAsLast()).isTrue();
    }
}
