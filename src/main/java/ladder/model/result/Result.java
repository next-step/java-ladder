package ladder.model.result;

import ladder.model.util.StringUtil;

import java.util.Objects;

public class Result {

    private static final int RESULT_MAX_LENGTH = 5;
    private final String result;

    public Result(String result) {
        checkValidation(result);
        this.result = result;
    }

    public String get() {
        return this.result;
    }

    private void checkValidation(String result) {
        if(StringUtil.isNullOrEmpty(result)) {
            throw new IllegalArgumentException("실행 결과가 null 이거나 비어있습니다.");
        }
        if(result.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException("실행 결과 길이는 " + RESULT_MAX_LENGTH + "를 넘으면 안됩니다.");
        }
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
