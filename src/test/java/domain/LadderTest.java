package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static domain.FloorsTest.FLOORS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    public static final LadderResult LADDER_RESULT = new LadderResult(Arrays.asList("blank", "5000", "blank", "3000"));
    private static final int NUMBER_OF_PARTICIPANTS = 4;

    @Test
    void testFinalResult() {
        Ladder ladder = new Ladder(FLOORS, LADDER_RESULT);
        assertThat(ladder.finalResult(new Position(0))).isEqualTo("3000");
        assertThat(ladder.finalResult(new Position(1))).isEqualTo("5000");
        assertThat(ladder.finalResult(new Position(2))).isEqualTo("blank");
        assertThat(ladder.finalResult(new Position(3))).isEqualTo("blank");
    }

    @Test
    void testFinalResultOfAll() {
        Ladder ladder = new Ladder(FLOORS, LADDER_RESULT);
        List<String> results = ladder.finalResultsOfAll(NUMBER_OF_PARTICIPANTS);
        assertThat(results.get(0)).isEqualTo("3000");
        assertThat(results.get(1)).isEqualTo("5000");
        assertThat(results.get(2)).isEqualTo("blank");
        assertThat(results.get(3)).isEqualTo("blank");
    }
}
