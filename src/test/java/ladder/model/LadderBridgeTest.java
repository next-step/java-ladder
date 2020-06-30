package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 가로 라인 테스트")
public class LadderBridgeTest {

    @DisplayName("사다리 가로 라인 테스트")
    @Test
    public void makeLadderBridgeTest() {
        assertThat(LadderBridge.makeLadderBridgeByPreBridge(LadderBridge.EXIST)).isNotEqualTo(LadderBridge.EXIST);
        assertThat(LadderBridge.makeLadderBridgeByPreBridge(null)).isIn(Arrays.asList(LadderBridge.values()));
        assertThat(LadderBridge.makeLadderBridgeByPreBridge(LadderBridge.NOT_EXIST)).isIn(Arrays.asList(LadderBridge.values()));
    }

    @DisplayName("랜덤 가로 라인 테스트")
    @Test
    public void randomBridgeTest() {
        assertThat(LadderBridge.randomBridge()).isIn(Arrays.asList(LadderBridge.values()));
    }
}