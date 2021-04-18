package ladder;

import ladder.domain.Players;
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

    @DisplayName("참가자의 인덱스를 반환한다.")
    @Test
    void index() {
        Players players = Players.of(Arrays.asList("test1", "test2", "test3"));
        assertThat(players.index("test1")).isEqualTo(0);
    }
}
