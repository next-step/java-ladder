package ladder;

import ladder.model.Player;
import ladder.model.Players;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
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
