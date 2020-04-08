package ladder.controller;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName("사다리 게임의 결과를 반환한다.")
    @Test
    void result() {
        Players players = new Players("pobi,crong,honux,ohtae");
        Ladder ladder = new Ladder(players.count(), Height.of("1"));
        Prizes prizes = new Prizes("꽝,5000,꽝,3000", players.count());

        Result result = LadderGame.run(players, ladder, prizes);

        assertThat(result).isNotNull();
        assertThat(result.getResult()).hasSize(4);
    }
}