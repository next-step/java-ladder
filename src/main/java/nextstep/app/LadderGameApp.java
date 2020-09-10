package nextstep.app;

import nextstep.domain.ladder.*;
import nextstep.domain.person.Participants;
import nextstep.domain.person.PersonFactory;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.stream.Collectors;

public class LadderGameApp {

    public static final String ALL = "all";

    public static void main(String[] args) {
        Participants participants = PersonFactory.createPersons(InputView.receivePersons());
        LadderResults ladderResults = LadderResultFactory.createLadderResults(InputView.receiveLadderResults());
        LadderHeight ladderHeight = new LadderHeight(InputView.receiveLadderHeight());
        LadderGameManager ladderGameManager = new LadderGameManager(participants.getPersonSize(), ladderHeight.getLadderHeight());
        OutputView.printLadder(participants, ladderGameManager, ladderResults);
        LadderExecutionResults ladderExecutionResults = getLadderExecutionResults(participants, ladderGameManager, ladderResults);
        String personForResult = InputView.receivePersonForResult();
        if (personForResult.equals(ALL)) {
            OutputView.printLadderTotalResult(ladderExecutionResults);
            return;
        }
        OutputView.printLadderResult(ladderExecutionResults.getLadderResultByName(personForResult));
    }

    private static LadderExecutionResults getLadderExecutionResults(Participants participants, LadderGameManager ladderGameManager, LadderResults ladderResults) {
        return new LadderExecutionResults(participants.getPersons()
                .stream()
                .map(person -> {
                    int startTrackNumber = participants.getTrackNumberByPerson(person);
                    int finishTrackNumber = ladderGameManager.start(startTrackNumber);
                    return new LadderExecutionResult(person, ladderResults.getLadderResult(finishTrackNumber));
                })
                .collect(Collectors.toList()));
    }

}
