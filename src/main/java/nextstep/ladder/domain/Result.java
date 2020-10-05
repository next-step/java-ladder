package nextstep.ladder.domain;

public class Result {
    private final String resultName;
    private String username;

    private Result(String resultName) {
        this.resultName = resultName;
    }

    public static Result of(String resultRaw) {
        return new Result(resultRaw);
    }

    public String getResultName() {
        return resultName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
