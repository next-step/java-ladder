package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {
    @Test
    void createPlayers1() {
        assertThat(new Players(new String[]{"a","b","c","d"}).size()).isEqualTo(4);
    }

    @Test
    void createPlayers2() {
        assertThat(new Players(new String[]{"a","b","c","d"})).
                isEqualTo(new Players(List.of(
                new Player("a"),
                new Player("b"),
                new Player("c"),
                new Player("d"))));
    }
}
