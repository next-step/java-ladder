package ladder.model.result;

import java.util.Objects;

public class Result {

    private static final int RESULT_MAX_LENGTH = 5;
    private final String result;

    public Result(String result) {
        checkResultIsEmpty(result);
        checkResultLength(result);
        this.result = result;
    }

    private void checkResultIsEmpty(String result) {
        if(result == null || result.trim().isEmpty()) {
            throw new IllegalArgumentException("실행 결과가 null 이거나 비어있습니다.");
        }
    }

    private void checkResultLength(String result) {
        if(result.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException("실행 결과 길이는 " + RESULT_MAX_LENGTH + "를 넘으면 안됩니다.");
        }
    }

    public String get() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
