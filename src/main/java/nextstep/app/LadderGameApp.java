package nextstep.app;

import nextstep.domain.ladder.*;
import nextstep.domain.person.Participants;
import nextstep.domain.person.Person;
import nextstep.domain.person.PersonFactory;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.HashMap;
import java.util.Map;

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
        while (!ALL.equals(personForResult)) {
            OutputView.printLadderResult(ladderExecutionResults.getLadderResultByName(personForResult));
            personForResult = InputView.receivePersonForResult();
        }
        OutputView.printLadderTotalResult(ladderExecutionResults);
    }

    private static LadderExecutionResults getLadderExecutionResults(Participants participants, LadderGameManager ladderGameManager, LadderResults ladderResults) {
        Map<Person, LadderResult> ladderResult = new HashMap<>();
        participants.getPersons().stream()
                .map(person -> person.finish(ladderGameManager.start(person.getTrackNumber())))
                .forEach(person -> ladderResult.put(person, ladderResults.getLadderResult(person.getTrackNumber())));
        return new LadderExecutionResults(ladderResult);
    }

}
