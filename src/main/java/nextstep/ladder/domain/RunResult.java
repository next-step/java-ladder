package nextstep.ladder.domain;

public class RunResult {
    private final String runResult;

    public RunResult(String runResult) {
        this.runResult = runResult;
    }

    @Override
    public String toString() {
        return this.runResult;
    }
}
