package ladder;

import ladder.domain.Player;
import ladder.domain.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    private static String INPUT_USER_NAME = "user";
    private static String INPUT_USER_NAME_FOR_FIVE = "user1";
    private Players players;

    @BeforeEach
    void setUp() {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player(INPUT_USER_NAME));
        playerList.add(new Player(INPUT_USER_NAME_FOR_FIVE));
        players = new Players(playerList);
    }

    @Test
    void max_name_length() {
        assertThat(players.getMaxNameLength()).isEqualTo(INPUT_USER_NAME_FOR_FIVE.length());
    }
}
