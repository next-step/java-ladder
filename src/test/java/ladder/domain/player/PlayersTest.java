package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("Players 생성 테스트")
    @Test
    void createPlayersTest() {
        Players players = Players.ofNames("pobi,honux,crong,jk");
        assertThat(players.getPlayers()).containsExactly(
                Player.of("pobi"),
                Player.of("honux"),
                Player.of("crong"),
                Player.of("jk"));

        assertThat(players.size()).isEqualTo(4);
    }
}