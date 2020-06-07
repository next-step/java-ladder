package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderPlayersTest {

    @Test
    void LadderPlayers_생성_test() {
        String[] playerNames = {"pobi","honux"};

        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        assertThat(ladderPlayers.getPlayerCount()).isEqualTo(2);
    }

    @Test
    void LadderPlayers_값없음_test() {
        String[] playerNames = null;
        assertThatThrownBy(() -> LadderPlayers.participate(playerNames))
                .hasMessageMatching("플에이어를 입력하세요");
    }
}
