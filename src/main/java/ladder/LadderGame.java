package ladder;

import ladder.domain.ladder.*;
import ladder.domain.participant.People;
import ladder.domain.participant.Person;
import ladder.exception.NoSuchPersonException;
import ladder.exception.PeopleAndResultsSizeMissMatchException;
import ladder.strategy.RandomLineGenerateStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public final class LadderGame {

    private static final String ALL_COMMAND = "all";

    private static final InputView INPUT_VIEW;
    private static final ResultView RESULT_VIEW;

    static {
        INPUT_VIEW = InputView.getInstance();
        RESULT_VIEW = ResultView.getInstance();
    }

    public static final void main(String[] args) {
        People people = getInputParticipants();
        LadderResults results = getInputLadderResults(people);
        LadderHeight height = getInputLadderHeight();

        Ladder ladder = Ladder.from(people, height, RandomLineGenerateStrategy.getInstance());

        RESULT_VIEW.printLadderStatus(people, ladder, results);

        LadderResultBoard ladderResultBoard = ladder.run(people, results);
        printLadderResultBoard(people, ladderResultBoard);
    }

    private static final People getInputParticipants() {
        try {
            return People.of(INPUT_VIEW.inputParticipantsByClient());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInputParticipants();
        }
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


    private static final LadderHeight getInputLadderHeight() {
        try {
            return LadderHeight.valueOf(INPUT_VIEW.inputLadderHeightByClient());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInputLadderHeight();
        }
    }

    private static final void printLadderResultBoard(People people, LadderResultBoard ladderResultBoard) {
        String command = getCommand(people);
        if (isNotCommandAll(command)) {
            RESULT_VIEW.printLadderGameResult(Person.of(command), ladderResultBoard);
            printLadderResultBoard(people, ladderResultBoard);
            return;
        }
        RESULT_VIEW.printLadderGameResultAll(people, ladderResultBoard);
    }

    private static final boolean isNotCommandAll(String command) {
        return (!command.equals(ALL_COMMAND));
    }

    private static final String getCommand(People people) {
        try {
            List<String> names = people.values();
            String command = INPUT_VIEW.inputResultPersonByClient();
            validateAvailableName(names, command);
            return command;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCommand(people);
        }
    }

    private static final String validateAvailableName(List<String> names, String command) {
        return names.stream()
                .filter(name -> name.equals(command))
                .findFirst()
                .orElseThrow(() -> new NoSuchPersonException());
    }
}
