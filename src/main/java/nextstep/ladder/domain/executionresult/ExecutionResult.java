package nextstep.ladder.domain.executionresult;

public class ExecutionResult {
    private final String result;

    public ExecutionResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }
}
