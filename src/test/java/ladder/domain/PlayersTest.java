package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    void create() {
        List<String> names = Arrays.asList("aa", "bb", "cc");
        Players players = new Players(names);
        assertThat(players).isEqualTo(new Players(names));
    }

    @Test
    void playerIndex() {
        List<String> names = Arrays.asList("aa", "bb", "cc");
        Players players = new Players(names);
        assertThat(players.index(new Player("bb"))).isEqualTo(1);
    }

    @Test
    void playerIndex_error() {
        List<String> names = Arrays.asList("aa", "bb", "cc");
        Players players = new Players(names);
        assertThatThrownBy(() -> players.index(new Player("dd")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}