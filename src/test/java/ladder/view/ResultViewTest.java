package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.Players;
import ladder.strategy.RandomLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ResultViewTest {

    @Test
    @DisplayName("사다리 출력 그림 보기 위해 작성")
    void printResult() {
        Players players = new Players(Arrays.asList("pobi", "honux", "crong", "jk", "Q"));
        Ladder ladder = Ladder.createLadder(new RandomLine(), players, new LadderHeight(5));
        ExecutionResults results = new ExecutionResults(Arrays.asList("꽝", "2000", "10000", "꽝", "1000"));
        ResultView.printLadderResult(players.getPlayers(), ladder.getLines(), results.getResults());
    }

}