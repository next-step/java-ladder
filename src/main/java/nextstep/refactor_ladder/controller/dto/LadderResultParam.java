package nextstep.refactor_ladder.controller.dto;

import nextstep.refactor_ladder.domain.ExecutionResults;
import nextstep.refactor_ladder.domain.Ladder;
import nextstep.refactor_ladder.domain.People;
import nextstep.refactor_ladder.domain.value.ExecutionResult;
import nextstep.refactor_ladder.domain.value.Person;

import java.util.List;

public class LadderResultParam {
    private final People people;
    private final Ladder ladder;
    private final ExecutionResults executionResults;

    private LadderResultParam(List<Person> people, Ladder ladder, List<ExecutionResult> executionResults) {
        this.people = People.from(people);
        this.ladder = ladder;
        this.executionResults = ExecutionResults.from(executionResults);
    }

    public static LadderResultParam of(List<Person> people, Ladder ladder, List<ExecutionResult> executionResults) {
        return new LadderResultParam(people, ladder, executionResults);
    }

    public People getPeople() {
        return people;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public ExecutionResults getExecutionResults() {
        return executionResults;
    }
}
