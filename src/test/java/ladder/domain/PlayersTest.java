package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    public static final Players PLAYERS1 = new Players("pobi,crong,honux,jk");

    private Players players;

    @BeforeEach
    void setUp() {
        players = new Players("pobi,crong,honux,jk");
    }

    @Test
    void create() {
        Players expected = new Players(List.of(
                        new Player("pobi"),
                        new Player("crong"),
                        new Player("honux"),
                        new Player("jk")));

        assertThat(players).isEqualTo(expected);
    }

    @Test
    void size() {
        int actual = players.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    void names() {
        List<Name> actual = players.names();
        List<Name> expected = List.of(
                new Name("pobi"),
                new Name("crong"),
                new Name("honux"),
                new Name("jk")
        );

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    void namesMaxLength() {
        int actual = players.namesMaxLength();

        assertThat(actual).isEqualTo(5);
    }

}
