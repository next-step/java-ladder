package nextstep.ladder.domain;

import nextstep.ladder.domain.player.Players;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    void create() {
        Players players = new Players(List.of(PlayerTest.PLAYER1, PlayerTest.PLAYER2));

        assertThat(players).isNotNull();
        assertThat(players.playerCount()).isEqualTo(2);
    }
}
