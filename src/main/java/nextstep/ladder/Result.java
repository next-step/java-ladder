package nextstep.ladder;

public class Result {
    private final String result;

    private Result(String result) {
        this.result = result;
    }

    public static Result of(String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException("결과는 비어있을 수 없습니다.");
        }
        if (result.length() > 5) {
            throw new IllegalArgumentException("결과는 5자 이하여야 합니다.");
        }
        return new Result(result);
    }

    public String get() {
        return result;
    }
}
