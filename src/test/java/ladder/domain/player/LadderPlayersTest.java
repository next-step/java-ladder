package ladder.domain.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderPlayersTest {

    @Test
    void LadderPlayers_생성_test() {
        String[] playerNames = {"pobi","honux"};

        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        assertThat(ladderPlayers.getPlayerCount()).isEqualTo(2);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void LadderPlayers_값없음_test(String[] playerNames) {
        assertThatThrownBy(() -> LadderPlayers.participate(playerNames))
                .hasMessageMatching("플에이어를 입력하세요");
    }
}
