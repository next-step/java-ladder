package ladder.domain.data;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void add() {
        Ladder ladder = new Ladder();
        ladder.add(new Line("|-| |"));
        assertThat(ladder.lines()).hasSize(1);
    }

    @Test
    void 개인_결과_계산() {
        Goals goals = new Goals(List.of("꽝", "5000", "3000"));
        Ladder ladder = new Ladder(goals);
        ladder.add(new Line("|-| |"));
        ladder.add(new Line("| |-|"));

        assertThat(ladder.run(new Person("a", 0))).isEqualTo(new Goal("3000"));
        assertThat(ladder.run(new Person("b", 1))).isEqualTo(new Goal("꽝"));
        assertThat(ladder.run(new Person("c", 2))).isEqualTo(new Goal("5000"));
    }
}
