package nextstep.ladders.domain;

public class ExecutionResult {

    private String result;

    private ExecutionResult(final String result) {
        this.result = result;
    }

    public static ExecutionResult valueOf(final String result) {
        return new ExecutionResult(result);
    }

    public String value() {
        return result;
    }
}
