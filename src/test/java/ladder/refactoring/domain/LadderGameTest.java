package ladder.refactoring.domain;

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
        assertThat(height.getValue()).isEqualTo(expectedHeight);

        int length = names.split(",").length;
        Participants participants = ladderGame.getParticipants();
        assertThat(participants.size()).isEqualTo(length);
    }

    @Test
    void LadderGame_play_test() {
        String names = "pobi,honux,crong,jk";
        String strHeight = "5";

        Participants participants = Participants.of(names);
        LadderGame ladderGame = LadderGame.of(names, strHeight);

        LadderResult result = ladderGame.play();
        int size = result.getAllParticipants().size();

        assertThat(participants.size()).isEqualTo(size);
    }
}
