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
        while (true) {
            String personForResult = InputView.receivePersonForResult();
            if (personForResult.equals(ALL)) {
                OutputView.printLadderTotalResult(ladderExecutionResults);
                return;
            }
            OutputView.printLadderResult(ladderExecutionResults.getLadderResultByName(new Person(personForResult)));
        }
    }

    private static LadderExecutionResults getLadderExecutionResults(Participants participants, LadderGameManager ladderGameManager, LadderResults ladderResults) {
        Map<Person, LadderResult> ladderResult = new HashMap<>();
        participants.getPersons()
                .forEach(person -> {
                    int startTrackNumber = participants.getTrackNumberByPerson(person);
                    int finishTrackNumber = ladderGameManager.start(startTrackNumber);
                    ladderResult.put(person, ladderResults.getLadderResult(finishTrackNumber));
                });
        return new LadderExecutionResults(ladderResult);
    }

}
