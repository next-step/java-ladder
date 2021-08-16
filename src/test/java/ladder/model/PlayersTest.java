package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 참가자 컬렉션 테스트")
public class PlayersTest {

    @DisplayName("게임 참가자들은 주입받은 이름 목록대로 정상 생성되어야 한다.")
    @Test
    void createPlayersTest() {
        // given, when
        Players players = Players.of(Arrays.asList("pobi", "honux", "crong", "jk"));

        // when, then
        assertThat(players.getNames()).containsExactly("pobi", "honux", "crong", "jk");
    }
}
