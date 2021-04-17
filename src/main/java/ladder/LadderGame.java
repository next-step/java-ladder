package ladder;

import ladder.domain.*;
import ladder.strategy.RandomLineGenerateStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;
import java.util.Set;

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

        LadderCreationInformation creationInformation = LadderCreationInformation.from(people, height);
        Ladder ladder = Ladder.from(creationInformation, RandomLineGenerateStrategy.getInstance());
        RESULT_VIEW.printLadderStatus(people, ladder, results);

        LadderResultBoard ladderResultBoard = ladder.run(people, results);
    }


}
