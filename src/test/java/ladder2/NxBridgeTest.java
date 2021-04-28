package ladder2;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder2.domain.NxBridge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NxBridgeTest {
    @Test
    @DisplayName("Index가 왼쪽에서 오른쪽으로 이동한다.")
    void moveLeftToRightTest() {
        NxBridge bridge = new NxBridge(0, true);

        assertThat(bridge.movePosition(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("Index가 오른쪽에서 왼쪽으로 이동한다.")
    void moveRightToLeftTest() {
        NxBridge bridge = new NxBridge(0, true);

        assertThat(bridge.movePosition(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("Index가 Bridge와 연결되지 않은 경우, 예외를 발생한다.")
    void wrongBridgeIndexTest() {
        NxBridge bridge = new NxBridge(0, true);

        Assertions.assertThatThrownBy(() -> bridge.movePosition(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비활성화된 Bridge인 경우, 위치 그대로를 반환한다.")
    void disabledBridgeMoveTest() {
        NxBridge bridge = new NxBridge(0, false);

        assertThat(bridge.movePosition(1)).isEqualTo(1);
    }
}
