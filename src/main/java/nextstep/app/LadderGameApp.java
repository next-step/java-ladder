package nextstep.app;

import nextstep.domain.*;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameApp {

    public static void main(String[] args) {
        Participants participants = new Participants(getPersons());
        LadderResults ladderResults = new LadderResults(getLadderResults());
        LadderHeight ladderHeight = new LadderHeight(getLadderHeight());
        LadderGameManager ladderGameManager = new LadderGameManager(getLines(participants, ladderHeight));
        OutputView.printLadder(participants, ladderGameManager, ladderResults);
        String personForResult = InputView.receivePersonForResult();
        if (personForResult.equals("all")) {
            LadderResults ladderTotalResults = getLadderTotalResults(participants, ladderResults, ladderGameManager);
            OutputView.printLadderTotalResult(participants, ladderTotalResults);
            return;
        }
        LadderResult ladderResult = getLadderResult(participants, ladderResults, ladderGameManager, personForResult);
        OutputView.printLadderResult(ladderResult);
    }

    private static List<Person> getPersons() {
        return PersonFactory.createPersons(InputView.receivePersons());
    }

    private static List<LadderResult> getLadderResults() {
        return LadderResultFactory.createLadderResults(InputView.receiveLadderResults());
    }

    private static int getLadderHeight() {
        return InputView.receiveLadderHeight();
    }

    private static List<Line> getLines(Participants participants, LadderHeight ladderHeight) {
        return LineFactory.createLines(participants, ladderHeight);
    }

    private static LadderResult getLadderResult(Participants participants, LadderResults ladderResults, LadderGameManager ladderGameManager, String personForResult) {
        int startTrackNumber = participants.getTrackNumberByPersonName(personForResult);
        int finishTrackNumber = ladderGameManager.start(startTrackNumber);
        return ladderResults.getLadderResult(finishTrackNumber);
    }

    private static LadderResults getLadderTotalResults(Participants participants, LadderResults ladderResults, LadderGameManager ladderGameManager) {
        return new LadderResults(participants.getPersons()
                .stream()
                .map(person -> getLadderResult(participants, ladderResults, ladderGameManager, person.getName()))
                .collect(Collectors.toList()));
    }

}
