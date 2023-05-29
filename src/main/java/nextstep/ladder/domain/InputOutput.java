package nextstep.ladder.domain;

public class InputOutput {

    private final People people;
    private final ExecuteResults executeResults;

    public InputOutput(People people, ExecuteResults executeResults) {
        if (people.value().size() != executeResults.value().size()) {
            throw new IllegalArgumentException("참여할 사람 수와 실행 결과 수는 일치해야 합니다.");
        }
        this.people = people;
        this.executeResults = executeResults;
    }

    public People people() {
        return people;
    }

    public ExecuteResults executeResults() {
        return executeResults;
    }
}
