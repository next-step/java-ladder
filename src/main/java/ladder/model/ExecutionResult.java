package ladder.model;

public class ExecutionResult {

    private final String name;

    private ExecutionResult(String name) {
        this.name = name;
    }

    public static ExecutionResult create(String name) {
        return new ExecutionResult(name);
    }

}
