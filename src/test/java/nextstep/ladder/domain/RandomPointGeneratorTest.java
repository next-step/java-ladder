package nextstep.ladder.domain;

import nextstep.ladder.fake.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomPointGeneratorTest {

    private MovementGenerator createBridge(Random random) {
        return new RandomMovementGenerator(random);
    }

    @Test
    @DisplayName("true 반환 테스트")
    void returnAllTrueTest() {
        MovementGenerator bridgeGenerator = this.createBridge(new FakeRandom(true));
        assertThat(bridgeGenerator.isMove()).isTrue();
    }

    @Test
    @DisplayName("false 반환 테스트")
    void returnAllFalseTest() {
        MovementGenerator bridgeGenerator = this.createBridge(new FakeRandom(false));
        assertThat(bridgeGenerator.isMove()).isFalse();
    }
}
