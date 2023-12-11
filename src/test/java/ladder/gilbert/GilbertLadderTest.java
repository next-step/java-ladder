package ladder.gilbert;

import java.util.List;

import ladder.engine.Ladder;
import ladder.gilbert.domain.data.Goals;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GilbertLadderTest {

    @Test
    void add() {
        GilbertLadder ladder = new GilbertLadder(List.of());
        ladder.add(new GilbertLine("|-| |"));
        assertThat(ladder.lines()).hasSize(1);
    }

    @Test
    void 개인_결과_계산() {
        GilbertLadder ladder = ladder();
        assertThat(ladder.run(0).get(0)).isEqualTo(2);
        assertThat(ladder.run(1).get(1)).isEqualTo(0);
        assertThat(ladder.run(2).get(2)).isEqualTo(1);
    }


    @Test
    void 전체_결과_계산() {
        Ladder ladder = ladder();
        assertThat(ladder.runAll(3).get(0)).isEqualTo(2);
        assertThat(ladder.runAll(3).get(1)).isEqualTo(0);
        assertThat(ladder.runAll(3).get(2)).isEqualTo(1);
    }

    private static GilbertLadder ladder() {
        return new GilbertLadder(
            List.of(
                new GilbertLine("|-| |"),
                new GilbertLine("| |-|")
            ),
            new Goals(List.of("꽝", "5000", "3000"))
        );
    }
}
