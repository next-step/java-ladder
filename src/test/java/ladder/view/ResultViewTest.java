package ladder.view;

import ladder.config.LadderConfig;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.LadderPlayers;
import ladder.generator.LadderGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ResultViewTest {

    private Ladder ladder;

    @BeforeEach
    void init() {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong"));
        LadderHeight height = new LadderHeight(3);
        LadderConfig config = new LadderConfig();
        LadderGenerator generator = config.ladderGenerator(players, height);
        ladder = generator.generate();
    }

    @Test
    @DisplayName("사다리 출력 그림 보기 위해 작성")
    void printResult() {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong", "jk"));
//        Ladder ladder = Ladder.createLadder(new RandomLine(), new DefaultLadderGenerator(players, new LadderHeight(4)));
        ExecutionResults items = new ExecutionResults(Arrays.asList("꽝", "2000", "10000", "꽝"));
        ResultView.printLadderResult(players.getPlayers(), ladder.getLines());
        ResultView.printItems(items);
    }

}