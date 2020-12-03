package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    @DisplayName("다수의 플레이어 생성")
    void createPlayers() {
        Players players = Players.from("pobi,honux");

        List<Player> playerList = Arrays.asList(new Player("pobi"), new Player("honux"));
        Players expectedPlayers = new Players(playerList);
        assertThat(players).isEqualTo(expectedPlayers);
    }

    @Test
    @DisplayName("다음 플레이어와 교체")
    void swapWithNext() {
        Players players = new Players(Arrays.asList(new Player("a"), new Player("b"), new Player("c")));

        players.swapWithNext(0);

        Players playersExpected = new Players(Arrays.asList(new Player("b"), new Player("a"), new Player("c")));
        assertThat(players).isEqualTo(playersExpected);
    }
}
