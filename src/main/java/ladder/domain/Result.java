package ladder.domain;

public class Result {
    private final String result;

    public Result(String result) {
        this.result = result;
    }

    public static Result newInstance(String result) {
        return new Result(result);
    }

}
