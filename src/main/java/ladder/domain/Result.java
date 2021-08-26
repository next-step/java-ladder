package ladder.domain;

import java.util.Objects;

public class Result {

    private static final String FAILURE = "꽝";

    private static final int UNPAID = 0;

    private final String result;

    private Result(String result) {
        validate(result);
        this.result = result;
    }

    public static Result create(String result) {
        return new Result(result);
    }

    private void validate(String result) {
        if (FAILURE.equals(result)) {
            return;
        }
        if (isCompensationNegativeQuantity(result)) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }

    private boolean isCompensationNegativeQuantity(String result) {
        return compensation(result) < UNPAID;
    }

    private int compensation(String result) {
        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("꽝 또는 금액을 입력해 주세요. 입력된 결괏값 : " + result);
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
