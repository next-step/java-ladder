package ladder;

import ladder.domain.creator.LadderCreator;
import ladder.domain.ladder.*;
import ladder.domain.participant.People;
import ladder.domain.participant.Person;
import ladder.exception.PeopleAndResultsSizeMissMatchException;
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
        People people = getInputParticipants();
        LadderResults results = getInputLadderResults(people);
        LadderHeight height = getInputLadderHeight();

        LadderCreationInformation creationInformation = LadderCreationInformation.from(people, height);

        LadderCreator ladderCreator = LadderCreator.getInstance();
        Ladder ladder = ladderCreator.create(creationInformation, RandomLineGenerateStrategy.getInstance());

        RESULT_VIEW.printLadderStatus(people, ladder, results);

        LadderResultBoard ladderResultBoard = ladder.run(people, results);
        extracted(people, ladderResultBoard);
    }


    private static final LadderResults getInputLadderResults(People people) {
        try {
            String[] ladderResults = INPUT_VIEW.inputLadderResultsByClient();
            validateSize(people, ladderResults);
            return LadderResults.of(ladderResults);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInputLadderResults(people);
        }
    }

    private static final void validateSize(People people, String[] ladderResults) {
        if (ladderResults.length != people.countOfPerson()) {
            throw new PeopleAndResultsSizeMissMatchException();
        }
    }

    private static final People getInputParticipants() {
        try {
            return People.of(INPUT_VIEW.inputParticipantsByClient());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInputParticipants();
        }
    }

    private static final LadderHeight getInputLadderHeight() {
        try {
            return LadderHeight.valueOf(INPUT_VIEW.inputLadderHeightByClient());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInputLadderHeight();
        }
    }

    private static final void extracted(People people, LadderResultBoard ladderResultBoard) {
        String command = INPUT_VIEW.inputResultPersonByClient();
        if (!command.equals("all")) {
            RESULT_VIEW.printResult(Person.of(command), ladderResultBoard);
            extracted(people, ladderResultBoard);
            return;
        }
        RESULT_VIEW.printResultAll(people, ladderResultBoard);
    }


}
