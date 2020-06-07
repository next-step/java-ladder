package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPlayersTest {

    @Test
    void LadderPlayers_생성_test() {
        String[] playerNames = {"pobi","honux"};

        LadderPlayers ladderPlayers = LadderPlayers.participate(playerNames);
        assertThat(ladderPlayers.getPlayerCount()).isEqualTo(2);
    }

}
