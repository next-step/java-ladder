package ladder.domain;

public class Result {
    public static final int START_COLUMN = 0;

    private int result;

    private Result(int result) {
        this.result = result;
    }

    public static Result create(int result) {
        return new Result(result);
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}
