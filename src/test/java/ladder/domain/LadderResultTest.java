package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    void LadderResult_creation_test() {
        String names = "pobi,honux,crong,jk";
        String strHeight = "5";

        Participants participants = Participants.of(names);
        LadderGame ladderGame = LadderGame.of(names, strHeight);

        LadderResult result = ladderGame.play();
        int size = result.getAllNames().size();

        assertThat(participants.isLastParticipant(size)).isTrue();
    }
}