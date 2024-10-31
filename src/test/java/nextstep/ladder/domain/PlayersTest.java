package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @DisplayName("참가자 이름을 쉼표(,) 기준으로 구분")
    @Test
    void 참가자_이름_구분() {
        Players players = new Players("pobi,honux,crong,jk");
        assertThat(players.getPlayers()).hasSize(4);
    }
}
