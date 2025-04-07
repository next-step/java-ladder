package nextstep.ladder.domain;

public class Result {

    private final String result;

    public Result(String result) {
        checkEmptyResult(result);
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    private void checkEmptyResult(String result) {
        if (result == null || result.isEmpty()) {
            throw new IllegalArgumentException("결과는 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    public static Result of(String result) {
        return new Result(result);
    }
}
