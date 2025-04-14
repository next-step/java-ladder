package ladder.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameSimulatorTest {

    @Test
    @DisplayName("2 x 3인 사다리에서 1번 인덱스에서 시작하면 0번 인덱스로 이동한다")
    void simulate_WhenLadderHasLines_ReturnsCorrectFinalIndex() {
        // |-| |
        Line line1 = new Line(List.of(true, false));
        // | |-|
        Line line2 = new Line(List.of(false, true));

        Ladder ladder = new Ladder(List.of(line1, line2));
        LadderGameSimulator simulator = new LadderGameSimulator(ladder);

        int initialIndex = 1;
        int expectedFinalIndex = 0;
        int resultIndex = simulator.simulate(initialIndex);
        assertThat(resultIndex).isEqualTo(expectedFinalIndex);
    }

    @Test
    @DisplayName("3 x 4인 사다리에서 0번 인덱스에서 시작하면 3번 인덱스로 이동한다")
    void simulate_WhenStartingAtEdge_ReturnsCorrectFinalIndex() {
        // |-| |-|
        Line line1 = new Line(List.of(true, false, true));
        // | |-| |
        Line line2 = new Line(List.of(false, true, false));
        // |-| |-|
        Line line3 = new Line(List.of(true, false, true));

        Ladder ladder = new Ladder(List.of(line1, line2, line3));
        LadderGameSimulator simulator = new LadderGameSimulator(ladder);

        int initialIndex = 0;
        int expectedFinalIndex = 3;
        int resultIndex = simulator.simulate(initialIndex);
        assertThat(resultIndex).isEqualTo(expectedFinalIndex); // Expected final index is still 0
    }
}
