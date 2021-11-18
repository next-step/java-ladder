package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.utils.Preconditions;

public class LadderResult {
    private final People people;
    private final Ladder ladder;
    private final ExecutionResult executionResult;

    private LadderResult(People people, Ladder ladder, ExecutionResult executionResult) {
        Preconditions.checkNotNull(people, "people은 필수값입니다.");
        Preconditions.checkNotNull(ladder, "ladder는 필수값입니다.");
        Preconditions.checkNotNull(executionResult, "executionResult는 필수값입니다.");

        this.people = people;
        this.ladder = ladder;
        this.executionResult = executionResult;
    }

    public static LadderResult of(People people, Ladder ladder, ExecutionResult executionResult) {
        return new LadderResult(people, ladder, executionResult);
    }

    public String getLadderResult(Person personName) {
        Preconditions.checkState(isCorrectName(personName), "입력한 사람의 이름이 잘못되었습니다.");

        Location startLocation = people.getLocation(personName);
        Location lastLocation = ladder.getLadderResult(startLocation);
        return executionResult.getExecutionResult(lastLocation);
    }

    public boolean isCorrectName(Person personName) {
        return people.isCorrectName(personName);
    }

    @GetterForUI
    public People getPeople() {
        return people;
    }

    @GetterForUI
    public Ladder getLadder() {
        return ladder;
    }

    @GetterForUI
    public ExecutionResult getExecutionResult() {
        return executionResult;
    }
}
