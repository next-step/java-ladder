package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BridgeTest {

    @Test
    public void canCrossBridge_다리_존재_시_True_반환() {
        Bridge bridge = Bridge.of(true);

        assertThat(bridge.canCrossBridge()).isTrue();
    }

    @Test
    public void canCrossBridge_다리_없을_시_False_반환() {
        Bridge bridge = Bridge.of(false);

        assertThat(bridge.canCrossBridge()).isFalse();
    }

    @Test
    public void compareToNextBridge_연속된_두개가_True일시_에러_반환() {
        Bridge prev = Bridge.of(true);
        Bridge next = Bridge.of(true);

        assertThatThrownBy(() -> prev.compareToNextBridge(next))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void compareToNextBridge_연속된_두개가_True가_아닐시_정상동작_테스트() {
        Bridge prev = Bridge.of(false);
        Bridge next = Bridge.of(true);

        assertThatCode(() -> prev.compareToNextBridge(next))
                .doesNotThrowAnyException(); // 예외가 발생하지 않아야 함
    }
}
