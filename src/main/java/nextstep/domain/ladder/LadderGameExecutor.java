package nextstep.domain.ladder;

import nextstep.domain.person.Participants;
import nextstep.domain.person.Person;

import java.util.HashMap;
import java.util.Map;

public class LadderGameExecutor {

    private LadderGameExecutor() {

    }

    public static LadderExecutionResults getLadderExecutionResults(Participants participants, LadderGameManager ladderGameManager, LadderResults ladderResults) {
        Map<Person, LadderResult> ladderResult = new HashMap<>();
        participants.getPersons().stream()
                .map(person -> person.finish(ladderGameManager.start(person.getTrackNumber())))
                .forEach(person -> ladderResult.put(person, ladderResults.getLadderResult(person.getTrackNumber())));
        return new LadderExecutionResults(ladderResult);
    }

}
