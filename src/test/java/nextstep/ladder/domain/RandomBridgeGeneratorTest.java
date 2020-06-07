package nextstep.ladder.domain;

import nextstep.ladder.domain.bridge.BridgeGenerator;
import nextstep.ladder.domain.bridge.RandomBridgeGenerator;
import nextstep.ladder.fake.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBridgeGeneratorTest {

    private BridgeGenerator createBridge(Random random) {
        return new RandomBridgeGenerator(random);
    }

    @Test
    @DisplayName("true 반환 테스트")
    void returnAllTrueTest() {
        BridgeGenerator bridgeGenerator = this.createBridge(new FakeRandom(true));
        assertThat(bridgeGenerator.isCrossBridge()).isTrue();
    }

    @Test
    @DisplayName("false 반환 테스트")
    void returnAllFalseTest() {
        BridgeGenerator bridgeGenerator = this.createBridge(new FakeRandom(false));
        assertThat(bridgeGenerator.isCrossBridge()).isFalse();
    }
}
