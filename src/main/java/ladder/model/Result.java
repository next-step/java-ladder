package ladder.model;

public class Result {

    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException("결과를 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        return result;
    }
}
