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
}
