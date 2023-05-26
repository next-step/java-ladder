package ladder.domain;

import java.util.Objects;

public class Result {

    private final String resultName;

    public Result(String resultName) {
        validateName(resultName);
        this.resultName = resultName;
    }

    public String getResultName() {
        return resultName;
    }

    private void validateName(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("결과값은 null이거나 공백일 수 없습니다");
        }
    }
}
