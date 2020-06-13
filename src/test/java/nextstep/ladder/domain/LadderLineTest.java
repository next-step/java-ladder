package nextstep.ladder.domain;

import nextstep.ladder.fake.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {
    private static final int USER_COUNT = 5;
    private static final int BRIDGE_COUNT = USER_COUNT;

    private LadderLine createLine(int countOfPerson, MovementGenerator bridgeGenerator) {
        return LadderLine.generateLadderLines(countOfPerson, bridgeGenerator);
    }

    @DisplayName("가능한 모든 bridge를 생성")
    @Test
    void createAllLineTest() {
        LadderLine ladderLine = this.createLine(USER_COUNT, new RandomMovementGenerator(new FakeRandom(true)));
        assertThat(ladderLine.getPoints()).hasSize(BRIDGE_COUNT);
        for (int i = 0; i < ladderLine.getPoints().size(); i += 2) {
            if (ladderLine.getPoints().size() - 1 == i) {
                break;
            }
            Point point = ladderLine.getPoints().get(i);
            assertThat(point.isRight()).isTrue();
        }
    }

    @DisplayName("bridge를 그리지 않는 테스트")
    @Test
    void createEmptyLineTest() {
        LadderLine ladderLine = this.createLine(USER_COUNT, new RandomMovementGenerator(new FakeRandom(false)));
        assertThat(ladderLine.getPoints()).hasSize(BRIDGE_COUNT);
        for (Point point : ladderLine.getPoints()) {
            assertThat(point.isRight()).isFalse();
        }
    }
}
