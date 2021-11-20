package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.doamin.value.Location;
import nextstep.ladder.doamin.value.Person;
import nextstep.ladder.utils.Preconditions;

import java.util.List;

public class LadderResult {
    private final Ladder ladder;
    private final LadderMapper ladderMapper;

    private LadderResult(List<Person> people, Ladder ladder, List<String> executionResult) {
        Preconditions.checkNotNull(people, "people은 필수값입니다.");
        Preconditions.checkNotNull(ladder, "ladder는 필수값입니다.");
        Preconditions.checkNotNull(executionResult, "executionResult는 필수값입니다.");

        this.ladder = ladder;
        this.ladderMapper = LadderMapper.of(People.from(people), ExecutionResult.from(executionResult));
    }

    public static LadderResult of(List<Person> people, Ladder ladder, List<String> executionResult) {
        return new LadderResult(people, ladder, executionResult);
    }

    public String getLadderResult(Person personName) {
        Location startLocation = ladderMapper.getStartLocation(personName);
        Location lastLocation = ladder.getLadderResult(startLocation);
        return ladderMapper.getLadderResult(lastLocation);
    }

    @GetterForUI
    public Ladder getLadder() {
        return ladder;
    }


    @GetterForUI
    public People getPeople() {
        return ladderMapper.getPeople();
    }

    @GetterForUI
    public ExecutionResult getExecutionResult() {
        return ladderMapper.getExecutionResult();
    }
}
