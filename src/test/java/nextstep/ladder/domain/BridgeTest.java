package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BridgeTest {

    @Test
    public void canCrossBridge_다리_존재_시_True_반환() {
        Bridge bridge = new Bridge(true);

        assertThat(bridge.canCrossBridge()).isTrue();
    }

    @Test
    public void canCrossBridge_다리_없을_시_False_반환() {
        Bridge bridge = new Bridge(false);

        assertThat(bridge.canCrossBridge()).isFalse();
    }
}
