package ladder.domain;

import org.apache.commons.lang3.ObjectUtils;

public class InputResult {

    private static final int INPUT_RESULT_LENGTH_LIMIT = 5;
    private final String value;

    public InputResult(String value) {
        if (isEmptyOrNull(value)) {
            throw new IllegalArgumentException("한 글자 이상의 결과를 입력해주세요.");
        }
        validateTextLengthLimitOver(value);
        this.value = value;
    }

    private boolean isEmptyOrNull(String text) {
        return ObjectUtils.isEmpty(text);
    }

    private void validateTextLengthLimitOver(String value) {
        if (value.length() > INPUT_RESULT_LENGTH_LIMIT) {
            throw new IllegalArgumentException("사다리 결과는 " + INPUT_RESULT_LENGTH_LIMIT + "자 이하만 입력가능합니다.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
