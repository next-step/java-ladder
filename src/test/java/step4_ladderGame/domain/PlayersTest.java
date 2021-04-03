package step4_ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("입력 받은 이름 만큼 플레이어를 만든다.")
    @Test
    void testCase() {
        Players players = Players.of("LG,SKT,KT");

        assertThat(players.size()).isEqualTo(3);
        assertThat(players.getPlayer(0)).isEqualTo(Player.of("LG", 0));
    }

    
}