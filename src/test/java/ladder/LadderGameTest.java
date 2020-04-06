package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void joinUsersReturnsLadderWidth() {
        LadderGame ladderGame = new LadderGame();
        int ladderWidth = ladderGame.joinUsers(Arrays.asList("pobi", "honux", "crong", "jk"));

        assertThat(ladderWidth).isEqualTo(4);
    }
}
