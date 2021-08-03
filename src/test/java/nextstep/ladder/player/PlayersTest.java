package nextstep.ladder.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("플레이어 목록을 가지는 객체를 생성 한다.")
    @Test
    void create_players() {
        Players players = Players.of("pobi,honux,crong,jk");

        assertThat(players.getPlayers()).hasSize(4);
    }
}