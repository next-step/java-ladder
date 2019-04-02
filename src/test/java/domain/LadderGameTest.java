package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void 사용자와_사다리를_세팅한다() {
        LadderGame game = new LadderGame(Arrays.asList("user1", "user2", "user3"), 5);
        assertThat(game.getUsers()).hasSize(3);
        assertThat(game.getLadder().getLines()).hasSize(5);
    }
}
