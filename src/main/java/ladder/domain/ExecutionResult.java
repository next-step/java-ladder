package ladder.domain;

public class ExecutionResult {
    private final User user;
    private final String result;

    public ExecutionResult(User user, String result) {
        this.user = user;
        this.result = result;
    }

    public String userName() {
        return user.getName();
    }

    public String name() {
        return result;
    }
}
