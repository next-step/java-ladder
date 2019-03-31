package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void 사용자와_사다리를_세팅한다() {
        LadderGame game = new LadderGame(Arrays.asList("user1", "user2", "user3"), 5, new RandomNumberPointLottery());
        assertThat(game.getUsers()).hasSize(3);
        assertThat(game.getLadder().getWidth()).isEqualTo(3);
        assertThat(game.getLadder().getHeight()).isEqualTo(5);
    }

    @Test
    public void 가장_긴_이름의_유저를_찾는다() {
        LadderGame game = new LadderGame(Arrays.asList("useruser1", "user2", "user3"), 5, new RandomNumberPointLottery());
        assertThat(game.longestUserNameLength()).isEqualTo(9);
    }
}
