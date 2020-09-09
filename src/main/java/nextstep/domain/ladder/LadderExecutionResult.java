package nextstep.domain.ladder;

import nextstep.domain.person.Person;

public class LadderExecutionResult {

    private final Person person;
    private final LadderResult ladderResult;

    public LadderExecutionResult(Person person, LadderResult ladderResult) {
        this.person = person;
        this.ladderResult = ladderResult;
    }

    public String getName() {
        return person.getName();
    }

    public String getResult() {
        return ladderResult.getResult();
    }

}
