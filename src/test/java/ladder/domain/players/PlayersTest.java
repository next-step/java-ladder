package ladder.domain.players;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {

    @Test
    public void 플레이어_1명_생성() {
        Players players = Players.generate("njkim");

        assertThat(players.size()).isEqualTo(1);
    }

    @Test
    public void 플레이어_3명_생성() {
        Players players = Players.generate("a,b,c");

        assertThat(players.size()).isEqualTo(3);

    }

    @Test
    public void 플레이어_생성시_trim() {
        Players players = Players.generate("a , b , c");

        assertThat(players.size()).isEqualTo(3);
    }
}
