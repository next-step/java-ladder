package nextstep.ladder.domain;

import nextstep.ladder.fake.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private static final int USER_COUNT = 5;
    private static final int BRIDGE_COUNT = USER_COUNT;

    private Line createLine(int countOfPerson, MovementGenerator bridgeGenerator) {
        return new Line(countOfPerson, bridgeGenerator);
    }

    @DisplayName("가능한 모든 bridge를 생성")
    @Test
    void createAllLineTest() {
        Line line = this.createLine(USER_COUNT, new RandomMovementGenerator(new FakeRandom(true)));
        assertThat(line.getBridges()).hasSize(BRIDGE_COUNT);
        for (int i = 0 ; i < line.getBridges().size(); i += 2) {
            if (line.getBridges().size() - 1 == i) {
                break;
            }
            Bridge bridge = line.getBridges().get(i);
            assertThat(bridge.isRight()).isTrue();
        }
    }

    @DisplayName("bridge를 그리지 않는 테스트")
    @Test
    void createEmptyLineTest() {
        Line line = this.createLine(USER_COUNT, new RandomMovementGenerator(new FakeRandom(false)));
        assertThat(line.getBridges()).hasSize(BRIDGE_COUNT);
        for (Bridge bridge : line.getBridges()) {
            assertThat(bridge.isRight()).isFalse();
        }
    }
}
