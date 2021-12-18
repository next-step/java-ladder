package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderComponentDto;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;
import ladder.strategy.RandomLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ResultViewTest {

    @Test
    @DisplayName("사다리 출력 그림 보기 위해 작성")
    void printResult() {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong", "jk"));
        Ladder ladder = Ladder.createLadder(new RandomLine(), new LadderComponentDto(players, new LadderHeight(4)));
        ExecutionResults items = new ExecutionResults(Arrays.asList("꽝", "2000", "10000", "꽝"));
        ResultView.printLadderResult(players.getPlayers(), ladder.getLines());
        ResultView.printItems(items);
    }

}