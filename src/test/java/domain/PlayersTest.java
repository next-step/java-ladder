package domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    public void test_생성() {
        Players players = Players.generate("pobi, honux, crong, jk");
        assertThat(players.size())
                .isEqualTo(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_변경불가() {
        Players players = Players.generate("pobi, honux, crong, jk");
        players.getPlayers().remove(0);
    }
}
