package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    void sizeReturn5() {
        assertThat(
                new Players(Stream.iterate(0, i -> i + 1)
                        .map(i -> new Player(i + ""))
                        .limit(5)
                        .collect(Collectors.toList()))
                        .size()
        ).isEqualTo(5);
    }

    @Test
    void findPlayers() {
        Players players = new Players(Arrays.asList(
                new Player("ab"),
                new Player("cd")
        ));
        Player.autoIncrement = 0;
        Players targetPlayers = new Players(Arrays.asList(
                new Player("ab")
        ));
        assertThat(players.findPlayers("ab")).isEqualTo(targetPlayers);
    }
}
