package nextstep.domain.ladder;

import nextstep.domain.person.Person;

import java.util.Map;

public class LadderExecutionResults {

    private final Map<Person, LadderResult> ladderResult;

    public LadderExecutionResults(Map<Person, LadderResult> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public Map<Person, LadderResult> getLadderExecutionResult() {
        return ladderResult;
    }

    public LadderResult getLadderResultByName(Person person) {
        return ladderResult.get(person);
    }

}
