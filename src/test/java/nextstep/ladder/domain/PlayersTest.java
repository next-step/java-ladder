package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    void 생성() {
        Players players = new Players("pobi,honux,crong,jk");

        Assertions.assertThat(players.getPlayers()).hasSize(4);
    }
}
