package nextstep.refactor_ladder.service;

import nextstep.refactor_ladder.domain.ExecutionResults;
import nextstep.refactor_ladder.domain.Ladder;
import nextstep.refactor_ladder.domain.LadderResults;
import nextstep.refactor_ladder.domain.People;
import nextstep.refactor_ladder.domain.value.ExecutionResult;
import nextstep.refactor_ladder.domain.value.Person;

import java.util.HashMap;
import java.util.Map;

public class LadderService {
    public LadderResults getLadderResults(People people, Ladder ladder, ExecutionResults executionResults) {
        Map<Person, ExecutionResult> ladderResult = new HashMap<>();

        people.getPersonList().forEach(person -> {
            int firstIndex = people.getPersonIndex(person);
            int lastIndex = ladder.move(firstIndex);
            ladderResult.put(person, executionResults.getResult(lastIndex));
        });
        return LadderResults.from(ladderResult);
    }
}
