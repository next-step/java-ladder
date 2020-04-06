package ladder.domain.player;

import ladder.model.player.Player;
import ladder.model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @DisplayName("Players 객체 생성")
    @Test
    void createTest() {
        //given
        List<Player> allPlayers = Arrays.asList(
                new Player("Mark"),
                new Player("Palm"),
                new Player("Jyung")
        );

        //when
        Players players = Players.create(allPlayers);

        //then
        assertThat(players.getPlayerCount()).isEqualTo(3);
    }
}
