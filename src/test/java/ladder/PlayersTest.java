package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    void create() {
        String input = "jin,jolly,wuga";
        Players players = new Players(input);

        assertThat(players.getPlayers().size()).isEqualTo(3);
    }
}
