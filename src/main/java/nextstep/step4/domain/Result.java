package nextstep.step4.domain;

public class Result {

    private int index;
    private final String result;

    private Result(int index, String result) {
        this.index = index;
        this.result = result;
    }

    public static Result of(int index, String result) {
        return new Result(index, result);
    }

    @Override
    public String toString() {
        return result;
    }
}
