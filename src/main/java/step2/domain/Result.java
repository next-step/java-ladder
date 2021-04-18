package step2.domain;

import step2.util.StringUtils;

public class Result {
    private final String result;

    public Result(String result) {
        validationResult(result);
        this.result = result;
    }

    private void validationResult(String result) {
        if (StringUtils.isEmpty(result)) {
            throw new IllegalArgumentException("실행 결과값은 공백으로 입력하실 수 없습니다.");
        }
    }

    public String getResult() {
        return result;
    }
}
