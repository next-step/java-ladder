package nextstep.ladder;

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
}
