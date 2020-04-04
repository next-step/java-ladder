package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 가로 라인 테스트")
public class LadderBridgeTests {

    @DisplayName("사다리 가로 라인 테스트")
    @Test
    public void nextLadderBridgeTests() {
        assertThat(LadderBridge.makeRandomBridgeByPreBridge(LadderBridge.EXIST)).isNotEqualTo(LadderBridge.EXIST);
        assertThat(LadderBridge.makeRandomBridgeByPreBridge(null)).isIn(Arrays.asList(LadderBridge.values()));
        assertThat(LadderBridge.makeRandomBridgeByPreBridge(LadderBridge.UN_EXIST)).isIn(Arrays.asList(LadderBridge.values()));
    }
}
