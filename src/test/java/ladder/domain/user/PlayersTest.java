package ladder.domain.user;

import ladder.domain.user.Player;
import ladder.domain.user.PlayerName;
import ladder.domain.user.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    @DisplayName("선수들 생성")
    void create() {
        Players players = new Players(Arrays.asList(new Player(new PlayerName("son")), new Player(new PlayerName("dyer"))));
        assertThat(players).isEqualTo(new Players(Arrays.asList(new Player(new PlayerName("son")), new Player(new PlayerName("dyer")))));
        assertThat(players.getPlayers()).size().isEqualTo(2);
    }

}
