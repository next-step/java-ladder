package ladderGame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    public void create() {

        List<Player> source = Arrays.asList(
                Player.of("hello", 0),
                Player.of("world", 1),
                Player.of("nice", 2)
        );

        Players players = Players.of(source);
        assertThat(players.size()).isEqualTo(3);
    }
}