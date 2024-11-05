package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    void create() {
        Players actual = new Players("pobi,crong,honux,jk");
        Players expected = new Players(List.of(
                        new Player("pobi"),
                        new Player("crong"),
                        new Player("honux"),
                        new Player("jk")));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void size() {
        Players players = new Players("pobi,crong,honux,jk");
        int actual = players.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    void names() {
        Players players = new Players("pobi,crong,honux,jk");
        List<Name> actual = players.names();
        List<Name> expected = List.of(
                new Name("pobi"),
                new Name("crong"),
                new Name("honux"),
                new Name("jk")
        );

        assertThat(actual).isEqualTo(expected);
    }
}
