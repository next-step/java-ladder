package ladder2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import nextstep.ladder2.domain.NxBridge;
import nextstep.ladder2.domain.NxLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NxLineTest {
    @Test
    @DisplayName("한 Line에 인접한 Bridge인 경우, 예외를 발생한다.")
    void lineHasAdjacentBridgeTest() {
        assertThatThrownBy(() -> new NxLine(Arrays.asList(true, false, true, true)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line이 설계도상 적합한 Bridge를 반환하는지 확인한다.")
    void lineReturnValidBridgeTest() {
        NxLine line = new NxLine(Arrays.asList(true, false, true));
        NxBridge bridge = line.getBridgeByPoint(1);

        assertThat(bridge.movePosition(1)).isEqualTo(0);
    }
}
