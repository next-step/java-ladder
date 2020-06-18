package ladder;

import ladder.domain.Player;
import ladder.domain.PlayerLogs;
import ladder.domain.Players;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerLogTest {

    @DisplayName("사다리 유저 로그 생성 테스")
    @Test
    void getPlayerLogTest() {
        String players = "iu,iu2,iu3,iu4";
        PlayerLogs playerLogs = new PlayerLogs(new Players(players).getPlayerLogs());
        assertThat(playerLogs.getPlayerLogsSize()).isEqualTo(4);
    }

    @DisplayName("로그 유저 포지션 매칭 테스")
    @Test
    void getPlayerByPositionTest() {
        String players = "iu,iu2,iu3,iu4";
        PlayerLogs playerLogs = new PlayerLogs(new Players(players).getPlayerLogs());
        assertThat(playerLogs.getPlayerByPosition(new Position(0))).isEqualTo(new Player("iu", 0));
    }


}
