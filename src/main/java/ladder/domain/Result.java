package ladder.domain;

public class Result {
    private final String result;

    private Result(String result) {
        this.result = result;
    }

    public static Result of(String result) {
        return new Result(result);
    }

}
