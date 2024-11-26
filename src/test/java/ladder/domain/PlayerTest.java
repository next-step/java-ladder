package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    @DisplayName("플레이어를 생성한다")
    void create() {
        Player player = new Player("pobi");
        Player expected = new Player(new PlayerName("pobi"), new Position());

        assertThat(player).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름을 출력한다")
    void name() {
        Player player = new Player("pobi");
        PlayerName name = player.name();
        PlayerName expected = new PlayerName("pobi");

        assertThat(name).isEqualTo(expected);
    }

    @Test
    @DisplayName("포지션을 출력한다")
    void postion() {
        Player player = new Player(new PlayerName("pobi"), new Position(2, 3));
        Position name = player.position();
        Position expected = new Position(2, 3);

        assertThat(name).isEqualTo(expected);
    }
}
