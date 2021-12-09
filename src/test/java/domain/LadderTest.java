package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static domain.FloorsTest.FLOORS;
import static domain.LadderLineTest.*;
import static domain.ParticipantsTest.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    public static final LadderResult LADDER_RESULT = new LadderResult(Arrays.asList("blank", "5000", "blank", "3000"));

    @Test
    void testFinalResult() {
        Ladder ladder = new Ladder(FLOORS, PARTICIPANTS);
        assertThat(ladder.finalResult(LADDER_RESULT, PARTICIPANT_ONE.getName())).isEqualTo("3000");
        assertThat(ladder.finalResult(LADDER_RESULT, PARTICIPANT_TWO.getName())).isEqualTo("5000");
        assertThat(ladder.finalResult(LADDER_RESULT, PARTICIPANT_THREE.getName())).isEqualTo("blank");
        assertThat(ladder.finalResult(LADDER_RESULT, PARTICIPANT_FOUR.getName())).isEqualTo("blank");
    }

    @Test
    void testFinalResultOfAll() {
        Ladder ladder = new Ladder(FLOORS, PARTICIPANTS);
        List<String> results = ladder.finalResultsOfAll(LADDER_RESULT);
        assertThat(results.get(0)).isEqualTo("3000");
        assertThat(results.get(1)).isEqualTo("5000");
        assertThat(results.get(2)).isEqualTo("blank");
        assertThat(results.get(3)).isEqualTo("blank");
    }

    @Test
    void testFinalPoint() {
        Ladder ladder = new Ladder(Arrays.asList(FIRST_LINE, SECOND_LINE, THIRD_LINE));

        assertThat(ladder.finalPoint(0)).isEqualTo(2);
        assertThat(ladder.finalPoint(1)).isEqualTo(1);
        assertThat(ladder.finalPoint(2)).isEqualTo(0);
    }
}
