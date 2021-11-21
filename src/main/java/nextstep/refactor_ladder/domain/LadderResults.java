package nextstep.refactor_ladder.domain;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.utils.Preconditions;
import nextstep.refactor_ladder.domain.value.ExecutionResult;
import nextstep.refactor_ladder.domain.value.Person;

import java.util.Map;

public class LadderResults {
    private final Map<Person, ExecutionResult> ladderResults;

    private LadderResults(Map<Person, ExecutionResult> ladderResults) {
        Preconditions.checkNotNull(ladderResults, "ladderResults는 필수값입니다.");
        Preconditions.checkEmpty(ladderResults.entrySet(), "ladderResults는 필수값입니다.");

        this.ladderResults = ladderResults;
    }

    public static LadderResults from(Map<Person, ExecutionResult> ladderResults) {
        return new LadderResults(ladderResults);
    }

    public ExecutionResult getLadderResult(Person person) {
        return ladderResults.get(person);
    }

    @GetterForUI
    public Map<Person, ExecutionResult> getLadderResults() {
        return ladderResults;
    }
}
