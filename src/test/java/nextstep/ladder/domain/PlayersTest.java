package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @DisplayName("해당 플레이어가 없는지 체크한다")
    @Test
    void containsPlayerTest() {
        Player panda = new Player("panda");
        Players players = Players.from(Arrays.asList("panda", "pobi", "crong"));
        assertThat(players.notIncludePlayer(panda)).isEqualTo(false);
    }

    @DisplayName("해당 플레이어의 위치를 반환한다")
    @Test
    void positionOfPlayerTest() {
        Player panda = new Player("panda");
        Players players = Players.from(Arrays.asList("pobi", "panda", "crong"));
        assertThat(players.position(panda)).isEqualTo(1);
    }
}
