package ladder2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder2.domain.player.NxPlayer;
import nextstep.ladder2.domain.player.NxPlayers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NxPlayersTest {
    @Test
    @DisplayName("플레이어 이름을 담고, 이름을 출력한다.")
    void createPlayersAndPrintPlayerNames() {
        NxPlayers players = new NxPlayers(Arrays.asList("pobi", "honux", "crong", "jk"));

        List<String> expectedNames = players.getAllPlayerNames();

        assertThat(Arrays.asList("pobi", "honux", "crong", "jk")).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("플레이어 목록에서 이름으로 플레이어를 찾을 수 있다.")
    void findPlayerTestByName() {
        NxPlayers players = new NxPlayers(Arrays.asList("pobi", "honux", "crong", "jk"));

        assertThat(players.findPlayerByName("pobi")).isEqualTo(new NxPlayer("pobi"));
    }

    @Test
    @DisplayName("참가한 플레이어의 인원 수를 표기할 수 있다.")
    void playersCountTest() {
        NxPlayers players = new NxPlayers(Arrays.asList("pobi", "honux", "crong", "jk"));

        assertThat(players.getPlayerCount()).isEqualTo(4);
    }
}
