package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    public static final Players PLAYERS1 = new Players("pobi,crong,honux,jk");

    private Players players;
    private Name playerName1;
    private Name playerName2;
    private Name playerName3;
    private Name playerName4;

    @BeforeEach
    void setUp() {
        playerName1 = new Name("pobi");
        playerName2 = new Name("crong");
        playerName3 = new Name("honux");
        playerName4 = new Name("jk");
        players = new Players("pobi,crong,honux,jk");
    }

    @Test
    @DisplayName("플레이어 목록을 생성한다")
    void create() {
        Players expected = new Players(List.of(playerName1, playerName2, playerName3, playerName4));

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