package ladder.domain.ladder;

import ladder.domain.player.Player;
import ladder.domain.player.PlayerGroup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @Test
    @DisplayName("사다리타기 게임을 올바르게 수행하고 결과가 잘 이루어진다")
    void gameStart_Process_ResultIn() {
        PlayerGroup playerGroup = new PlayerGroup("june1,june2,jun3");
        LadderHeight ladderHeight = new LadderHeight(2);
        Ladder ladder = new Ladder(ladderHeight, playerGroup.size());
        LadderGame ladderGame = new LadderGame(ladder, playerGroup);

        ladderGame.start();

        LadderResult ladderResult = ladderGame.getLadderResult();
        Assertions.assertThat(ladderResult.get(new Player("june1"))).isEqualTo(0);
        Assertions.assertThat(ladderResult.get(new Player("june2"))).isEqualTo(1);
        Assertions.assertThat(ladderResult.get(new Player("june3"))).isEqualTo(2);
    }
}
