package nextstep.domain.ladder;

import nextstep.domain.person.Person;

import java.util.Collections;
import java.util.Map;

public class LadderExecutionResults {

    private final Map<Person, LadderResult> ladderResult;

    public LadderExecutionResults(Map<Person, LadderResult> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public Map<Person, LadderResult> getLadderExecutionResult() {
        return Collections.unmodifiableMap(ladderResult);
    }

    public LadderResult getLadderResultByName(String name) {
        return ladderResult.get(new Person(name));
    }

}
