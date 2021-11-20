package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.utils.Preconditions;

public class LadderMapper {
    private final People people;
    private final ExecutionResult executionResult;

    private LadderMapper(People people, ExecutionResult executionResult) {
        Preconditions.checkNotNull(people, "people은 필수값입니다.");
        Preconditions.checkNotNull(executionResult, "executionResult는 필수값입니다.");

        this.people = people;
        this.executionResult = executionResult;
    }

    public static LadderMapper of(People people, ExecutionResult executionResult) {
        return new LadderMapper(people, executionResult);
    }

    public Location getStartLocation(Person personName) {
        Preconditions.checkState(isCorrectName(personName), "입력한 사람의 이름이 잘못되었습니다.");

        return people.getLocation(personName);
    }

    public String getLadderResult(Location lastLocation) {
        return executionResult.getExecutionResult(lastLocation);
    }

    private boolean isCorrectName(Person personName) {
        return people.isCorrectName(personName);
    }

    @GetterForUI
    public People getPeople() {
        return people;
    }

    @GetterForUI
    public ExecutionResult getExecutionResult() {
        return executionResult;
    }
}
