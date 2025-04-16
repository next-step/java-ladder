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

        List<User> users = List.of(new User("A"), new User("B"), new User("C"));
        List<String> results = List.of("꽝", "5000", "3000");

        LadderSimulator simulator = new LadderSimulator(ladder, users, results);

        String expectedResult = "꽝";
        LadderResult cache = simulator.getResults();
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

        List<User> users = List.of(new User("A"), new User("B"), new User("C"), new User("D"));
        List<String> results = List.of("꽝", "5000", "3000", "2000");

        LadderSimulator simulator = new LadderSimulator(ladder, users, results);

        String expectedResult = "2000";
        LadderResult cache = simulator.getResults();
        assertThat(cache.getResult("A")).isEqualTo(expectedResult);
    }
}
