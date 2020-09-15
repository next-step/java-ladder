package ladder.legacy.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void LadderGame_creation_test() {
        String names = "pobi,honux,crong,jk";
        String strHeight = "5";

        Height height = Height.of(strHeight);
        LadderGame ladderGame = LadderGame.of(names, strHeight);

        int expectedHeight = ladderGame.getLadder().getLines().size();
        assertThat(height.equals(expectedHeight)).isTrue();

        int length = names.split(",").length;
        Participants participants = ladderGame.getParticipants();
        assertThat(participants.isLastParticipant(length)).isTrue();
    }

    @Test
    void LadderGame_play_test() {
        String names = "pobi,honux,crong,jk";
        String strHeight = "5";

        Participants participants = Participants.of(names);
        LadderGame ladderGame = LadderGame.of(names, strHeight);

        LadderResult result = ladderGame.play();
        int size = result.getAllNames().size();

        assertThat(participants.isLastParticipant(size)).isTrue();
    }
}
