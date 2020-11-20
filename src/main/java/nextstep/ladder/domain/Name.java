package nextstep.ladder.domain;

public class Name {
    public static final String INVALID_NAME_LENGTH_ERR_MSG = "이름은 1글자 이상 5글자 이하만 허용합니다.";
    private final String value;

    private Name(String value) {
        validateLength(value.length());
        this.value = value;
    }

    public static Name valueOf(String value) {
        return new Name(value);
    }

    private void validateLength(int length) {
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_ERR_MSG);
        }
    }
}
