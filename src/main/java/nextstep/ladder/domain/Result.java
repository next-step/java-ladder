package nextstep.ladder.domain;

public class Result {
    private static final int LENGTH_MINIMUM = 1;
    private static final String LENGTH_MINIMUM_MENTION = "결과는 %d글자 이상이어야 합니다.";

    private String result;

    private Result(String result) {
        checkEmptyResult(result);
        this.result = result;
    }

    public static Result of(String result) {
        return new Result(result);
    }

    private void checkEmptyResult(String result) {
        if(result == null || result.trim().length() < LENGTH_MINIMUM) {
            throw new IllegalArgumentException(String.format(LENGTH_MINIMUM_MENTION, LENGTH_MINIMUM));
        }
    }

    public String getResult() {
        return result;
    }
}
