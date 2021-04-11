package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @DisplayName("참가자들을 인자로 받아 인스턴스를 생성한다.")
    @Test
    void create() {
        Players players = Players.of(Arrays.asList("test1", "test2", "test3"));
        assertThat(players).isEqualTo(Players.of(Arrays.asList("test1", "test2", "test3")));
    }

    @DisplayName("위치정보를 반환한다.")
    @Test
    void position() {
        Players players = Players.of(Arrays.asList("test1", "test2", "test3", "test4"));
        assertThat(players.playerPosition(new Player("test1"))).isEqualTo(Position.FIRST);
        assertThat(players.playerPosition(new Player("test2"))).isEqualTo(Position.BODY);
        assertThat(players.playerPosition(new Player("test4"))).isEqualTo(Position.LAST);
    }
}
