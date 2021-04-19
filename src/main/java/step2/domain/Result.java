package step2.domain;

import step2.util.StringUtils;

public class Result {
    public static final String RESULT_IS_NOT_BLANK_EXCEPTION_MESSAGE = "실행 결과값은 공백일 수 없습니다.";

    private final String result;

    public Result(String result) {
        validationResult(result);
        this.result = result;
    }

    private void validationResult(String result) {
        if (StringUtils.isEmpty(result)) {
            throw new IllegalArgumentException(RESULT_IS_NOT_BLANK_EXCEPTION_MESSAGE);
        }
    }

    public String getResult() {
        return result;
    }
}
