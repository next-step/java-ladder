package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void generateLadderWhenCreateLadderGame() {
        LadderGame ladderGame = new LadderGame(
                Arrays.asList("pobi", "crong", "honux", "jk"),
                5
        );

        assertThat(ladderGame.getLadder()).hasSize(5);
    }
}
