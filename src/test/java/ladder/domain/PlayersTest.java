package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("플레이어 목록을 생성한다")
    void create() {
        Players expected = new Players(List.of(
                        new Name("pobi"),
                        new Name("crong"),
                        new Name("honux"),
                        new Name("jk")));

        assertThat(players).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 목록의 size 를 출력한다")
    void size() {
        int actual = players.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("플레이어 목록의 이름을 출력한다")
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
}
