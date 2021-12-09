package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static domain.LadderTest.LADDER;
import static domain.ParticipantsTest.PARTICIPANTS;

public class LadderGameTest {
    private static final LadderResult LADDER_RESULT = new LadderResult(Arrays.asList("bomb", "3000", "5000"));

    @Test
    void testResult() {
        LadderGame ladderGame = new LadderGame(PARTICIPANTS, LADDER);

        assertThat(ladderGame.result("pobi", LADDER_RESULT)).isEqualTo("5000");
        assertThat(ladderGame.result("honux", LADDER_RESULT)).isEqualTo("3000");
        assertThat(ladderGame.result("crong", LADDER_RESULT)).isEqualTo("bomb");
    }
}
