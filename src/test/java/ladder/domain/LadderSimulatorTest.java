package ladder.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderSimulatorTest {

    @Test
    @DisplayName("2 x 3인 사다리에서 B 유저는 꽝을 받는다.")
    void simulate_WhenLadderHasLines_ReturnsCorrectFinalIndex() {
        // |-| |
        Line line1 = new Line(List.of(true, false));
        // | |-|
        Line line2 = new Line(List.of(false, true));
        Ladder ladder = new Ladder(List.of(line1, line2));

        List<String> users = List.of("A", "B", "C");
        List<String> results = List.of("꽝", "5000", "3000");

        LadderSimulator simulator = new LadderSimulator(ladder, users, results);

        String expectedResult = "꽝";
        LadderResultCache cache = simulator.simulateAll();
        assertThat(cache.getResult("B")).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("3 x 4인 사다리에서 A 유저는 2000을 받는다.")
    void simulate_WhenStartingAtEdge_ReturnsCorrectFinalIndex() {
        // |-| |-|
        Line line1 = new Line(List.of(true, false, true));
        // | |-| |
        Line line2 = new Line(List.of(false, true, false));
        // |-| |-|
        Line line3 = new Line(List.of(true, false, true));
        Ladder ladder = new Ladder(List.of(line1, line2, line3));

        List<String> users = List.of("A", "B", "C", "D");
        List<String> results = List.of("꽝", "5000", "3000", "2000");

        LadderSimulator simulator = new LadderSimulator(ladder, users, results);

        String expectedResult = "2000";
        LadderResultCache cache = simulator.simulateAll();
        assertThat(cache.getResult("A")).isEqualTo(expectedResult);
    }
}
