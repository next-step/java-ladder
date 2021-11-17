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
        Preconditions.checkNotNull(people, "ladder는 필수값입니다.");
        Preconditions.checkNotNull(people, "executionResult는 필수값입니다.");

        this.people = people;
        this.ladder = ladder;
        this.executionResult = executionResult;
    }

    public static LadderResult of(People people, Ladder ladder, ExecutionResult executionResult) {
        return new LadderResult(people, ladder, executionResult);
    }

    public String getLadderResult(Person personName) {
        Location startLocation = people.getLocation(personName);
        Location lastLocation = ladder.getLadderResult(startLocation);
        return executionResult.getExecutionResult(lastLocation);
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
