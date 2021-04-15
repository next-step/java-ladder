package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.LadderResults;
import ladder.domain.People;
import ladder.strategy.RandomLineGenerateStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {

    private static final InputView INPUT_VIEW;
    private static final ResultView RESULT_VIEW;

    static {
        INPUT_VIEW = InputView.getInstance();
        RESULT_VIEW = ResultView.getInstance();
    }

    public static void main(String[] args) {
        People people = People.of(INPUT_VIEW.inputParticipantsByClient());
        LadderResults results = LadderResults.of(INPUT_VIEW.inputLadderResultsByClient());
        LadderHeight height = LadderHeight.valueOf(INPUT_VIEW.inputLadderHeightByClient());
        Ladder ladder = Ladder.from(people, height, RandomLineGenerateStrategy.getInstance());
        // 결과 = ladder.run();
        RESULT_VIEW.printLadderStatus(people, ladder);
    }
}
