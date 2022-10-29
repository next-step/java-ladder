package ladder.domain;

public class Result {

    private final String result;

    public Result(String result) {
        if (result == null || result.isEmpty()) {
            throw new IllegalArgumentException("결과값은 필수값입니다.");
        }
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
