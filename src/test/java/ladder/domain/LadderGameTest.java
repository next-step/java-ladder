package ladder.domain;

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

        int expectedSize = ladderGame.getParticipants().getSize();
        assertThat(names.split(",").length).isEqualTo(expectedSize);
    }
}
