package ladder;

import ladder.domain.creator.LadderCreator;
import ladder.domain.ladder.*;
import ladder.domain.participant.People;
import ladder.domain.participant.Person;
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

        LadderCreationInformation creationInformation = LadderCreationInformation.from(people, height);

        LadderCreator ladderCreator = LadderCreator.getInstance();
        Ladder ladder = ladderCreator.create(creationInformation, RandomLineGenerateStrategy.getInstance());

        RESULT_VIEW.printLadderStatus(people, ladder, results);

        LadderResultBoard ladderResultBoard = ladder.run(people, results);
        extracted(people, ladderResultBoard);
    }

    private static void extracted(People people, LadderResultBoard ladderResultBoard) {
        String command = INPUT_VIEW.inputResultPersonByClient();
        if (!command.equals("all")) {
            RESULT_VIEW.printResult(Person.of(command), ladderResultBoard);
            extracted(people, ladderResultBoard);
            return;
        }
        RESULT_VIEW.printResultAll(people, ladderResultBoard);
    }


}
