package nextstep.ladder.domain.line;

import nextstep.ladder.domain.bridge.Bridge;
import nextstep.ladder.domain.bridge.BridgeGenerator;
import nextstep.ladder.domain.bridge.RandomBridgeGenerator;
import nextstep.ladder.fake.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private static final int USER_COUNT = 5;
    private static final int BRIDGE_COUNT = USER_COUNT - 1;

    private Line createLine(int countOfPerson, BridgeGenerator bridgeGenerator) {
        return new Line(countOfPerson, bridgeGenerator);
    }

    @DisplayName("가능한 모든 bridge를 생성")
    @Test
    void createAllLineTest() {
        Line line = this.createLine(USER_COUNT, new RandomBridgeGenerator(new FakeRandom(true)));
        assertThat(line.getBridges()).hasSize(BRIDGE_COUNT);
        for (int i = 0 ; i < line.getBridges().size(); i += 2) {
            Bridge bridge = line.getBridges().get(i);
            assertThat(bridge.isCross()).isTrue();
        }
    }

    @DisplayName("bridge를 그리지 않는 테스트")
    @Test
    void createEmptyLineTest() {
        Line line = this.createLine(USER_COUNT, new RandomBridgeGenerator(new FakeRandom(false)));
        assertThat(line.getBridges()).hasSize(BRIDGE_COUNT);
        for (Bridge bridge : line.getBridges()) {
            assertThat(bridge.isCross()).isFalse();
        }
    }
}
