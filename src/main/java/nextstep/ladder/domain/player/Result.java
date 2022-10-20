package nextstep.ladder.domain.player;

public class Result {
    private static final int MAX_LENGTH = 5;
    private static final String NULL_BLANK_EXCEPTION_MESSAGE = "사다리 결과는 Null 또는 공백 문자열을 허용하지 않습니다.";

    private final String value;

    public Result(String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException(NULL_BLANK_EXCEPTION_MESSAGE);
        }

        if (isOverSize(value)) {
            throw new IllegalArgumentException("결과 값은 " + MAX_LENGTH + " 길이 이하이어야 합니다.");
        }


        this.value = value.strip();
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.isBlank();
    }

    private boolean isOverSize(String value) {
        return value.strip().length() > MAX_LENGTH;
    }

    public String value() {
        return value;
    }
}
